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

public class JavaFXApplication1 extends Application {
    conexion con = new conexion();
    @Override
    public void start(Stage stage) throws Exception {
        if (con.getCon() == null) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("No conectado");
            alerta.setContentText("Contacte a un supervisor.");
            alerta.setHeaderText(null);
            alerta.show();
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("/vistas/login.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.setMaximized(false);
            stage.show();
        }
    }
//este es un comentario
    public static void main(String[] args) {
        launch(args);
    }
    
}