/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Olaf
 */
public class Torneo {
    private String federacion;
    private Date fecha;
    private ArrayList<Club> clubs = new ArrayList<Club>();  
    
    public Torneo(String fed, Date fT,ArrayList<Club> c) 
        {
            this.setFederacion(fed);
            this.SetFecha(fT);
	}

    public void SetFecha(Date fechaTorneo) {
       fecha = fechaTorneo;
    }
    public Date getFecha() {
       return fecha;
    }
    public void setFederacion(String fed)
    {
        federacion=fed;
    }
    public String getFederacion()
    {
        return federacion;
    }
            
}
