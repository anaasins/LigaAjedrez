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
public class Usuario {
    private String userName;
    private String userPass;
    private JugadorModel player;
    protected Liga liga;

    public Usuario() {
    }

    public Usuario(String userName, String userPass, JugadorModel player) {
        this.userName = userName;
        this.userPass = userPass;
        this.player = player;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public JugadorModel getPlayer() {
        return player;
    }

    public void setPlayer(JugadorModel player) {
        this.player = player;
    }
}
