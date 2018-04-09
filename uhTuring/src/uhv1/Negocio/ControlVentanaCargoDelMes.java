/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1.Negocio;

import uhv1.Vistas.VentanaCargosMes;

/**
 *
 * @author adrianags
 */
public class ControlVentanaCargoDelMes {
    
    public void inicia() {

        VentanaCargosMes ventanaCargos = new VentanaCargosMes(this);
        ventanaCargos.setVisible(true); // En este momento aparece la ventana principal
    }//fin del incia
    
    public void mantenimientoPulsado(){
        ControlCargoDelMes ccdm = new ControlCargoDelMes();
        ccdm.realizaCargo();
    }
}
