/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Ana
 * versión 1.1, 28/03/2018
 * Esta clase crea una instancia de la VentanaImprimeComprobante y la hace visible y recibe la interacción del usuario.
 */

package uhv1.Negocio;

import uhv1.ControlPrincipal;
import uhv1.Vistas.VentanaImprimeComprobante;

public class ControlVentanaImprimeComprobante {

    private Evento evento;
    private pagos pago;
    public ControlVentanaImprimeComprobante(Evento evento, pagos pago){
        this.evento = evento;
        this.pago = pago;
    } 
    
    public void iniciar(){
        VentanaImprimeComprobante ventanaIE = new VentanaImprimeComprobante(this);
        ventanaIE.setVisible(true);
    }
    
    public void aceptarPulsado(){
        ControlImprimeComprobante controlIE = new ControlImprimeComprobante(evento, pago);
        controlIE.generarPDF();
        this.cancelarPulsado();
    }
    
    public void cancelarPulsado(){
        ControlPrincipal controlP = new ControlPrincipal();
        controlP.inicia();
    }
}
