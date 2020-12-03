/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.gii.ligaajedrez.modelo;

import java.sql.*;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author asins
 */
public class LigaTest {
    
    Liga l;
    public LigaTest() {
        try {
            l = new Liga();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LigaTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(LigaTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LigaTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LigaTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(LigaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testSetUsuario() {
    }

    @Test
    public void testCrearJugador() {
       JugadorModel jugador1 = new JugadorModel("Lucia",2,20,null,"Manolo","123456789");
       JugadorModel jugador2= new JugadorModel();
       Usuario u = new Usuario(jugador1.getName().toLowerCase(), jugador1.getName().toLowerCase(), jugador1);
       Usuario usuario = new Usuario();
       l.crearJugador("Lucia",2,20,"Manolo","123456789");
       for (JugadorModel jugador: l.getJugadores())
       {
            if (jugador == jugador1)
            {
                jugador2= jugador;
            }
       }
       for (Usuario usuari: l.getNewUsuarios())
       {
            if (usuari == u)
            {
                usuario = usuari;
            }
       }
       l.getNewUsuarios();
       assertTrue(jugador1==jugador2 && u==usuario);
    }

    @Test
    public void testModificarJugador() {
       JugadorModel player = new JugadorModel("Lucia",2,20,null,"Manolo","123456789");
       JugadorModel j = new JugadorModel("Lucia",5,20,null,"Manolo","123456789");
       JugadorModel jugador2= new JugadorModel();       
       l.getJugadores().add(player);
       
       l.modificarJugador("Lucia",5, 20, "Manolo","123456789", player);
       for (JugadorModel jugador: l.getJugadores())
       {
            if (jugador == j)
            {
                jugador2= jugador;
            }
       }
       assertTrue(j==jugador2);
    }

    @Test
    public void testModificarEntrenador() {
        ArrayList<EntrenadorModel> ent = l.getEntrenadores();
        EntrenadorModel entrenador = new EntrenadorModel("Entrenador1", "apellifo", "3/12/2020", "123456789");
        l.getEntrenadores().add(entrenador);
        l.modificarEntrenador("Entrenador 1 mod", "apellido mod", "3/12/1990", "987654321", entrenador);
        entrenador = new EntrenadorModel("Entrenador 1 mod", "apellido mod", "3/12/1990", "987654321");
        ent.add(entrenador);
        
        assertArrayEquals(ent.toArray(), l.getEntrenadores().toArray());
    }

    @Test
    public void testConsultarClubs() {
    }

    @Test
    public void testCrearTorneo() throws ParseException {
        FederacionModel federacio = new FederacionModel("Valencia");
        ArrayList<Club>  clubs = new ArrayList<Club> ();
        Torneo  torneo = new Torneo(federacio,new SimpleDateFormat("dd/MM/yyyy").parse("3/10/20"),clubs);
        Torneo t = new Torneo();
        l.crearTorneo(federacio.getId(), new SimpleDateFormat("dd/MM/yyyy").parse("3/10/20"),new int[]{1,2});
         for (Torneo torneo1: l.getTorneos())
       {
            if (torneo1 == torneo)
            {
                t= torneo1;
            }
       }
       assertTrue(t==torneo);
        
    }

    @Test
    public void testRegistrarMoroso() {
    }

    @Test
    public void testCrearPartida() {
    }

    @Test
    public void testConsultarTorneos() {
    }

    @Test
    public void testConsultarJugadores() {
    }

    @Test
    public void testConsultarTodosJugadores() {
    }

    @Test
    public void testConsultarSedes() {
    }

    @Test
    public void testConsultarFederaciones() {
    }

    @Test
    public void testConsultarPartidasJugador() {
    }

    @Test
    public void testTorneosDisponibles() {
    }

    @Test
    public void testCrearClub() {
    }

    @Test
    public void testReservarSede_3args() {
    }

    @Test
    public void testBuscarReserva() {
    }

    @Test
    public void testReservarSede_5args() {
    }

    @Test
    public void testRemoveJugadorMoroso() {
    }

    @Test
    public void testPagarMulta() {
    }

    @Test
    public void testSaveData() throws Exception {
    }

    @Test
    public void testLogin() {
    }

    @Test
    public void testSetGanadorPartida() {
    }

    @Test
    public void testEliminarJugador() {
    }

    @Test
    public void testNuevoEntrenador() {
    }

    @Test
    public void testConsultarEntrenadores() {
    }

    @Test
    public void testEliminarEntrenador() {
    }

    @Test
    public void testNuevoGerente() {
    }

    @Test
    public void testConsultarGerentes() {
    }

    @Test
    public void testEliminarGerente() {
    }

    @Test
    public void testRegistrarEnTorneo() {
    }

    @Test
    public void testModificarGerente() {
        GerenteModel geren = new GerenteModel("geren", "de prueba", "9-9-90", "555666777", "nomi", "irpff");
        l.getGerentes().add(geren);
        l.modificarGerente("modificado", "de prueba", "9-9-90", "555666777", "nomi", "irpff", geren);
        geren.setName("modificado");
        
        GerenteModel geren2 = l.getGerentes().get(l.getGerentes().indexOf(geren));
        
        assertSame(geren2, geren);
    }


    @Test
    public void testAsignarClubEntrenador() {
        EntrenadorModel entrenador= new EntrenadorModel("entrenador", "de prueba", "4-09-78", "666777888");
        l.getEntrenadores().add(entrenador);
        
        Club club = new Club();
        club.setName("otro club de prueba");
        l.getClubs().add(club);
        
        ArrayList<Club> clubs = (ArrayList<Club>) entrenador.getClubs();
        clubs.add(club);
       
        l.asignarClubEntrenador(entrenador, club);
        
        ArrayList<Club> clubsEntrenador = (ArrayList<Club>) entrenador.getClubs();
        
        assertArrayEquals(clubs.toArray(), clubsEntrenador.toArray());
    }

    @Test
    public void testAsignarClubGerente() {
      
        GerenteModel geren= new GerenteModel("gerente", "de prueba", "30-12-98", "666777888", "nomina", "irpf");
        l.getGerentes().add(geren);
        
        Club club = new Club();
        club.setName("club de prueba");
        
        l.getClubs().add(club);
        
        l.asignarClubGerente(geren, club);
        
        assertSame(geren.getClub(), club);
    }
    
}
