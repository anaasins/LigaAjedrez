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
    private FederacionModel federacion;
    private Date fecha;
    private ArrayList<Club> clubs = new ArrayList<Club>();  
    
    public Torneo(FederacionModel fed, Date fT,ArrayList<Club> c) 
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
    public void setFederacion(FederacionModel fed)
    {
        federacion=fed;
    }
    public FederacionModel getFederacion()
    {
        return federacion;
    }
            
}
