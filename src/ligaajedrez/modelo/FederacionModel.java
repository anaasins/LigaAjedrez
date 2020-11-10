/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author jbeltran
 */
@Entity
public class FederacionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "federacionSeq")
    @SequenceGenerator(name="federacionSeq",sequenceName="federacionSeq", allocationSize=1, initialValue = 1)
    private int id;
    private String city;

    public FederacionModel() {
    }

    public FederacionModel(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Federacion de " + city;
    }
}
