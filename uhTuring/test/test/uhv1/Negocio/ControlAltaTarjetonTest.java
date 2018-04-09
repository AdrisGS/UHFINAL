/*
Esta es la clase de prueba para el Control de Alta tarjeton
Todas la pruebas se realizarán para el Habitante con identificador 100
En la primera prueba se agrega un nuevo tarjeton a un habitante que no tiene ninguno tarjeton previamente asignado 
y retorna true.

En la segunda prueba se agrega un nuevo tarjeton al mismo habitante que ya tiene un tarjeton asignado y retorna true.

En la tercera prueba se intenta asignar un tercer tarjeton al mismo habitante pero como ya cuenta con dos previos 
el sistema retorna false.
*/

package test.uhv1.Negocio;

import org.junit.After;
import org.junit.Test;
import uhv1.Negocio.Casa;
import uhv1.Negocio.ControlAltaTarjeton;
import uhv1.Negocio.Responsable;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import uhv1.Negocio.Tarjeton;
import uhv1.Persistencia.DAOTarjeton;

/**
 *
 * @author evil5
 */
public class ControlAltaTarjetonTest {
    
    public ControlAltaTarjetonTest() {
    }
    
    @BeforeClass
    public static void setUp() {
        
        DAOTarjeton daot = new DAOTarjeton();
        Casa casa = new Casa(1, "", 0);
        Responsable hab = new Responsable(100, "", "", "", 0, casa, 0);
        Tarjeton listaTarjetones[] = daot.buscaTarjeton(100);
        for (int i = 0; i < listaTarjetones.length; i++) {
            System.out.println(listaTarjetones[i]+" ,  ");
            Tarjeton tardel = new Tarjeton(0, listaTarjetones[i].getNum_estacionamiento(), "", "", "", "Cancelado");
            daot.bajaTarjeton(tardel, hab);
        } 
    }
    
    @After
    public void tearDown() {
    }

   
    /**
     * Test of recibeDatosFormulario method, of class ControlAltaTarjeton.
     * Esta prueba instancia un Responsable con identificador 100 y Agrega un Tarjeton a la base de datos
     */
    
    
    @Test
    public void testRecibeDatosFormulario1() throws Exception {
        System.out.println("Inicia prueba recibeDatosFormulario");
        Casa cas = new Casa(100, "D", 13);
        Responsable res = new Responsable(100, "nombrePrueba", "aPatPrueba", "aMatPrueba" ,1234567, cas, 0);
        String plac = "123FFF";
        ControlAltaTarjeton instance = new ControlAltaTarjeton();
        
        boolean expResult = true;
        boolean result = instance.recibeDatosFormulario(res, plac);
        assertEquals(expResult, result);
        if(expResult!=result){
            fail("Falla de prueba No se agregó el tarjeton");    
        }
    }
    
    @Test
    public void testRecibeDatosFormulario2() throws Exception {    
        System.out.println("Inicia prueba recibeDatosFormulario");
        Casa cas = new Casa(100, "D", 13);
        Responsable res = new Responsable(100, "nombrePrueba", "aPatPrueba", "aMatPrueba" ,1234567, cas, 0);
        String plac = "123FFF";
        ControlAltaTarjeton instance = new ControlAltaTarjeton();
        
        boolean expResult = true;
        boolean result = instance.recibeDatosFormulario(res, plac);
        assertEquals(expResult, result);
        if(expResult!=result){
            fail("Falla de prueba No se agregó el tarjeton");    
        }
    }
    
    @Test
    public void testRecibeDatosFormulario3() throws Exception {    
        System.out.println("Inicia prueba recibeDatosFormulario");
        Casa cas = new Casa(100, "D", 13);
        Responsable res = new Responsable(100, "nombrePrueba", "aPatPrueba", "aMatPrueba" ,1234567, cas, 0);
        String plac = "123FFF";
        ControlAltaTarjeton instance = new ControlAltaTarjeton();
        
        boolean expResult = false;
        boolean result = instance.recibeDatosFormulario(res, plac);
        assertEquals(expResult, result);
        if(expResult!=result){
            fail("Falla de prueba");    
        }
        
    }
    
    
}
