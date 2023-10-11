/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultora;

import javafx.application.Application;
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
public class consultora extends Application {
    conexion con = new conexion();
    @Override
    public void start(Stage stage) throws Exception {
        if (con.getCon() == null) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("El sistema comunica");
            alerta.setContentText("Error de conexion");
            alerta.setHeaderText(null);
            alerta.show();
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("/vistas/login.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Inicio de secion");
            stage.setMaximized(false);
            stage.show();
            
            
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}