/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.modelo;


import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;

/**
 *
 * @author jbeltran
 */
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="usuarioSeq")
    @SequenceGenerator(name="usuarioSeq",sequenceName="usuarioSeq", allocationSize=1, initialValue = 1)
    private int id;
    private String userName;
    private String userPass;
    @ManyToOne
    @JoinColumn(name = "playerId", referencedColumnName = "id")
    private JugadorModel player;
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isAdmin;
    @Transient
    private Liga liga;
    @Transient
    private Partida partidaAct;
    @Transient
    private Club clubAct;
    @Transient
    private Torneo torneoAct;

    public Usuario() {}
    
    public Usuario(Usuario usuario) {
        id = usuario.getId();
        userName = usuario.getUserName();
        userPass = usuario.getUserName();
        player = usuario.getPlayer();
        isAdmin = usuario.isAdmin();
    }
    
    public Usuario(String userName, String userPass, JugadorModel player) {
        this.userName = userName;
        this.userPass = userPass;
        this.player = player;
    }
    
    public Usuario(String userName, String userPass, JugadorModel player, boolean isAdmin) {
        this.userName = userName;
        this.userPass = userPass;
        this.player = player;
        this.isAdmin = isAdmin;
    }
    
    public Usuario(String userName, String userPass, JugadorModel player, Liga liga) {
        this.userName = userName;
        this.userPass = userPass;
        this.player = player;
        this.liga = liga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Liga getLiga() {
        return liga;
    }

    public void setLiga(Liga liga) {
        this.liga = liga;
    }
    
    public void setClubAct(Object clubAct) {
        this.clubAct = (Club) clubAct;
    }
    
    public Object getClubAct() {
        return clubAct;
    }
    
    public void saveData() {
        liga.saveData();
    }
    
    public boolean isMoroso() {
        return player.getMoroso();
    }
    
    public boolean isAdmin() {
        return isAdmin;
    }

    

    public void setPartidaAct(Object partida) {
        partidaAct = (Partida) partida;
    }

    public void setGanadorPartida(Object ganador) {
        liga.setGanadorPartida(partidaAct, ganador);
    }
    
    

    public Torneo getTorneoAct() {
        return torneoAct;
    }

    public void setTorneoAct(Torneo torneoAct) {
        this.torneoAct = torneoAct;
    }
    
     public ArrayList consultarMisClubs() {
        ArrayList clubs = new ArrayList();
        for (Club club :this.player.getClubs())
        {
            clubs.add(club);
        }
      return clubs;
    }
     
     public ArrayList consultarJugadoresPartida() {
        ArrayList jsm = new ArrayList();
        
        jsm.add(partidaAct.getJugador1());
        jsm.add(partidaAct.getJugador2());
        
        return jsm;
    }
}
