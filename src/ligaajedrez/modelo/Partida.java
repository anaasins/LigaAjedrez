/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.modelo;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Olaf
 */
public class Partida {
    private JugadorModel jugador1;
    private JugadorModel jugador2;
    private String sede;
    private Date fechaPartida;
    private Time hora;
    private Torneo torneo;
    
    public Partida (JugadorModel j1,JugadorModel j2, String s,Date fp,Time h,Torneo t)
    {
        this.setJugador1(j1);
        this.setJugador2(j2);
        this.setSede(s);
        this.setFechaPartida(fp);
        this.setHora(h);
        this.setTorneo(t);   
 
    }

    public void setFechaPartida(Date fp) {
        fechaPartida=fp;
    }

    public void setHora(Time h) {
        hora=h;
    }

    public void setTorneo(Torneo t) {
        torneo=t;
    }

    public void setSede(String s) {
       sede=s;
    }
    public void setJugador1(JugadorModel j1) {
     jugador1= j1;
    }
    public void setJugador2(JugadorModel j2) {
     jugador2= j2;
    }
    public Date getFechaPartida()
    {
        return fechaPartida;
    }
    public Time getHora()
    {
        return hora;
    }
    public Torneo getToreno()
    {
        return torneo;
    }

    public JugadorModel getJugador1()
    {
        return jugador1;
    }
    public JugadorModel getJugador2()
    {
        return jugador2;
    }
       
}
