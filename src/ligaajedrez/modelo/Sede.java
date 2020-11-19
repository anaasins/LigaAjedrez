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
 * @author asins
 */
@Entity
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sedeSeq")
    @SequenceGenerator(name="sedeSeq",sequenceName="sedeSeq", allocationSize=1, initialValue = 1)
    private int id;

    public Sede() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
