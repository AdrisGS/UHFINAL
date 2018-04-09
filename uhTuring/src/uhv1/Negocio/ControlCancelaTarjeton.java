/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1.Negocio;

import javax.swing.JOptionPane;
import uhv1.ControlPrincipal;
import uhv1.Persistencia.DAOTarjeton;
import uhv1.Vistas.VentanaAdvertenciaCancelaTarjeton;
import uhv1.Vistas.VentanaCancelaTarjeton;


/**
 *
 * @author adrianags
 * versión 1.2, 30/03/2018
+* Se encarga de cancelar el tarjeton de un habitante 
*/

public class ControlCancelaTarjeton {
    
    private DAOTarjeton daotar;
    private Tarjeton tarjetones [];
    private Responsable habitante;
    
    /*
    Constructor de control cancela tarjeton
    */
    public ControlCancelaTarjeton(Responsable habitante, DAOTarjeton daotar, Tarjeton tarjetones []){
        this.habitante=habitante;
        this.daotar=daotar;
        this.tarjetones =tarjetones ;
    }
    
    public ControlCancelaTarjeton(int num){
        
    }
    
    /*
       Muestra la ventana cancela tarjeton, pasandole el control y los tarjetones
    */
    public void iniciar(){
        VentanaCancelaTarjeton ventanaCancelaT = new VentanaCancelaTarjeton(this,tarjetones ,habitante);
        ventanaCancelaT.setVisible(true);
    }
    
    /*
      Este metodo te regresa  a la ventana gestion tarjeton
    */
    public void mandarControlGestionTarjeton(){
        ControlGestionTarjeton control = new ControlGestionTarjeton(habitante,daotar,tarjetones );
        control.inicia();
    }
    
    /*
        Este metodo manda a la ventana principal
    */
    public void mandarControlPrincipal(){
        ControlPrincipal controlP = new ControlPrincipal();
        controlP.inicia();
    }
    
    /*
      Este metodo se le pasa el numero de estacionamiento que se ingreso en la ventana y el id del habitante 
      para poder buscar dicho tarjeton con eses parametros, regresa un entero para poder cerrar la ventana 
      
    */
    public int advertirCancelarTarjeton(int numEstacionamiento, int id){
       
        int valor = 0;
        
        Tarjeton tarjeton;
        tarjeton=daotar.buscarTarjetonNum(numEstacionamiento,id); //regrasa el tarjeton buscado con dicho
                                                                         //id y numEstacionamiento 
        //si el tarjeton es null manda un mensaje de que no se ingreso un tarjeton existente para cancelar  
        //y valor es igual a uno para que no se cierre la ventana de cancela tarjeton
        if(tarjeton==null || habitante.getId()!=id){
                JOptionPane.showMessageDialog (null, "No ingresaste un tarjetón existente a cancelar ");  
                valor=1;
        }else{
            //sino es null verifica que el numero de estacionamiento que se ingreso 
            //y el numero de estacionamiento del tarjeron que regreso sea igual
            //para mostrar la ventana de advertencia y valor será igual a dos 
            //para que se cierre la ventana cancela tarjeton            
            if(tarjeton.getNum_estacionamiento()==numEstacionamiento){
                VentanaAdvertenciaCancelaTarjeton ventanaAdvertencia = new VentanaAdvertenciaCancelaTarjeton(this,tarjeton);
                ventanaAdvertencia.setVisible(true);
                valor=2;
            }
            
        }
        
        return valor;//regresa el valor dependiendo al if que entra
        
    }//fin de advertir
  
    /*
      Este metodo se le pasa el tarjeton que se busco y encontro para cambiar
      su estado a cancelado y regresa el tarjeton
    */
    public Tarjeton aceptarCancelar(Tarjeton tarjeton){
        
        String estado;
        estado="Cancelado";
        
        tarjeton.setEstado(estado);
                
        return tarjeton;
    
    }
    
    /*
     Este metodo se le pasa el tarjeton con el cambio en su estado 
     para actualizarlo en la base de datos
    */
    public void exitoCancelar(Tarjeton tarjeton){
        
        Boolean respuesta = null;
        
        
        Tarjeton tarjetonModificado=this.aceptarCancelar(tarjeton);//se regresa el tarjeton con su estado
                                                      //en cancelado 
        respuesta=daotar.actualizarEstado(tarjetonModificado); //manda al tarjeton a actualiza en el dao 
        
        //si la respuesta es true manda un mensaje de cancelado exito
        if(respuesta==true){
            JOptionPane.showMessageDialog (null, "El tarjetón se cancelo con éxito");  
            this.mandarControlPrincipal();
       
        }else{
            //sino un mensaje que no se pudo cancelar el tarjeton
             JOptionPane.showMessageDialog (null, "No se pudo cancelar el tarjetón con éxito");  
        }
        
    }
 
}//fin de la clase
