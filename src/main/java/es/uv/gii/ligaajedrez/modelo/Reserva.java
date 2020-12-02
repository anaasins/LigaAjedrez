/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.gii.ligaajedrez.modelo;

import java.util.*;

/**
 *
 * @author asins
 */
public class Reserva {
    private int id;
    Usuario user;
    Date inicio;
    int hora;
    int contador;
    private Sede sede;

    public Reserva() {}
    
    public Reserva(Usuario user, Date inicio, int hora, Sede sede) {
        this.user = user;
        this.inicio = inicio;
        this.hora = hora;
        this.sede = sede;
        contador=0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }


    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }
}
