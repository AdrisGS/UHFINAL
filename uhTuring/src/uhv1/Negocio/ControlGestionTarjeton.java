/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1.Negocio;

import uhv1.Persistencia.DAOTarjeton;
import uhv1.Vistas.VentanaGestionTarjeton;

/**
 *
 * @author adrianags 
 */
public class ControlGestionTarjeton {
    
    Responsable res;
    DAOTarjeton daotar;
    Tarjeton tar [];
    
    public ControlGestionTarjeton(){
        
    }
    public ControlGestionTarjeton(Responsable res, DAOTarjeton daotar, Tarjeton tar[]){
        this.res = res;
        this.daotar = daotar;
        this.tar=tar;
        
    }
    public void inicia(){
       // System.out.println("EstÃ¡s en inicia de control gestion tarjeton ");
        VentanaGestionTarjeton ventHab = new VentanaGestionTarjeton(this,res,tar);
        
        ventHab.setVisible(true);
    }
    
    public void altaTarjeton(){
        ControlAltaTarjeton cat= new ControlAltaTarjeton();
        cat.inicia(res);
    }
    
    public void cancelarTarjeton(){
        ControlCancelaTarjeton cct = new ControlCancelaTarjeton(res,daotar,tar);
        cct.iniciar();
    }
}
