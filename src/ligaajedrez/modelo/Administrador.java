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
    public Administrador(Usuario usuario) {
        super(usuario);
    }
    
    public Administrador(String userName, String userPass, JugadorModel player, Liga liga) {
        super(userName, userPass, player, liga);
    }

    public void crearJugador(String name, int elo, int age, String responsableName, String responsablePhoneNumber) {
        getLiga().crearJugador(name, elo, age, getClubAct(), responsableName, responsablePhoneNumber);
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

    public boolean eliminarJugador(Object jug) {
       return getLiga().eliminarJugador(jug);
    }

    public void nuevoEntrenador(String name, String surname, String birth, String phone) {
        getLiga().nuevoEntrenador(name, surname, birth, phone);
    }

    public ArrayList getEntrenadores() {
       return getLiga().consultarEntrenadores();
    }

    public boolean eliminarEntrenador(Object entrenador) {
        return getLiga().eliminarEntrenador(entrenador);
    }
    
    public void nuevoGerente(String name, String surname, String birth, String phone, String nomina, String irpf) {
        getLiga().nuevoGerente(name, surname, birth, phone, nomina, irpf);
    }

    public ArrayList getGerentes() {
       return getLiga().consultarGerentes();
    }

    public boolean eliminarGerente(Object gerente) {
        return getLiga().eliminarGerente(gerente);
    }

    public void asignarClubEntrenador(EntrenadorModel entrenador, Object club) {
        getLiga().asignarClubEntrenador(entrenador, (Club) club);
    }
    
    public void asignarClubGerente(GerenteModel gerente, Object club) {
        getLiga().asignarClubGerente(gerente, (Club) club);
    }
}
