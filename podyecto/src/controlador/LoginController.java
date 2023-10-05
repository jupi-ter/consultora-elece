/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    private void loginButtonAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        //auth logic (rudimentary)
        if (username.equals("admin") && password.equals("1234")) {
            
        } else {
            statusLabel.setText("Usuario/Contraseña incorrectos");
        }
    }
    
    private void displayImage(){
        Image myImage = new Image(getClass().getResourceAsStream("vistas/ELECE_logo.jpeg"));
        myImageView.setImage(myImage);
    }
    
}
