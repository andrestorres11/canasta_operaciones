package cosechaoperacionesv1;

import cosechaoperacionesv1.clases.Jugador;
import cosechaoperacionesv1.clases.Legumbre;
import cosechaoperacionesv1.clases.Sonidos;
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
    private Legumbre legumbre;
    private int x = 0;
    public static boolean arriba;    
    public static boolean abajo;
    public static boolean derecha;
    public static boolean izquierda;
    private static final String FONDO = "/imagenesJuegoParadigmas/interfaz-juego-sumar/fondo2-12-0620.png";
    private static final String CANASTO = "/imagenesJuegoParadigmas/interfaz-juego-canasto/canasto2.png";
    private static final String LEGUMBRE = "/imagenesJuegoParadigmas/interfaz-juego-canasto/3.png";
    Sonidos reproduce  =new Sonidos();
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
    public void start(Stage ventana) throws  Exception {
        inicializarComponentes();
        gestionEventos();
        ventana.setScene(escena);
        ventana.setTitle("cosecha operaciones");
        ventana.show();
        cicloJuego();
        reproduce.SonidoFondo();
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
        jugador.verificarColisionLegumbres(legumbre);
        jugador.mover();
        legumbre.mover();
    }
    
    public void inicializarComponentes() {
        jugador = new Jugador(10, 400, 0, CANASTO);
        root = new Group();
        escena = new Scene(root, 700, 500);
        int numero = (int) (Math.random() * 600) + 1;
        legumbre = new Legumbre(numero, -100, 1, LEGUMBRE);
        lienzo = new Canvas(700, 500);
        root.getChildren().add(lienzo);
        graficos = lienzo.getGraphicsContext2D();
        
    }
    
    public void pintar() {
        graficos.drawImage(new Image(FONDO), 0, 0);
        jugador.pintar(graficos);
        legumbre.pintar(graficos);
        graficos.fillText("Puntos: "+jugador.getVidas(), 20, 20);
    }
    
    public void gestionEventos() {
        escena.setOnKeyPressed(new EventHandler<KeyEvent>(){
            //se ejecuta cuando se presiona una tecla
            @Override
            public void handle(KeyEvent evento) {
                //System.out.println("tecla "+ evento.getCode());
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
                       
                    case "SPACE":
                        jugador.setVelocidad(20);
                        break;
                }
            }
        });
        escena.setOnKeyReleased(new EventHandler<KeyEvent>(){
            //se ejecuta cuando se suelta una tecla
            @Override
            public void handle(KeyEvent evento) {
                //System.out.println("tecla soltada "+ evento.getCode());
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
                    
                    case "SPACE":
                        jugador.setVelocidad(20);
                        break;
                }
            }
            
        });
    }
// Prueba Git Cryaruro
}
