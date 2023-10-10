/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import modelo.detalle_pedido;
import modelo.cliente;

/**
 * FXML Controller class
 *
 * @author Fabrizio
 */
public class PedidoController implements Initializable {

    @FXML
    private VBox btnCancelar;
    @FXML
    private DatePicker dateInicio;
    @FXML
    private DatePicker dateFinal;
    @FXML
    private TextField txtCostoEstimado;
    @FXML
    private ComboBox<String> comboCliente;
    @FXML
    private TextField txtCantidad;
    @FXML
    private ListView<?> listServicios;
    @FXML
    private ListView<?> listFuncionarios;
    @FXML
    private TableView<detalle_pedido> tablaPedido;
    @FXML
    private Button btnNuevo;
    @FXML
    private Button btnGuardar;
    @FXML
    private TableView<?> tableView;
    
    detalle_pedido dp = new detalle_pedido();
    cliente c= new cliente();
    Boolean modificar = false;
    
    ArrayList<cliente> listac = new ArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void nuevo(ActionEvent event){
        listac= c.consultar();
        for (cliente object : listac) {
            comboCliente.getItems().add(object.getNombre_empresa());
        }
    }
    
}
