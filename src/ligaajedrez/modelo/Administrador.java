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
 * @author jbeltran
 */
public class Administrador extends Usuario {
    private Club clubAct;
    
    public Administrador(Usuario usuario) {
        super(usuario);
    }
    
    public Administrador(String userName, String userPass, JugadorModel player, Liga liga) {
        super(userName, userPass, player, liga);
    }
    
    public void setClubAct(Object clubAct) {
        this.clubAct = (Club) clubAct;
    }
    
    public Object getClubAct() {
        return clubAct;
    }

    public void crearJugador(String name, int elo, int age, Object club, String responsableName, String responsablePhoneNumber) {
        getLiga().crearJugador(name, elo, age, club, responsableName, responsablePhoneNumber);
    }
   
    public void crearTorneo( int federacion, Date fecha, int[] clubs) {
        getLiga().crearTorneo(federacion, fecha, clubs);
    }

    public void crearPartida(int j1, int j2, int sede, Date fecha, Date h, int t) {
        getLiga().crearPartida(j1, j2, sede, fecha, h, t);
    }

    public void crearClub(String name, Object federation) {
        FederacionModel fed = (FederacionModel) federation;
        getLiga().crearClub(name, fed);
    }

    public ArrayList getJugadores() {
       return getLiga().consultarJugadores();
    }

    public void registrarMoroso(int jugador, String multa) 
    {
        getLiga().registrarMoroso(jugador,multa);
    }

    public ArrayList getTodosJugadores() {
        return getLiga().consultarTodosJugadores();
    }
}
