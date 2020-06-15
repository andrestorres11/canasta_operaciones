package cosechaoperacionesv1;

import cosechaoperacionesv1.clases.Jugador;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import javafx.scene.input.KeyEvent;



public class Juego extends Application {
    private GraphicsContext graficos;
    private Group root;
    private Scene escena;
    private Canvas lienzo;
    private Jugador jugador;
    private int x = 0;
    public static boolean arriba;    
    public static boolean abajo;
    public static boolean derecha;
    public static boolean izquierda;
    private static final String FONDO = "file:/home/andrestorres/NetBeansProjects/mavenproject3/src/main/java/com/mycompany/mavenproject3/imagenesJuegoParadigmas/interfaz-juego-sumar/fondo2.png";
    private static final String CANASTO = "file:/home/andrestorres/NetBeansProjects/mavenproject3/src/main/java/com/mycompany/mavenproject3/imagenesJuegoParadigmas/interfaz-juego-canasto/canasto2.png";
    
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage ventana) throws Exception {
        inicializarComponentes();
        gestionEventos();
        ventana.setScene(escena);
        ventana.setTitle("super juego");
        ventana.show();
        cicloJuego();
    }
    
    public void cicloJuego() {
        final long tiempoInicial = System.nanoTime();
        AnimationTimer animationTimer = new AnimationTimer() {
            
            //este metodo se ejecuta aproximadamente 60FPS
            @Override
            public void handle(long tiempoActual) {
                double t = (tiempoActual - tiempoInicial) / 1000000000.0;
                actualizarEstado();
                pintar();
            }
        };
        
        animationTimer.start();
    }
    
    public void actualizarEstado(){
        jugador.mover();
    }
    
    public void inicializarComponentes() {
        jugador = new Jugador(20, 400, 3, CANASTO);
        root = new Group();
        escena = new Scene(root, 700, 500);
        lienzo = new Canvas(700, 500);
        root.getChildren().add(lienzo);
        graficos = lienzo.getGraphicsContext2D();
        
    }
    
    public void pintar() {
        graficos.drawImage(new Image(FONDO), 0, 0);
        jugador.pintar(graficos);
    }
    
    public void gestionEventos() {
        escena.setOnKeyPressed(new EventHandler<KeyEvent>(){
            //se ejecuta cuando se presiona una tecla
            @Override
            public void handle(KeyEvent evento) {
                System.out.println("tecla "+ evento.getCode());
                switch(evento.getCode().toString()){
                    case "RIGHT":
                       derecha = true;
                        break;
                    
                    case "LEFT":
                       izquierda = true;
                       break;
                       
                    case "UP":
                       arriba = true;
                       break;
                       
                    case "DOWN":
                       abajo = true;
                       break;   
                }
            }
        });
        escena.setOnKeyReleased(new EventHandler<KeyEvent>(){
            //se ejecuta cuando se suelta una tecla
            @Override
            public void handle(KeyEvent evento) {
                System.out.println("tecla soltada "+ evento.getCode());
                switch(evento.getCode().toString()){
                    case "RIGHT":
                       derecha = false;
                        break;
                    
                    case "LEFT":
                       izquierda = false;
                       break;
                       
                    case "UP":
                       arriba = false;
                       break;
                       
                    case "DOWN":
                       abajo = false;
                       break;   
                }
            }
            
        });
    }

}
