/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosechaoperacionesv1.clases;

import cosechaoperacionesv1.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * POLITECNICO GRACOLOMBIANO
 * Pradigmas de Programacion 
 * Ingenieria Software
 * @author antorres21
 * Andres Torres
 * Codigo:1710010952
 * Fecha de Inicio:10-06-20
 */
public class Legumbre {
    private int x;
    private int y;
    private String nombreImagen;
    private int velocidad = 2;
    
    /**
     * POLITECNICO GRACOLOMBIANO Pradigmas de Programacion Ingenieria Software
     *
     * @author antorres21 Andres Torres Codigo:1710010952 Fecha de Inicio:10-06-20
    */
    public Legumbre(int x, int y, int vidas, String nombreImagen) {
        this.x = x;
        this.y = y;
        this.nombreImagen = nombreImagen;
    }
    
    /**
     * POLITECNICO GRACOLOMBIANO Pradigmas de Programacion Ingenieria Software
     *
     * @author antorres21 Andres Torres Codigo:1710010952 Fecha de Inicio:10-06-20
    */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * POLITECNICO GRACOLOMBIANO Pradigmas de Programacion Ingenieria Software
     *
     * @author antorres21 Andres Torres Codigo:1710010952 Fecha de Inicio:10-06-20
    */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * POLITECNICO GRACOLOMBIANO Pradigmas de Programacion Ingenieria Software
     *
     * @author antorres21 Andres Torres Codigo:1710010952 Fecha de Inicio:10-06-20
    */
    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }
    
    /**
     * POLITECNICO GRACOLOMBIANO Pradigmas de Programacion Ingenieria Software
     * @description se ejecuta por cada iteracion del ciclo de juego
     * @author antorres21 Andres Torres Codigo:1710010952 Fecha de Inicio:10-06-20
    */
    public void pintar(GraphicsContext graficos) {
        graficos.drawImage(new Image(nombreImagen), x, y);
    }
    
    /**
     * POLITECNICO GRACOLOMBIANO Pradigmas de Programacion Ingenieria Software
     * @description se ejecuta por cada iteracion del juego
     * @author antorres21 Andres Torres Codigo:1710010952 Fecha de Inicio:10-06-20
    */
    public void mover(){
        
        if (x >= 460 ){ //validacion para que llegue al limite de la pantalla derecho
            Juego.derecha = false;
        } 
        if(x <= 0 ){ //validacion para que llegue al limite de la pantalla izquierdo
           Juego.izquierda = false;
        }
        
        int numero = (int) (Math.random() * 600) + 1;
        if (y >= 410 ){ //validacion para que al llegar abajo vuelva a aparecer arriba
            x = numero;
            y = -150;
        }
        
        if (y <= 300 ){ //validacion para que llegue al limite de la pantalla arriba
            Juego.arriba = false;
        }
        
        x+=velocidad; //validacion para que mueva hacia la derecha
        x-=velocidad; //validacion para que mueva hacia la izquierda
        y+=velocidad; //validacion para que mueva hacia abajo
        
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
}
