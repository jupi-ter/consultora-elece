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
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class MenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
  @FXML
    private void loadClientesView(ActionEvent event) throws Exception {
         abrirventana("Clientes","/vistas/clientes.fxml");
    }

    @FXML
    private void loadFuncionariosView(ActionEvent event) throws Exception {
         abrirventana("Funcionarios","/vistas/funcionarios.fxml");
    }

    @FXML
    private void loadServiciosView(ActionEvent event) throws Exception {
         abrirventana("Servicios","/vistas/servicios.fxml");
    }

    @FXML
    private void loadProyectosView(ActionEvent event) throws Exception {
        abrirventana("Pedido","/vistas/pedido.fxml");
                
    }

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
    
    
}
