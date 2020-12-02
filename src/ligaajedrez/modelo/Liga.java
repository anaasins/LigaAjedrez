/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.modelo;


import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ligaajedrez.dao.ClubDao;
import ligaajedrez.dao.EntrenadorDao;
import ligaajedrez.dao.FederacionDao;
import ligaajedrez.dao.GerenteModelDao;
import ligaajedrez.dao.JugadorModelDao;
import ligaajedrez.dao.PartidaDao;
import ligaajedrez.dao.ReservaDao;
import ligaajedrez.dao.SedeDao;
import ligaajedrez.dao.TorneoClubDao;
import ligaajedrez.dao.TorneoDao;
import ligaajedrez.dao.TorneoParticipanteDao;
import ligaajedrez.dao.UsuarioDao;
import ligaajedrez.db.DB;
import ligaajedrez.factory.UsuarioFactory;
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
    private ArrayList<Usuario> usuarios;
    private ArrayList<GerenteModel> gerentes;
    private DB db;
    private Usuario userAct;
    
    private ClubDao club;
    private EntrenadorDao entrenador;
    private FederacionDao federacion;
    private GerenteModelDao gerente;
    private JugadorModelDao jugador;
    private PartidaDao partida;
     private ReservaDao reserva;
    private SedeDao sede;
    private TorneoClubDao torneoClub;
    private TorneoDao torneo;
    private TorneoParticipanteDao torneoParticipante;
    private UsuarioDao usuarioDao;
    
    public Liga() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ParseException
    {
        // Get db connection
        //db = DB.getDB();
        
        // Create initial test data
        //db.createInitialData();
        
        jugador = new JugadorModelDao();
        entrenador = new EntrenadorDao();
        club = new ClubDao();
        torneo = new TorneoDao();
        sede = new SedeDao();
        reserva = new ReservaDao();
        federacion = new FederacionDao();
        partida = new PartidaDao();
        usuarioDao = new UsuarioDao();
        gerente = new GerenteModelDao();
        
        // Llegir 
        jugadores = jugador.selectMoroso(false);
        jugadoresMorosos = jugador.selectMoroso(true);
        entrenadores = (ArrayList<EntrenadorModel>)entrenador.selectAll();
        clubs = club.leerClubs();
        torneos = (ArrayList<Torneo>)torneo.selectAll();
        sedes = (ArrayList<Sede>)sede.selectAll();
        reservas = (ArrayList<Reserva>)reserva.selectAll();
        federaciones = (ArrayList<FederacionModel>) federacion.selectAll();
        partidas = (ArrayList<Partida>)partida.selectAll();
        usuarios = (ArrayList<Usuario>)usuarioDao.selectAll();
        gerentes = (ArrayList<GerenteModel>) gerente.selectAll();
                
    }
    
    public void setUsuario(Usuario user)
    {
        userAct = user;
    }
    
     public void crearJugador(String name, int elo, int age, String responsableName, String responsablePhoneNumber) {
        JugadorModel player = new JugadorModel(name, elo, age,(Club) userAct.getClubAct(), responsableName, responsablePhoneNumber);
        jugadores.add(player);
        Usuario u = new Usuario(player.getName().toLowerCase(), player.getName().toLowerCase(), player);
        newUsuarios.add(u);
    }
     
    public void modificarJugador(String name, int elo, int age, String responsableName, String responsablePhoneNumber, Object playerModel) {
        JugadorModel player = jugadores.get(jugadores.indexOf((JugadorModel) playerModel));
        player.setName(name);
        player.setElo(elo);
        player.setAge(age);
        player.setClub((Club) userAct.getClubAct());
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
    
    public ArrayList consultarPartidasJugador() {
        JugadorModel jm = userAct.getPlayer();
        ArrayList<Object> p = new ArrayList<Object>();

        for (Partida partida : partidas) {
            if (partida.getJugador1() == jm || partida.getJugador2() == jm)
                p.add(partida);
        }
        return p;
    }

    ArrayList torneosDisponibles() {
        FederacionModel miFederacion = userAct.getPlayer().getClub().getFederation();
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

    boolean reservarSede(Date date, int hora, Usuario user) {
        Sede s = userAct.getPlayer().getClub().getSede();
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
    void pagarMulta()
    {
        JugadorModel j = userAct.getPlayer();
        j.setMoroso(false);
        j.setMulta(0);
        jugadoresMorosos.remove(j);
        jugadores.add(j);
    }
    
    public void saveData() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //Session session = db.getSession();
        //Transaction t = session.beginTransaction();
        for (JugadorModel jugador : jugadores) {
            if (jugador.getId() == 0)
                new JugadorModelDao().insert(jugador);
            else
                new JugadorModelDao().update(jugador);
        }
        for (JugadorModel jugador : jugadoresMorosos) {
            if (jugador.getId() == 0)
                new JugadorModelDao().insert(jugador);
            else
                new JugadorModelDao().update(jugador);
        }
        for (Club club : clubs) {
            if (club.getId() == 0)
                new ClubDao().insertarClub(club);
            else
                new ClubDao().actualizarClub(club);
        }
        for (Torneo torneo : torneos) {
            if (torneo.getId() == 0)
                new TorneoDao().insert(torneo);
            else
                new TorneoDao().update(torneo);
        }
        for (Sede sede : sedes) {
            if (sede.getId() == 0)
                new SedeDao().insertSede(sede);
        }
        for (Reserva reserva : reservas) {
            if (reserva.getId() == 0)
                new ReservaDao().insert(reserva);
            else
                new ReservaDao().update(reserva);
        }
        for (FederacionModel federacion : federaciones) {
            if (federacion.getId() == 0)
                new FederacionDao().insert(federacion.getId(), federacion.getCity());
            else
                new FederacionDao().update(federacion.getId(), federacion.getCity());
        }
        for (Partida partida : partidas) {
            if (partida.getId() == 0)
                new PartidaDao().insert(partida);
            else
                new PartidaDao().update(partida);
        }
        for (Usuario usuario : newUsuarios) {
            if (usuario.getId() == 0)
                new UsuarioDao().insert(usuario);
            else
                new UsuarioDao().update(usuario);
        }
        for (EntrenadorModel entrenador : entrenadores) {
            if (entrenador.getId() == 0)
                new EntrenadorDao().insert(entrenador);
            else
                new EntrenadorDao().update(entrenador);
        }
        for (GerenteModel gerente : gerentes) {
            if (gerente.getId() == 0)
                new GerenteModelDao().insert(gerente);
            else
                new GerenteModelDao().update(gerente);
        }
    }

    public Usuario login(String user, String pass) {
        Usuario usuario = null;
        //List<Criterion> criterions = new ArrayList<Criterion>();
        
        //criterions.add(Restrictions.eq("userName", user));
        //criterions.add(Restrictions.eq("userPass", pass));
        //usuario = db.getFiltered(Usuario.class, criterions).get(0);
        for (Usuario u : usuarios)
            if (u.getUserName().equalsIgnoreCase(user) && u.getUserPass().equalsIgnoreCase(pass))
                usuario = u;
        
        usuario = UsuarioFactory.crearUsuario(usuario);

        
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

    void registrarEnTorneo() {
        Torneo torneoAct = userAct.getTorneoAct();
        JugadorModel player = userAct.getPlayer();
        Torneo torneo = torneos.get(torneos.indexOf(torneoAct));
        torneo.getParticipantes().add(player);
    }


    void modificarGerente(String name, String surname, String birth, String phone, String nomina, String irpf, GerenteModel gerenteModel) {
        GerenteModel gerente = gerentes.get(gerentes.indexOf((GerenteModel) gerenteModel));
        gerente.setName(name);
        gerente.setSurname(surname);
        gerente.setBirth(birth);
        gerente.setPhone(phone);
        gerente.setIrpf(irpf);
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
