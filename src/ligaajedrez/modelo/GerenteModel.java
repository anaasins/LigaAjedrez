/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.modelo;

/**
 *
 * @author jbeltran
 */
public class GerenteModel{
    private int id;
    private String name;
    private String surname;
    private String phone;
    private String nomina;
    private String irpf;
    private Club club;
    private String birth;

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
    }
    
    @Override
    public String toString()
    {
        return name+" "+surname;
    }
}
