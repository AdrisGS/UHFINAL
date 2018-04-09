/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1.Negocio;

import uhv1.Vistas.VentanaAdministrar;

/**
 *
 * @author adrianags
 */
public class ControlVentanaAdministrar {
    
    
    public void inicia(){
        VentanaAdministrar  VA= new VentanaAdministrar (this);
        VA.setVisible(true);
        
    }
    
    public void controlCargoDelMes(){
        ControlVentanaCargoDelMes CCDM = new ControlVentanaCargoDelMes ();
        CCDM.inicia();
    }
    
}
