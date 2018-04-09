/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1.Negocio;

import static com.sun.glass.ui.Cursor.setVisible;
import javax.swing.JOptionPane;
import uhv1.Persistencia.DAOHabitantes;
import uhv1.Persistencia.DAOTarjeton;
import uhv1.Vistas.VentanaAltaEvento;
import uhv1.Vistas.VentanaTarjeton;

/**
 *
 * @author darky
 */
public class ControlVentanaTarjeton {
    public void inicia(){
        VentanaTarjeton VT = new VentanaTarjeton(this);
        VT.setVisible(true);
    }
    
    public void buscaHabitanteTarjeton(String nombre, String aPat, VentanaTarjeton VT){
    
        Responsable res;
        /* Se envia mensaje al dao habitante con los datos del habitante a buscar */
        DAOHabitantes daoh = new DAOHabitantes();
        System.out.println("Nombre habitante: " + nombre + " " + aPat);
        res = daoh.buscaHabitante(nombre, aPat);
        
        if (res == null){
           this.habitanteNoFound(VT);
        }else{
            VT.setVisible(false);
            
            /*
            
             boolean bandera;
       daoPagos = new DAOPagos();
       pagos pagosArreglo[] = daoPagos.Recupera(hab);
       vistaHist = new VistaHistorial(this, pagosArreglo);
       
              
       if(pagosArreglo != null){
          vistaHist.setVisible(true);
          vistaHist.MuestaHistorial(hab);
       }
            */
            
            int id= res.getId();
            int i;
            DAOTarjeton daotar = new DAOTarjeton();
            Tarjeton tar []= daotar.buscaTarjeton(id);
           
            for(i= 0; i<tar.length;i++){
                
                    System.out.println(" "+ tar[i].imprime());
                
            }
            ControlGestionTarjeton control = new ControlGestionTarjeton(res,daotar,tar);
            control.inicia();
            
        }
    }    
     private void habitanteNoFound(VentanaTarjeton VT1) {
        JOptionPane.showMessageDialog(null, "No se encontrol al habitante");
    }
}
