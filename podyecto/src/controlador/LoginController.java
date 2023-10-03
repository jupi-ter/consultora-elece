package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // You can add login logic here
        // For simplicity, let's just print the input
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }

    @FXML
    private void handleCancel() {
        // You can add cancel logic here
        System.out.println("Login cancelled.");
    }
}
