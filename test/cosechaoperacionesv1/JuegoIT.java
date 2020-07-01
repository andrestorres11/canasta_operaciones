/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosechaoperacionesv1;

import javafx.stage.Stage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author acastroc
 */
public class JuegoIT {
    
    public JuegoIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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

    /**
     * Test of main method, of class Juego.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Juego.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class Juego.
     */
    @Test
    public void testStart() throws Exception {
        System.out.println("start");
        Stage ventana = null;
        Juego instance = new Juego();
        instance.start(ventana);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cicloJuego method, of class Juego.
     */
    @Test
    public void testCicloJuego() {
        System.out.println("cicloJuego");
        Juego instance = new Juego();
        instance.cicloJuego();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarEstado method, of class Juego.
     */
    @Test
    public void testActualizarEstado() {
        System.out.println("actualizarEstado");
        Juego instance = new Juego();
        instance.actualizarEstado();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inicializarComponentes method, of class Juego.
     */
    @Test
    public void testInicializarComponentes() {
        System.out.println("inicializarComponentes");
        Juego instance = new Juego();
        instance.inicializarComponentes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pintar method, of class Juego.
     */
    @Test
    public void testPintar() {
        System.out.println("pintar");
        Juego instance = new Juego();
        instance.pintar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gestionEventos method, of class Juego.
     */
    @Test
    public void testGestionEventos() {
        System.out.println("gestionEventos");
        Juego instance = new Juego();
        instance.gestionEventos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
