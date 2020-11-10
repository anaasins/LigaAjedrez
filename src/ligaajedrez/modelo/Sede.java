/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.modelo;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @OneToMany(mappedBy="sede", orphanRemoval = true)
    List<Reserva> reservas;

    public Sede() {
    }

    public Sede(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Reserva> getRes() {
        return (ArrayList) reservas;
    }

    public void setRes(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    Reserva buscarReserva(Date date, int hora) {
        Reserva definitiva=null;
       for(Reserva r:reservas)
       {
           if(r.getInicio()==date && r.getHora()==hora)
               definitiva=r;
       }
       return definitiva;
    }

    boolean reservarSede(Reserva reserva, Date date, int hora, Usuario user) {
        Reserva r;
        boolean ok= true;
        if(reserva != null && reserva.getContador()<2)
        {
            reserva.setContador(reserva.getContador()+1);
        }
        else if(reserva == null)
        {
            r= new Reserva(user, date, hora, this);
            reservas.add(r);
        }
        else if(reserva != null && reserva.getContador()>=2)
        {
            ok=false;
        }
        return ok;
    }

   
}
