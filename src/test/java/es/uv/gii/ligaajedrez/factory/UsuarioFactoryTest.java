/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.gii.ligaajedrez.factory;

import es.uv.gii.ligaajedrez.modelo.Administrador;
import es.uv.gii.ligaajedrez.modelo.Jugador;
import es.uv.gii.ligaajedrez.modelo.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author asins
 */
public class UsuarioFactoryTest {
    
    public UsuarioFactoryTest() {
    }
    
    @Test
    public void testcrearUsuario()
    {
        Usuario user = new Usuario();
        user.setUserName("pepe");
        user.setId(90);
        user.setUserPass("pepe");
        user.setAdmin(false);
        user=UsuarioFactory.crearUsuario(user);
        //asser true de buscar el jugador y aseert false dw que siga un admin per ejemple
        assertTrue(user instanceof Jugador);
        //despres cree un altre usuari que siga admin i comprobe true de que siga admin i false de que siga jugador
         user.setUserName("AdminPepe");
        user.setId(90);
        user.setUserPass("AdminPepe");
        user.setAdmin(true);
        user=UsuarioFactory.crearUsuario(user);
        assertTrue(user instanceof Administrador);
        
    }
    
}
