/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.modelo;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author asins
 */
public class Liga {
    private ArrayList<JugadorModel> jugadores;
    private ArrayList<Club> clubs;
    private ArrayList<Torneo> torneos;
    private ArrayList<String> sedes;
    private ArrayList<FederacionModel> federaciones;
    private ArrayList<Partida> partidas;
    
    public Liga()
    {
        jugadores = new ArrayList();
        clubs = new ArrayList();
        torneos = new ArrayList();
        sedes = new ArrayList();
        federaciones = new ArrayList();
        federaciones.add(new FederacionModel("Valencia"));
        federaciones.add(new FederacionModel("Madrid"));
        partidas = new ArrayList();
    }
    
     public void crearJugador(String name, int elo, int age, String responsableName, String responsablePhoneNumber) {
        JugadorModel player = new JugadorModel(name, elo, age, responsableName, responsablePhoneNumber);
        jugadores.add(player);
    }

    public ArrayList consultarClubs() {
        ArrayList<String> listaClubs = new ArrayList<String>();

        for (Club club : clubs) {
            listaClubs.add(club.toString());
        }
        return listaClubs;
    }

    public void crearTorneo(FederacionModel federacion, Date fecha, ArrayList<Club> clubs) {
        Torneo tor;
        tor = new Torneo(federacion, fecha, clubs);
        torneos.add(tor);
    }

    public void crearPartida(JugadorModel j1, JugadorModel j2, String sede, Date fecha, Time h, Torneo t) {
        Partida p;
        p = new Partida(j1, j2, sede, fecha, h, t);
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

    public ArrayList consultarSedes() {
        ArrayList<String> s = new ArrayList<String>();

        for (String sede : sedes) {
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
        Club club = new Club(name, fed);
        clubs.add(club);
    }
}
