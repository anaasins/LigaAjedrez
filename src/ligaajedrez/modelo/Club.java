/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.modelo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author jbeltran
 */
@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clubSeq")
    @SequenceGenerator(name="clubSeq",sequenceName="clubSeq", allocationSize=1, initialValue = 1)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "federationId", referencedColumnName = "id")
    private FederacionModel federation;
    @ManyToOne
    @JoinColumn(name = "sedeId", referencedColumnName = "id")
    private Sede sede;
    @ManyToMany(mappedBy = "clubs")
    private List<Torneo> torneos;
    /*private Entrenador trainer;
    private Gerente manager;*/

    public Club() {
    }

    public Club(String name, FederacionModel federation, Sede sede) {
        this.name = name;
        this.federation = federation;
        this.sede = sede;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sede getSede() {
        return sede;
    }

    public List<Torneo> getTorneos() {
        return torneos;
    }

    public void setTorneos(List<Torneo> torneos) {
        this.torneos = torneos;
    }

    /*public Club(String name, FederacionModel federation, Entrenador trainer, Gerente manager) {
    this.name = name;
    this.federation = federation;
    this.trainer = trainer;
    this.manager = manager;
    }*/
    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FederacionModel getFederation() {
        return federation;
    }

    public void setFederation(FederacionModel federation) {
        this.federation = federation;
    }

    /*public Entrenador getTrainer() {
        return trainer;
    }

    public void setTrainer(Entrenador trainer) {
        this.trainer = trainer;
    }

    public Gerente getManager() {
        return manager;
    }

    public void setManager(Gerente manager) {
        this.manager = manager;
    }*/

    @Override
    public String toString() {
        return "Club: " + name + ", " + federation.toString();
    }
}
