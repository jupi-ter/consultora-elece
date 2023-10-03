/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultora;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import modelo.conexion;

/**
 *
 * @author TERCEROS TM
 */
public class JavaFXApplication1 extends Application {
    conexion con = new conexion();
    @Override
    public void start(Stage stage) throws Exception {
        if (con.getCon() == null) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("El sistema comunica");
            alerta.setContentText("Ndi");
            alerta.setHeaderText(null);
            alerta.show();
        } else {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("El sistema comunica");
            alerta.setContentText("Conectado.");
            alerta.setHeaderText(null);
            alerta.show();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}