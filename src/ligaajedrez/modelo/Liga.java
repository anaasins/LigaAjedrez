/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.modelo;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ligaajedrez.db.DB;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author asins
 */
public class Liga {
    private ArrayList<JugadorModel> jugadores;
    private ArrayList<JugadorModel> jugadoresMorosos;
    private ArrayList<EntrenadorModel> entrenadores;
    private ArrayList<Club> clubs;
    private ArrayList<Torneo> torneos;
    private ArrayList<Sede> sedes;
    private ArrayList<Reserva> reservas;
    private ArrayList<FederacionModel> federaciones;
    private ArrayList<Partida> partidas;
    private ArrayList<Usuario> newUsuarios;
    private ArrayList<GerenteModel> gerentes;
    private DB db;
    
    public Liga()
    {
        // Get db connection
        db = DB.getDB();
        
        // Create initial test data
        //db.createInitialData();
        
        // Get data from db
        List<Criterion> criterions = new ArrayList<Criterion>();
        criterions.add(Restrictions.eq("moroso", false));
        jugadores = (ArrayList<JugadorModel>) db.getFiltered(JugadorModel.class, criterions);
        criterions = new ArrayList<Criterion>();
        criterions.add(Restrictions.eq("moroso", true));
        jugadoresMorosos = (ArrayList<JugadorModel>) db.getFiltered(JugadorModel.class, criterions);
        clubs = (ArrayList<Club>) db.getAll(Club.class);
        torneos = (ArrayList<Torneo>) db.getAll(Torneo.class);
        sedes = (ArrayList<Sede>) db.getAll(Sede.class);
        reservas = (ArrayList<Reserva>) db.getAll(Reserva.class);
        federaciones = (ArrayList<FederacionModel>) db.getAll(FederacionModel.class);
        partidas = (ArrayList<Partida>) db.getAll(Partida.class);
        newUsuarios = new ArrayList<>();
        entrenadores = (ArrayList<EntrenadorModel>) db.getAll(EntrenadorModel.class);
        gerentes = (ArrayList<GerenteModel>) db.getAll(GerenteModel.class);
    }
    
     public void crearJugador(String name, int elo, int age, Object club, String responsableName, String responsablePhoneNumber) {
        JugadorModel player = new JugadorModel(name, elo, age, (Club) club, responsableName, responsablePhoneNumber);
        jugadores.add(player);
        Usuario u = new Usuario(player.getName().toLowerCase(), player.getName().toLowerCase(), player);
        newUsuarios.add(u);
    }
     
    public void modificarJugador(String name, int elo, int age, Object club, String responsableName, String responsablePhoneNumber, Object playerModel) {
        JugadorModel player = jugadores.get(jugadores.indexOf((JugadorModel) playerModel));
        player.setName(name);
        player.setElo(elo);
        player.setAge(age);
        player.setClub((Club) club);
        player.setResponsableName(responsableName);
        player.setReponsablePhoneNumber(responsablePhoneNumber);
    }
    
    public void modificarEntrenador (String name, String surname, String  birth, String phone, Object entranadorModel)
    {
        EntrenadorModel entrenador = entrenadores.get(entrenadores.indexOf((JugadorModel) entranadorModel));
        entrenador.setName(name);
        entrenador.setSurname(surname);
        entrenador.setBirth(birth);
        entrenador.setPhone(phone);       
    }

    public ArrayList consultarClubs() {
        ArrayList listaClubs = new ArrayList();

        for (Club club : clubs) {
            listaClubs.add(club);
        }
        return listaClubs;
    }

    public void crearTorneo(int federacion, Date fecha, int[] clubs) {
        Torneo tor;
        ArrayList<Club> c = new ArrayList<>();
        for (int club : clubs)
            c.add(this.clubs.get(club));
        tor = new Torneo(this.federaciones.get(federacion), fecha, c);
        torneos.add(tor);
    }
    public void registrarMoroso(int jugador, String multa)
    {
        JugadorModel  jM;
        jM = this.jugadores.get(jugador);
        jM.setMoroso(true);
        jM.setMulta(Integer.parseInt(multa));
        jugadoresMorosos.add(jM);
        jugadores.remove(this.jugadores.get(jugador));        
    }
    public void crearPartida(int j1, int j2, int sede, Date fecha, Date h, int t) {
        Partida p;
        p = new Partida(jugadores.get(j1), jugadores.get(j2), sedes.get(sede), fecha, h, torneos.get(t));
        partidas.add(p);
    }

    public ArrayList consultarTorneos() {
        ArrayList<Torneo> t = new ArrayList<Torneo>();

        for (Torneo torneo : torneos) {
            t.add(torneo);
        }
        return t;
    }

    public ArrayList consultarJugadores() {
        ArrayList<JugadorModel> j = new ArrayList<JugadorModel>();

        for (JugadorModel jugador : jugadores) {
            j.add(jugador);
        }
        return j;
    }
    
    public ArrayList consultarTodosJugadores() {
        ArrayList<String> j = new ArrayList<String>();

        for (JugadorModel jugador : jugadores) {
            j.add(jugador.getName()+"\t\t-"+jugador.getMoroso());
        }
        for (JugadorModel jugador : jugadoresMorosos) {
            j.add(jugador.getName()+"\t"+"\t"+"-"+jugador.getMoroso());
        }
        return j;
    }

    public ArrayList consultarSedes() {
        ArrayList<Sede> s = new ArrayList<Sede>();

        for (Sede sede : sedes) {
            s.add(sede);
        }
        return s;
    }

    public ArrayList consultarFederaciones() {
        ArrayList<Object> f = new ArrayList<Object>();

        for (FederacionModel fede : federaciones) {
            f.add(fede);
        }
        return f;
    }
    
    public ArrayList consultarPartidasJugador(JugadorModel jm) {
        ArrayList<Object> p = new ArrayList<Object>();

        for (Partida partida : partidas) {
            if (partida.getJugador1() == jm || partida.getJugador2() == jm)
                p.add(partida);
        }
        return p;
    }

    ArrayList torneosDisponibles(FederacionModel miFederacion) {
       ArrayList<Torneo> disponibles;
       disponibles = new ArrayList<Torneo>();
       
       for(Torneo t:torneos)
       {
           if(t.getFederacion()==miFederacion)
               disponibles.add(t);
       }
       
       return disponibles;
    }

    void crearClub(String name, FederacionModel fed) {
        Club club = new Club(name, fed, null);
        clubs.add(club);
    }

    boolean reservarSede(Date date, int hora, Sede s, Usuario user) {
        Reserva res = buscarReserva(date, hora, s);
        return reservarSede(res, date, hora, user, s);
    }
    
    Reserva buscarReserva(Date date, int hora, Sede s) {
        Reserva definitiva=null;
       for(Reserva r:reservas)
       {
           if(r.getInicio()==date && r.getHora()==hora && r.getSede() == s)
               definitiva=r;
       }
       return definitiva;
    }
    
    boolean reservarSede(Reserva reserva, Date date, int hora, Usuario user, Sede s) {
        Reserva r;
        boolean ok= true;
        if(reserva != null && reserva.getContador()<2)
        {
            reserva.setContador(reserva.getContador()+1);
        }
        else if(reserva == null)
        {
            r= new Reserva(user, date, hora, s);
            reservas.add(r);
        }
        else if(reserva != null && reserva.getContador()>=2)
        {
            ok=false;
        }
        return ok;
    }
    
    void removeJugadorMoroso(JugadorModel aThis) {
        jugadoresMorosos.remove(aThis);
    }  
    void pagarMulta(JugadorModel j)
    {
        j.setMoroso(false);
        j.setMulta(0);
        jugadoresMorosos.remove(j);
        jugadores.add(j);
    }
    
    public void saveData() {
        Session session = db.getSession();
        Transaction t = session.beginTransaction();
        jugadores.forEach((jugador) -> {
            session.saveOrUpdate(jugador);
        });
        jugadoresMorosos.forEach((jugador) -> {
            session.saveOrUpdate(jugador);
        });
        clubs.forEach((club) -> {
            session.saveOrUpdate(club);
        });
        torneos.forEach((torneo) -> {
            session.saveOrUpdate(torneo);
        });
        sedes.forEach((sede) -> {
            session.saveOrUpdate(sede);
        });
        reservas.forEach((reserva) -> {
            session.saveOrUpdate(reserva);
        });
        federaciones.forEach((federacion) -> {
            session.saveOrUpdate(federacion);
        });
        partidas.forEach((partida) -> {
            session.saveOrUpdate(partida);
        });
        newUsuarios.forEach((usuario) -> {
            session.save(usuario);
        });
        entrenadores.forEach((entrenador)->{
            session.saveOrUpdate(entrenador);
        });
        gerentes.forEach((gerente)->{
            session.saveOrUpdate(gerente);
        });
        t.commit();
    }

    public Usuario login(String user, String pass) {
        Usuario usuario = null;
        List<Criterion> criterions = new ArrayList<Criterion>();
        
        criterions.add(Restrictions.eq("userName", user));
        criterions.add(Restrictions.eq("userPass", pass));
        usuario = db.getFiltered(Usuario.class, criterions).get(0);
        
        if (usuario != null && usuario.isAdmin())
            usuario = new Administrador(usuario);
        else
            usuario = new Jugador(usuario);
        
        return usuario;
    }

    void setGanadorPartida(Partida partidaAct, Object ganador) {
        for (Partida partida : partidas) {
            if (partida == partidaAct) {
                partida.setGanador((JugadorModel) ganador);
            }
        }
    }

    boolean eliminarJugador(Object jug) {
        JugadorModel j = (JugadorModel) jug;
        Session session = db.getSession();
        Transaction t = session.beginTransaction();
        session.delete(jug);
        t.commit();
        return jugadores.remove(jug); 
    }

    void nuevoEntrenador(String name, String surname, String birth, String phone) {
        EntrenadorModel entrenador = new EntrenadorModel(name, surname, birth, phone);
        entrenadores.add(entrenador);
    }

    public ArrayList consultarEntrenadores() {
        ArrayList<EntrenadorModel> m = new ArrayList<EntrenadorModel>();
        
        for (EntrenadorModel entrenador : entrenadores) {
            m.add(entrenador);
        }
        return m;
    }

    boolean eliminarEntrenador(Object entrenador) {
        EntrenadorModel e = (EntrenadorModel) entrenador;
        
        Session session = db.getSession();
        Transaction t = session.beginTransaction();
        session.delete(entrenador);
        t.commit();
        
        return entrenadores.remove(entrenador);
    }
    
     void nuevoGerente(String name, String surname, String birth, String phone, String nomina, String irpf) {
        GerenteModel gerente = new GerenteModel(name, surname, birth, phone, nomina, irpf);
        gerentes.add(gerente);
    }

    public ArrayList consultarGerentes() {
        ArrayList<GerenteModel> m = new ArrayList<GerenteModel>();
        
        for (GerenteModel gerente : gerentes) {
            m.add(gerente);
        }
        return m;
    }

    boolean eliminarGerente(Object gerente) {
        GerenteModel e = (GerenteModel) gerente;
        
        Session session = db.getSession();
        Transaction t = session.beginTransaction();
        session.delete(gerente);
        t.commit();
        
        return gerentes.remove(gerente);
    }

    void registrarEnTorneo(Torneo torneoAct, JugadorModel player) {
        Torneo torneo = torneos.get(torneos.indexOf(torneoAct));
        torneo.getParticipantes().add(player);
    }

    public ArrayList consultaEntrenadores() {
        ArrayList<EntrenadorModel> ListaEntrenadores = new ArrayList<EntrenadorModel>();

        for (EntrenadorModel entrenador : entrenadores) {
            ListaEntrenadores.add(entrenador);
        }
        return ListaEntrenadores;
    }

    void asignarClubEntrenador(EntrenadorModel entrenadorAct, Club club) {
        EntrenadorModel entrenador = entrenadores.get(entrenadores.indexOf(entrenadorAct));
        entrenador.getClubs().add(club);
    }
    
    void asignarClubGerente(GerenteModel gerenteAct, Club club) {
        GerenteModel gerente = gerentes.get(gerentes.indexOf(gerenteAct));
        gerente.setClub(club);
    }
}
