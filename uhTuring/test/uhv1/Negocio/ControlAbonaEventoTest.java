/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1.Negocio;

import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uhv1.Persistencia.DAOEvento;

/**
 *
 * @author Jose Luis
 */
public class ControlAbonaEventoTest {
    
    public ControlAbonaEventoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Date fecha = null;
        Casa casa = new Casa(1,"seccion B", 5);
        Responsable resp = new Responsable(1, "Juan", "Lopez", "Hernandez", 55555555, casa, 0);
        Evento even = new Evento("boda", fecha, 100, "Boda Juan y Maria", resp,0);
        DAOEvento daoEven = new DAOEvento();
        ControlAbonaEvento control = new ControlAbonaEvento(daoEven, even);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }
    
    /** Metodo que valida si el usuario deja el campo de Saldo vacio, arroja false
     * Test of registraSaldo method, of class ControlAbonaEvento.
     */
    @Test
    public void testRegistraSaldoCampoVacio() {
        System.out.println("registraSaldoCampoVacio");
        String saldo = "";
        ControlAbonaEvento instance = new ControlAbonaEvento();       
        boolean expResult = false;
        boolean result = instance.registraSaldo(saldo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result == expResult){
            System.out.println("Prueba exitosa");
        }else{
            fail("The test case is a prototype.");
        }
    }
    
    /**Metodo que valida si el usuario captura letras en el campo de Saldo, arroja false
     * Test of registraSaldo method, of class ControlAbonaEvento.
     */
    @Test
    public void testRegistraSaldoCampoLetras() {
        System.out.println("registraSaldoCampoConLetras");
        String saldo = "asduvlf";
        ControlAbonaEvento instance = new ControlAbonaEvento();       
        boolean expResult = false;
        boolean result = instance.registraSaldo(saldo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result == expResult){
            System.out.println("Prueba exitosa");
        }else{
            fail("The test case is a prototype.");
        }
        
    }
    
    /**Metodo que valida si el usuario captura letras en el campo de Saldo, arroja false
     * Test of registraSaldo method, of class ControlAbonaEvento.
     */
    @Test
    public void testRegistraSaldoDatosCorrectos() {
        System.out.println("registraSaldoDatosCorrectos");
        String saldo = "300";
        ControlAbonaEvento instance = new ControlAbonaEvento();       
        boolean expResult = true;
        boolean result = instance.registraSaldo(saldo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result == expResult){
            System.out.println("Prueba exitosa");
        }else{
            fail("The test case is a prototype.");
        }
        
    }
}
