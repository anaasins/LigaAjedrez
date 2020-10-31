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
public class Jugador extends Usuario {
    public Jugador(Liga liga) {
        this.liga = liga;
    }
    
    public ArrayList getTorneosDisponibles() {
        return super.liga.torneosDisponibles(super.getPlayer().getClub().getFederation());
    }
}
