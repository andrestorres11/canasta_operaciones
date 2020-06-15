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
 *
 * @author andrestorres
 */
public class Jugador {
    private int x;
    private int y;
    private int vidas;
    private String nombreImagen;
    private int velocidad = 3;

    public Jugador(int x, int y, int vidas, String nombreImagen) {
        this.x = x;
        this.y = y;
        this.vidas = vidas; 
        this.nombreImagen = nombreImagen;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVidas() {
        return vidas;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }
    
    //se ejecuta por cada iteracion del ciclo de juego
    public void pintar(GraphicsContext graficos) {
        graficos.drawImage(new Image(nombreImagen), x, y);
    }
    
    //se ejecuta por cada iteracion del juego
    public void mover(){
        if (Juego.derecha){
            x+=velocidad;
            System.out.println(x+=velocidad);
        }
        
        if (Juego.izquierda){
            x-=velocidad;
        }
    }
    
}
