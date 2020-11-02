/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.modelo;

import java.util.*;

/**
 *
 * @author asins
 */
public class Sede {
    ArrayList<Reserva> res;

    Reserva buscarReserva(Date date, int hora) {
        Reserva definitiva=null;
       for(Reserva r:res)
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
            r= new Reserva(user, date, hora);
            res.add(r);
        }
        else if(reserva != null && reserva.getContador()>=2)
        {
            ok=false;
        }
        return ok;
    }

   
}
