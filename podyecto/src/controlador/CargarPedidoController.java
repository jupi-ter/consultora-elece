package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class CargarPedidoController implements Initializable { 

    @FXML
    private ComboBox<String> comboBox1;

    @FXML
    private ComboBox<String> comboBox2;

    @FXML
    private DatePicker calendar1;

    @FXML
    private DatePicker calendar2;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private Button nuevoButton;

    @FXML
    private Button modificarButton;

    @FXML
    private Button borrarButton;

    @FXML
    private Button cancelarButton;
    
    @FXML
    private ImageView myImageView;

   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    private void displayImage(){
        Image myImage = new Image(getClass().getResourceAsStream("vistas/ELECE_logo.jpeg"));
        myImageView.setImage(myImage);
    }
    
}    
   