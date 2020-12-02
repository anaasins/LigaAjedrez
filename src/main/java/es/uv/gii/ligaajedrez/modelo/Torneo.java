/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.gii.ligaajedrez.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Olaf
 */
public class Torneo {
    private int id;
    private FederacionModel federacion;
    private Date fecha;
    private List<Club> clubs = new ArrayList<Club>();
    private List<JugadorModel> participantes;
    
    public Torneo() {}
    
    public Torneo(FederacionModel fed, Date fT,ArrayList<Club> c) 
        {
            this.setFederacion(fed);
            this.SetFecha(fT);
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Club> getClubs() {
        return (ArrayList)clubs;
    }

    public void setClubs(ArrayList<Club> clubs) {
        this.clubs = clubs;
    }

    public void SetFecha(Date fechaTorneo) {
       fecha = fechaTorneo;
    }
    public Date getFecha() {
       return fecha;
    }
    public void setFederacion(FederacionModel fed)
    {
        federacion=fed;
    }
    public FederacionModel getFederacion()
    {
        return federacion;
    }

    public List<JugadorModel> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<JugadorModel> participantes) {
        this.participantes = participantes;
    }

    @Override
    public String toString() {
        return "Torneo: " + id;
    }
            
}
