/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.modelo;



/**
 *
 * @author jbeltran
 */
public class Jugador extends Usuario {
    
    public Jugador(Usuario usuario) {
        super(usuario);
    }
    
    public Jugador(String userName, String userPass, JugadorModel player, Liga liga) {
        super(userName, userPass, player, liga);
    }
    
    
    public String getMulta()
    {
        return getPlayer().getMulta() + "";
    }
}
