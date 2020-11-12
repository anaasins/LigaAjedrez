/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Olaf
 */
@Entity
public class Torneo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "torneoSeq")
    @SequenceGenerator(name="torneoSeq",sequenceName="torneoSeq", allocationSize=1, initialValue = 1)
    private int id;
    @ManyToOne
    @JoinColumn(name = "federacionId", referencedColumnName = "id")
    private FederacionModel federacion;
    private Date fecha;
    @ManyToMany
    @JoinTable(name = "torneoClub", joinColumns = @JoinColumn(name = "torneoId"), inverseJoinColumns = @JoinColumn(name = "clubId"))
    private List<Club> clubs = new ArrayList<Club>();  
    @ManyToMany()
    @JoinTable(name = "torneoPaticipantes", joinColumns = @JoinColumn(name = "torneoId"), inverseJoinColumns = @JoinColumn(name = "jugadorId"))
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
