/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.modelo;

<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> d022648f5b364f6dcc5da7cadc6557579bfe55bb
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import ligaajedrez.modelo.enums.CategoriaEnum;
import org.hibernate.annotations.Type;

/**
 *
 * @author jbeltran
 */
@Entity
public class JugadorModel{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jugadorSeq")
    @SequenceGenerator(name="jugadorSeq",sequenceName="jugadorSeq", allocationSize=1, initialValue = 1)
    private int id;
    private String name;
    private int elo;
    @ManyToOne
    @JoinColumn(name = "clubId", referencedColumnName = "id")
    private Club club;
    private int age;
    private CategoriaEnum category;
    private String responsableName;
    private String reponsablePhoneNumber;
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean moroso;
    private int multa;
<<<<<<< HEAD
=======
    @ManyToMany()
>>>>>>> d022648f5b364f6dcc5da7cadc6557579bfe55bb
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
