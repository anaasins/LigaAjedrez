/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.modelo;

import java.util.Date;

/**
 *
 * @author Olaf
 */
public class Partida {
    private int id;
    private JugadorModel jugador1;
    private JugadorModel jugador2;
    private Sede sede;
    private Date fechaPartida;
    private Date hora;
    private Torneo torneo;
    private JugadorModel ganador;
    
    public Partida() {}
    
    public Partida (JugadorModel j1,JugadorModel j2, Sede s,Date fp,Date h,Torneo t)
    {
        this.setJugador1(j1);
        this.setJugador2(j2);
        this.setSede(s);
        this.setFechaPartida(fp);
        this.setHora(h);
        this.setTorneo(t);   
 
    }

    public Sede getSede() {
        return sede;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFechaPartida(Date fp) {
        fechaPartida=fp;
    }

    public void setHora(Date h) {
        hora=h;
    }

    public void setTorneo(Torneo t) {
        torneo=t;
    }

    public void setSede(Sede s) {
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
    public Date getHora()
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

    public JugadorModel getGanador() {
        return ganador;
    }

    public void setGanador(JugadorModel ganador) {
        this.ganador = ganador;
    }

    @Override
    public String toString() {
        return fechaPartida.toString() + ", " + hora;
    }
}
