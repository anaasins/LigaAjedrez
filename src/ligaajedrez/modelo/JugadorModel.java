/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.modelo;


import java.util.ArrayList;
import java.util.List;
import ligaajedrez.modelo.enums.CategoriaEnum;

/**
 *
 * @author jbeltran
 */
public class JugadorModel{
    private int id;
    private String name;
    private int elo;
    private Club club;
    private int age;
    private CategoriaEnum category;
    private String responsableName;
    private String reponsablePhoneNumber;
    private boolean moroso;
    private int multa;
    private List<Club> clubs;

    public JugadorModel() {
        clubs = new ArrayList<>();
    }

    public JugadorModel(String name, int elo, int age, Club club) {
        clubs = new ArrayList<>();
        setName(name);
        setElo(elo);
        setAge(age);
        setClub(club);
    }
    
    public JugadorModel(String name, int elo, int age, Club club, String responsableName, String reponsablePhoneNumber) {
        clubs = new ArrayList<>();
        setName(name);
        setElo(elo);
        setAge(age);
        setClub(club);
        setResponsableName(responsableName);
        setReponsablePhoneNumber(reponsablePhoneNumber);
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

    public Club getClub() {
        return club;
    }
    
    public void setClub(Club club) {
        this.club = club;
        if (club != null)
            clubs.add(club);
    }
    
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
        if (responsableName != null && !responsableName.trim().isEmpty())
            this.responsableName = responsableName;
    }

    public String getReponsablePhoneNumber() {
        return reponsablePhoneNumber;
    }

    public void setReponsablePhoneNumber(String reponsablePhoneNumber) {
        if (reponsablePhoneNumber != null && reponsablePhoneNumber.matches("('+'[0-9]{2})?[0-9]{9}"))
            this.reponsablePhoneNumber = reponsablePhoneNumber;
    }

    public int getMulta() {
        return multa;
    }

    public void setMulta(int multa) {
        this.multa = multa;
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
        return name;
    }
}
