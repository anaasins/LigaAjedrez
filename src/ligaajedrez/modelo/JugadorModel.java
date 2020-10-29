/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import ligaajedrez.modelo.enums.CategoriaEnum;

/**
 *
 * @author jbeltran
 */
public class JugadorModel extends Usuario{
    public String name;
    public int elo;
    public Club club;
    public int age;
    public CategoriaEnum category;
    public String responsableName;
    public String reponsablePhoneNumber;
    public Liga liga;
    public boolean moroso;

    public JugadorModel() {
    }

    public JugadorModel(String name, int elo, int age, /*Club club,*/ String responsableName, String reponsablePhoneNumber) {
        setName(name);
        setElo(elo);
        //setClub(club);
        setResponsableName(responsableName);
        setReponsablePhoneNumber(reponsablePhoneNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.trim().isEmpty())
            this.name = name;
    }

    public int getElo() {
        return elo;
    }

    public void setElo(int elo) {
        if (elo >= 0 && elo <= 3000)
            this.elo = elo;
    }
    
    public boolean getMoroso()
    {
        return moroso;
    }
    
    public void setMoroso(boolean m)
    {
        this.moroso=m;
    }

    /*public Club getClub() {
        return club;
    }
    
    public void setClub(Club club) {
        this.club = club;
    }*/
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 140) {
            this.age = age;
            
            if (age <= 15)
                category = CategoriaEnum.Infantil;
            else if (age <= 18)
                category = CategoriaEnum.Junior;
            else
                category = CategoriaEnum.Senior;
        }
    }

    public CategoriaEnum getCategory() {
        return category;
    }

    public String getResponsableName() {
        return responsableName;
    }

    public void setResponsableName(String responsableName) {
        if (!responsableName.trim().isEmpty())
            this.responsableName = responsableName;
    }

    public String getReponsablePhoneNumber() {
        return reponsablePhoneNumber;
    }

    public void setReponsablePhoneNumber(String reponsablePhoneNumber) {
        if (reponsablePhoneNumber.matches("('+'[0-9]{2})?[0-9]{9}"))
            this.reponsablePhoneNumber = reponsablePhoneNumber;
    }

    public ArrayList getTorneosDisponibles() {
        return liga.torneosDisponibles(club.getFederation());
    }
}
