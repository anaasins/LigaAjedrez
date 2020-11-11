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
    private ArrayList<Club> clubs;
    private ArrayList<Torneo> torneos;
    private ArrayList<Sede> sedes;
    private ArrayList<FederacionModel> federaciones;
    private ArrayList<Partida> partidas;
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
        federaciones = (ArrayList<FederacionModel>) db.getAll(FederacionModel.class);
        partidas = (ArrayList<Partida>) db.getAll(Partida.class);
    }
    
     public void crearJugador(String name, int elo, int age, Object club, String responsableName, String responsablePhoneNumber) {
        JugadorModel player = new JugadorModel(name, elo, age, (Club) club, responsableName, responsablePhoneNumber);
        jugadores.add(player);
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
        Reserva res = s.buscarReserva(date, hora);
       return s.reservarSede(res, date, hora, user);
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
        federaciones.forEach((federacion) -> {
            session.saveOrUpdate(federacion);
        });
        partidas.forEach((partida) -> {
            session.saveOrUpdate(partida);
        });
        t.commit();
    }

    public Usuario login(String user, String pass) {
        Usuario usuario = null;
        List<Criterion> criterions = new ArrayList<Criterion>();
        
        criterions.add(Restrictions.eq("userName", user));
        criterions.add(Restrictions.eq("userPass", pass));
        usuario = db.getFiltered(Usuario.class, criterions).get(0);
        
        return usuario;
    }
}
