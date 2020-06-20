/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosechaoperacionesv1;
 //prueba 2
import java.awt.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * POLITECNICO GRACOLOMBIANO Pradigmas de Programacion Ingenieria Software
 *
 * @author acastroc Albeiro Castro Codigo:2011023897 Fecha de Inicio:12-06-20
 */
public class InicioController implements Initializable {

    @FXML
    private Label label;
    private Button button;
    private Button btnopciones;
    private Button btncerrar;
    private Button btnsalirm;

    @FXML
//    Evento mendiante el boton para llamar la interfaz de juego
    private void Comenzar(ActionEvent event) {
        Mover fra = new Mover(); //Realizamos una intancia a Jframe-Mover para abrir la interfaz del juego inicio del mismo.
        fra.setVisible(true);
        Platform.exit();//Linea para que cuando se abra la ventana nueva la anterior se cierre.
        //Realizado por @author acastroc 12-06-20
    }
//Prueba git subida
    @FXML
    private void Opciones(ActionEvent event) {
      try {
 
           // Cargo la vista
           FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
 
           // Cargo la ventana
           Parent root = loader.load();
            
           // Creo el Scene
           Scene scene = new Scene(root);
           Stage stage = new Stage();
           stage.initModality(Modality.APPLICATION_MODAL);
           stage.setScene(scene);
           stage.showAndWait();
 
       } catch (IOException e) {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setHeaderText(null);
           alert.setTitle("Error");
           alert.setContentText(e.getMessage());
           alert.showAndWait();
       }
 
   }
    
//Realizado por @author acastroc 14-06-20

    @FXML
    private void cerrarVentana(ActionEvent event) {

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void cerrarVentanaM(ActionEvent event) {

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
// luis estuvo aquí
}
