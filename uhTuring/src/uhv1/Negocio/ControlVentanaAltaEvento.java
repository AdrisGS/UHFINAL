/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1.Negocio;

import java.sql.Date;
import javax.swing.JOptionPane;
import uhv1.ControlPrincipal;
import uhv1.Persistencia.DAOEvento;
import uhv1.Persistencia.DAOHabitantes;
import uhv1.Vistas.VentanaAceptaDatos;
import uhv1.Vistas.VentanaAltaEvento;

/**
 *
 * @author darky
 */
public class ControlVentanaAltaEvento {
    public void inicia(){
        VentanaAltaEvento VAE = new VentanaAltaEvento (this);
        VAE.setVisible(true);
        
    }
    public void datos_de_evento(String nombreE, Date fecha, float saldo, String descripcion, String nombre, String aPat, VentanaAltaEvento vae){
        Responsable res;
        /* Se envia mensaje al dao habitante con los datos del habitante a buscar */
        DAOHabitantes daoh = new DAOHabitantes();
        System.out.println("nombres: " + nombre + " y " + aPat);
        res = daoh.buscaHabitante(nombre, aPat);
        if (res == null){
           this.hNoFound(vae);
        }else{
            int estado = 0;
            if(saldo == 400){
                estado = 1;
            }
            Evento ev = new Evento(nombreE, fecha, saldo, descripcion, res, estado);
            System.out.println(nombreE + fecha +  saldo +  descripcion +res+ estado);
            DAOEvento daoe = new DAOEvento();
            daoe.registra_evento(ev);            
            vae.dispose();
            this.despiega();
        }        
       
    }
    public void despiega(){
        VentanaAceptaDatos vad = new VentanaAceptaDatos(this);
        vad.setVisible(true);
        
    }
    public void acepta_pulsado(){
        ControlPrincipal cp = new ControlPrincipal();
        cp.inicia();
    }

    private void hNoFound(VentanaAltaEvento VAE) {
        JOptionPane.showMessageDialog(null, "No se encontrol el habitante");
    }
}
