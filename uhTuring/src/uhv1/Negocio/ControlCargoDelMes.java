/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Erick
 * versión 1.1, 28/03/2018
 * Se encarga de generar el cargo correspondiente al pago de mantenimiento a cada habitante
 */
package uhv1.Negocio;

import uhv1.Persistencia.DAOHabitantes;
import uhv1.Persistencia.DAOPagos;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import uhv1.ControlPrincipal;

public class ControlCargoDelMes {
    private DAOHabitantes daoHabitantes;
    private DAOPagos daoPagos;
    private Calendar fechaCalendar; 
    
    
    public ControlCargoDelMes(){
        daoHabitantes = new DAOHabitantes();
        daoPagos = new DAOPagos();
        fechaCalendar = Calendar.getInstance();
    }

    public ControlCargoDelMes(int i) {
        
    }

    
    
    
    
    public void realizaCargo(){
        //Se declara el arreglo de habitantes y una variable booleana para confirmar la fecha
        Responsable[] arregloHabitantes;        
        boolean resultado;
        
        java.sql.Date fechasql;
        //se confirma que la fecha sea la correcta para realizar el cargo de mantenimiento        
        resultado = confirmaFecha();
        if (resultado){                
            arregloHabitantes = daoHabitantes.dameHabitantes();//Se traen todos los habitantes que estan en la BD            
            Date fecha = new Date();//Se obtiene la fecha actual del sistema en una viariable Date            
            for (Responsable Habitante : arregloHabitantes) {//Se hace un for, para iterar cada habitante
                this.cargaHabitantes(Habitante);//Se llama el metodo 'cargaHabitante' de esta clase para realizar la carga del mantenimiento
                daoHabitantes.actualizaHabitante(Habitante);//Se actualiza el habiatante en la base de datos
                fechasql = new java.sql.Date(fecha.getTime());//Se asigana a la variable de tipo sqlDate, la fecha actual del sistema
                //se crea el objeto pago con los datos sobre el cargo del mantenimiento para el habitante iterado
                pagos pagoHabitante = new pagos(0, fechasql, -50, Habitante.getId(), 4, Habitante.getSaldo());
                resultado = daoPagos.creaPago(pagoHabitante);//Se crea el nuevo pago en la base de dstos
            }
            //si todo bien, lanza alerta de confirmacion
            JOptionPane.showMessageDialog(null, "Se genero el cargo a todos los habitantes con exito");   
            controlPrincipal();
        }else{
            //si no es la fecha para realizar el cargo, se manda una alerta
             JOptionPane.showMessageDialog(null, "Aun no es momento de hacer cargo del mes");      
             controlPrincipal();
        }
    }    
    public void cargaHabitantes(Responsable res){
        float saldoActual;
        float saldo;
        
        saldoActual = res.getSaldo(); //Se obtiene el saldo actual del habitante
        saldo  = saldoActual - 50; //Se resta el cobro del mantenimiento al habitante
        res.setSaldo(saldo); //Se asigna el nuevo saldo al habitante
    } 
    
    private boolean confirmaFecha(){
        int dia = fechaCalendar.get(Calendar.DAY_OF_MONTH); //Se obtiene el dia de la fecha actual
        if(dia != 5){
            return false;
        }
        return true;
    }
    
    public void controlPrincipal(){
        ControlPrincipal control= new ControlPrincipal();
        control.inicia();
        
    }
}