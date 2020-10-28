/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.modelo;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author jbeltran
 */
public class Administrador extends Usuario {
    List<JugadorModel> jugadores;
    
    public Administrador() {
        jugadores = new ArrayList();
    }

    public void crearJugador(String name, int elo, int age, String responsableName, String responsablePhoneNumber) {
        JugadorModel player = new JugadorModel(name, elo, age, responsableName, responsablePhoneNumber);
        jugadores.add(player);
    }
    
}
