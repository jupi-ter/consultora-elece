/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class LoginController implements Initializable {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label statusLabel;
    @FXML
    private ImageView myImageView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    

    @FXML
    private void loginAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        //auth logic (rudimentary)
        if (username.equals("admin") && password.equals("1234")) {
            abrirventana("Menu ELECE","/vistas/menu.fxml");
            statusLabel.setText("Inicio exitoso.");
        } else {
            statusLabel.setText("Usuario/Contraseña incorrectos");
        }
    }
    
    @FXML
    public void abrirventana(String titulo, String direccion){
        try {
            Stage stage = new Stage();
            Parent formulario = FXMLLoader.load(getClass().getResource(direccion));
            Scene scene = new Scene(formulario);
            stage.setTitle(titulo);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void displayImage() {
        Image myImage = new Image(getClass().getResourceAsStream("vistas/ELECE_logo.jpeg"));
        myImageView.setImage(myImage);
    }
    
}
