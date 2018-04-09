/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.uhv1.Negocio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import uhv1.Negocio.ControlCargoDelMes;
import uhv1.Negocio.Responsable;

/**
 *
 * @author darky
 */
public class ControlCargoDelMesTest {
    private ControlCargoDelMes controlCargo;
    private Responsable habitante;
    
    public ControlCargoDelMesTest() {
    }
    
    @Before
    public void setUp() {
        controlCargo = new ControlCargoDelMes(1);
        habitante = new Responsable(1, "Erick", "Tapia", "Bautista", 51150438, null, 100);
    }
    
    @After
    public void tearDown() {
        controlCargo = null;
        habitante = null;
    }
    @Test
    public void realizaCargoTest(){
        controlCargo.cargaHabitantes(habitante);
        assertEquals("***Se esperaba 50 ***",50f, habitante.getSaldo(),0);
    }
    @Test
    public void realizaCargoTest2(){
        habitante.setSaldo(0f);
        controlCargo.cargaHabitantes(habitante);
        assertEquals("***Se esperaba -50 ***",-50f, habitante.getSaldo(),0);
    }
    @Test
    public void realizaCargoTest3(){
        habitante.setSaldo(-100f);
        controlCargo.cargaHabitantes(habitante);
        assertEquals("***Se esperaba -150 ***",-150f, habitante.getSaldo(),0);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}