/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.modelo;

import java.sql.Time;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jbeltran
 */
public class Administrador extends Usuario {

    private Liga liga;

    public Administrador(Liga liga) {
        this.liga = liga;
    }

    public void crearJugador(String name, int elo, int age, String responsableName, String responsablePhoneNumber) {
        liga.crearJugador(name, elo, age, responsableName, responsablePhoneNumber);
    }

    public ArrayList consultarClubs() {
        return liga.consultarClubs();
    }

    public void crearTorneo(FederacionModel federacion, Date fecha, ArrayList<Club> clubs) {
        liga.crearTorneo(federacion, fecha, clubs);
    }

    public void crearPartida(JugadorModel j1, JugadorModel j2, String sede, Date fecha, Time h, Torneo t) {
        liga.crearPartida(j1, j2, sede, fecha, h, t);
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

    public void crearClub(String name, Object federation) {
        FederacionModel fed = (FederacionModel) federation;
        liga.crearClub(name, fed);
    }

}
