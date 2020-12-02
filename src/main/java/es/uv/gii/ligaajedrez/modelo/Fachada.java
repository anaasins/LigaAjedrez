/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.gii.ligaajedrez.modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author asins
 */
public class Fachada {
    static Liga liga;

    public Fachada(Liga liga) {
        this.liga = liga;
    }
    
    
     public static void crearJugador(String name, int elo, int age, String responsableName, String responsablePhoneNumber) {
        liga.crearJugador(name, elo, age, responsableName, responsablePhoneNumber);
    }
   
    public static void crearTorneo( int federacion, Date fecha, int[] clubs) {
        liga.crearTorneo(federacion, fecha, clubs);
    }

    public static void crearPartida(int j1, int j2, int sede, Date fecha, Date h, int t) {
        liga.crearPartida(j1, j2, sede, fecha, h, t);
    }

    public static void crearClub(String name, Object federation) {
        FederacionModel fed = (FederacionModel) federation;
        liga.crearClub(name, fed);
    }

    public static ArrayList getJugadores() {
       return liga.consultarJugadores();
    }

    public static void registrarMoroso(int jugador, String multa) 
    {
        liga.registrarMoroso(jugador,multa);
    }

    public static ArrayList getTodosJugadores() {
        return liga.consultarTodosJugadores();
    }

    public static boolean eliminarJugador(Object jug) {
       return liga.eliminarJugador(jug);
    }

    public static void nuevoEntrenador(String name, String surname, String birth, String phone) {
        liga.nuevoEntrenador(name, surname, birth, phone);
    }

    public static ArrayList getEntrenadores() {
       return liga.consultarEntrenadores();
    }

    public static boolean eliminarEntrenador(Object entrenador) {
        return liga.eliminarEntrenador(entrenador);
    }
    
    public static void nuevoGerente(String name, String surname, String birth, String phone, String nomina, String irpf) {
        liga.nuevoGerente(name, surname, birth, phone, nomina, irpf);
    }

    public static ArrayList getGerentes() {
       return liga.consultarGerentes();
    }

    public static boolean eliminarGerente(Object gerente) {
        return liga.eliminarGerente(gerente);
    }

    public static void modificarGerente(String name, String surname, String birth, String phone, String nomina, String irpf, GerenteModel gerente) {
        liga.modificarGerente(name, surname, birth, phone, nomina, irpf, gerente);
    }
    public static void asignarClubEntrenador(EntrenadorModel entrenador, Object club) {
        liga.asignarClubEntrenador(entrenador, (Club) club);
    }
    
    public static void asignarClubGerente(GerenteModel gerente, Object club) {
        liga.asignarClubGerente(gerente, (Club) club);

    }
    
    public static void pagarMulta()
    {
        liga.pagarMulta();
    }
    
    public static ArrayList consultarClubs() {
        return liga.consultarClubs();
    }
    
    public static ArrayList consultarTorneos() {
        return liga.consultarTorneos();
    }

    public static ArrayList consultarJugadores() {
        return liga.consultarJugadores();
    }

    public static ArrayList consultarSedes() {
        return liga.consultarSedes();
    }

    public static ArrayList consultarFederaciones() {
        return liga.consultarFederaciones();
    }
    public static ArrayList consultarEntrenadores(){
        return liga.consultaEntrenadores();
    }
    public static ArrayList getTorneosDisponibles() {
        return liga.torneosDisponibles();
    }

    public static boolean reservarSede(Date date, int hora, Usuario user) {
        return liga.reservarSede(date, hora, user);
    }
    
    public static ArrayList consultarPartidasJugador() {
        return liga.consultarPartidasJugador();
    }
    
    public static void modificarJugador(String name, int elo, int age, String responsableName, String responsablePhoneNumber, Object playerModel) {
        liga.modificarJugador(name, elo, age, responsableName, responsablePhoneNumber, playerModel);
    }
    
    public static void modificarEntrenador(String name, String surname, String  birth, String phone, Object entrendorModel)
    {
        liga.modificarEntrenador(name, surname, birth, phone,entrendorModel);
    }
   
    
    public static void registrarEnTorneo() {
        liga.registrarEnTorneo();
    }
}
