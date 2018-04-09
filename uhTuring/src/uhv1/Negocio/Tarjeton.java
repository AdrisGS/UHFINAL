/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1.Negocio;

import java.sql.Date;

public class Tarjeton {
    private Responsable hab;
    private int id;
    private int num_estacionamiento;
    private String placas;
    private String fecha_impresion;
    private String fecha_vencimiento;
    private String estado;

/*
    public Tarjeton(Responsable hab, int num_estacionamiento, String placas, Date fecha_impresion, Date fecha_vencimiento, String estado) {
        this.hab = hab;
        this.num_estacionamiento = num_estacionamiento;
        this.placas = placas;
        this.fecha_impresion = fecha_impresion;
        this.fecha_vencimiento = fecha_vencimiento;
        this.estado = estado;
    }*/

    

    public Tarjeton(int id, int num_estacion, String placas, String fecha_impresion, String fecha_vencimiento, String estado) {
        this.id = id;
        this.num_estacionamiento = num_estacion;
        this.placas = placas;
        this.fecha_impresion = fecha_impresion;
        this.fecha_vencimiento = fecha_vencimiento;
        this.estado = estado;    
    
    }
    
    public int getId(){
        return id;
    }
   
    public int getNum_estacionamiento() {
        return num_estacionamiento;
    }

    public String getPlacas() {
        return placas;
    }

    public String getFecha_impresion() {
        return fecha_impresion;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setId(int id){
        this.id=id;
    }
    public void setHab(Responsable hab) {
        this.hab = hab;
    }

    public void setNum_estacionamiento(int num_estacionamiento) {
        this.num_estacionamiento = num_estacionamiento;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public void setFecha_impresion(String fecha_impresion) {
        this.fecha_impresion = fecha_impresion;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
    public  String toString() {
	    	return "Tarjeton: Estacionamiento: "+num_estacionamiento+", Estado: "+estado;
	 }
    
    public String imprime(){
        return "Tarjeton: "+ num_estacionamiento+" Placas: "+placas+ " "+estado;
    }
    
}
