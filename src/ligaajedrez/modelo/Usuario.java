/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.modelo;

import java.util.ArrayList;

/**
 *
 * @author jbeltran
 */
public class Usuario {
    private String userName;
    private String userPass;
    private JugadorModel player;
    private Liga liga;

    public Usuario(String userName, String userPass, JugadorModel player, Liga liga) {
        this.userName = userName;
        this.userPass = userPass;
        this.player = player;
        this.liga = liga;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public JugadorModel getPlayer() {
        return player;
    }

    public void setPlayer(JugadorModel player) {
        this.player = player;
    }

    public Liga getLiga() {
        return liga;
    }

    public void setLiga(Liga liga) {
        this.liga = liga;
    }
    
    public ArrayList consultarClubs() {
        return liga.consultarClubs();
    }
    
    public ArrayList consultarTorneos() {
        return liga.consultarTorneos();
    }

    public ArrayList consultarJugadores() {
        return liga.consultarJugadores();
    }

    public ArrayList consultarSedes() {
        return liga.consultarSedes();
    }

    public ArrayList consultarFederaciones() {
        return liga.consultarFederaciones();
    }
    
    public ArrayList getTorneosDisponibles() {
        return liga.torneosDisponibles(player.getClub().getFederation());
    }
}
