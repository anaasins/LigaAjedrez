/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.gii.ligaajedrez.modelo;

import java.sql.*;
import java.text.ParseException;
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
    public void testCrearTorneo() {
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
    }

    @Test
    public void testConsultaEntrenadores() {
    }

    @Test
    public void testAsignarClubEntrenador() {
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
