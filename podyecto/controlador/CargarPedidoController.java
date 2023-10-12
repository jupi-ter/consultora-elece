/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import modelo.cliente;
import modelo.detalle_pedido;
import modelo.funcionario;
import modelo.pedido;
import modelo.servicios;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Fabrizio
 */
public class CargarPedidoController implements Initializable {

    @FXML
    private ComboBox<String> comboCliente;
    @FXML
    private ComboBox<String> comboServicio;
    @FXML
    private ComboBox<String> comboFuncionario;
    @FXML
    private DatePicker fechaInicial = new DatePicker(LocalDate.now());
    @FXML
    private DatePicker fechaFinal = new DatePicker(LocalDate.now());
    @FXML
    private TextField txtDescripcion;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Label lbCliente;
    @FXML
    private TextField txtIdPedido;
    @FXML
    private TextField txtCant;
     @FXML
    private TextField txtEstado;
     @FXML
     private Stage stage;
    
    detalle_pedido dp = new detalle_pedido();
    pedido p = new pedido();
    servicios s = new servicios();
    funcionario f = new funcionario();
    cliente c = new cliente();
    
    ArrayList<cliente> listaclientes = new ArrayList();
    ArrayList<pedido> listapedido = new ArrayList();
    ArrayList<servicios> listaservicio = new ArrayList();
    ArrayList<funcionario> listafuncionario = new ArrayList();
    ArrayList<String> combo = new ArrayList<>();
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       cargarCombo();
    }    

    @FXML
private void guardar(ActionEvent event) {
    int idc, ids, idf, costest;
    
    
    // Set properties before inserting
    p.setId_pedido(Integer.parseInt(txtIdPedido.getText()));
    p.setDesc_pedido(txtDescripcion.getText());
    p.setFecha_inicial(fechaInicial.getValue().toString());
    p.setFecha_final(fechaFinal.getValue().toString());
    p.setEstado_pedido(Integer.parseInt(txtEstado.getText()));
    
    dp.setId_pedido(Integer.parseInt(txtIdPedido.getText()));
    dp.setCant_pedida(Integer.parseInt(txtCant.getText()));
    
    String cliente = comboCliente.getSelectionModel().getSelectedItem();
    for (cliente clientes: listaclientes){
        if (clientes.getNombre_empresa().equals(cliente)){
            idc = clientes.getId_empresa();
            dp.setId_empresa(idc);
        }
    }
    
    String servicio = comboServicio.getSelectionModel().getSelectedItem();
    for (servicios servicios: listaservicio){
        if (servicios.getNombre().equals(servicio)){
            ids = servicios.getId();
            costest = servicios.getCosto();
            p.setCosto_estimado(costest);
            dp.setId_servicio(ids);
        }
    }
    
    String funcionario = comboFuncionario.getSelectionModel().getSelectedItem();
    for (funcionario funcionarios: listafuncionario){
        if (funcionarios.getNombre_funcionario().equals(funcionario)){
            idf = funcionarios.getId_funcionario();
            dp.setId_funcionario(idf);
        }
    }
    
    // Insert after setting properties
    if (p.insertar() && dp.insertar()) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setHeaderText(null);
        alerta.setTitle("El sistema comunica");
        alerta.setContentText("Datos insertados correctamente");
        alerta.show();
    } else {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setHeaderText(null);
        alerta.setTitle("El sistema comunica");
        alerta.setContentText("Ha ocurrido un error");
        alerta.show();
    }
}

       

        
    
@FXML
private void cancelar(ActionEvent event) {
 
}

    
     @FXML
    private void handleInput(KeyEvent event) {
        String input = event.getCharacter();

        // Allow only '0' or '1'
        if (!input.matches("[01]")) {
            event.consume();  // Consume the event to prevent the character from being entered
        }
        
        if (input.length() > 1) {
            event.consume();  // Consume the event to prevent additional characters
        }

    }   
    
    @FXML
    private void seleccionarCliente(Event event){
        String cliente = comboCliente.getSelectionModel().getSelectedItem();
        String empresa = "Empresa: " + cliente;
        for (cliente clientes : listaclientes){
            if (clientes.getNombre_empresa().equals(cliente)){
                lbCliente.setText(empresa);
            }
        }
    }
    
    private void cargarCombo(){
        listaclientes = c.consultar();
        for (cliente object: listaclientes){
            comboCliente.getItems().add(object.getNombre_empresa());
        }
        
        listaservicio = s.consultar();
        for (servicios object: listaservicio){
            comboServicio.getItems().add(object.getNombre());
        }
        
        listafuncionario = f.consultar();
        for (funcionario object: listafuncionario){
            comboFuncionario.getItems().add(object.getNombre_funcionario());
        }
        
        
    }
   
}
