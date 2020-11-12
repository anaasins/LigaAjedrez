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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


/**
 *
 * @author jbeltran
 */
@Entity
public class GerenteModel{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entrenadorSeq")
    @SequenceGenerator(name="entrenadorSeq",sequenceName="entrenadorSeq", allocationSize=1, initialValue = 1)
    private int id;
    private String name;
    private String surname;
    private String phone;
    private String nomina;
    private String irpf;
    @ManyToOne
    @JoinColumn(name = "clubId", referencedColumnName = "id")
    private Club club;
    private String birth;
    private List<Club> clubs;

    public GerenteModel() {
    }

    public GerenteModel(String name, String surname, String  birth, String phone, String nomina, String irpf) {
        setName(name);
        setSurname(surname);
        setBirth(birth);
        setPhone(phone);
        setNomina(nomina);
        setIrpf(irpf);
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
    
    public String getNomina() {
        return nomina;
    }

    public void setNomina(String nomina) {
        if (!nomina.trim().isEmpty())
            this.nomina = nomina;
    }
    
    public String getIrpf() {
        return irpf;
    }

    public void setIrpf(String irpf) {
        if (!irpf.trim().isEmpty())
            this.irpf = irpf;
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
    
    public Club getClub() {
        return club;
    }
    
    public void setClub(Club club) {
        this.club = club;
        if (club != null)
            clubs.add(club);
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
