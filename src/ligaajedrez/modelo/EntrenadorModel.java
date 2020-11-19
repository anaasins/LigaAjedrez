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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


/**
 *
 * @author jbeltran
 */
@Entity
public class EntrenadorModel{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entrenadorSeq")
    @SequenceGenerator(name="entrenadorSeq",sequenceName="entrenadorSeq", allocationSize=1, initialValue = 1)
    private int id;
    private String name;
    private String surname;
    private String phone;
    private String birth;
    @OneToMany
    @JoinColumn(name = "clubId", referencedColumnName = "id")
    private List<Club> clubs;
   

    public EntrenadorModel() {
    }

    public EntrenadorModel(String name, String surname, String  birth, String phone) {
        setName(name);
        setSurname(surname);
        setBirth(birth);
        setPhone(phone);
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.trim().isEmpty())
            this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (!surname.trim().isEmpty())
            this.surname = surname;
    }
    
     public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (!phone.trim().isEmpty())
            this.phone = phone;
    }
    
     public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        if (!birth.trim().isEmpty())
            this.birth = birth;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }
    
    @Override
    public String toString()
    {
        return name+" "+surname;
    }
}
