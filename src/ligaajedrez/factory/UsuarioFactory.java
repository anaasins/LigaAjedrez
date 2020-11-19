/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.factory;

import ligaajedrez.modelo.Administrador;
import ligaajedrez.modelo.Jugador;
import ligaajedrez.modelo.Usuario;

/**
 *
 * @author asins
 */
public class UsuarioFactory {
    
    
    public static Usuario crearUsuario(Usuario user)
    {
        Usuario usuario;
        if(user!=null && user.isAdmin())
            usuario = new Administrador(user);
        else
            usuario = new Jugador(user);
        
        return usuario;
    }
}
