/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.gii.ligaajedrez.factory;

import es.uv.gii.ligaajedrez.modelo.Administrador;
import es.uv.gii.ligaajedrez.modelo.Jugador;
import es.uv.gii.ligaajedrez.modelo.Usuario;

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
