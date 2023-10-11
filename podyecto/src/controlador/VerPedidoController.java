/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.detalle_pedido;
import modelo.pedido;

/**
 * FXML Controller class
 *
 * @author Fabrizio
 */
public class VerPedidoController implements Initializable {
    
    @FXML
    private TableView <pedido> tablaPedido;
    @FXML
    private TableColumn<pedido, Integer> columnaIdPedido;
    @FXML
    private TableColumn<pedido, String> columnaFechaInicio;
    @FXML
    private TableColumn<pedido, String> columnaFechaFinal;
    @FXML
    private TableColumn<pedido, Integer> columnaCostoEstimado;
    @FXML
    private TableColumn<pedido, String> columnaDescripcion;
    @FXML
    private TableColumn<pedido, Integer> columnaEstado;
    @FXML
    private TableView<detalle_pedido> tablaDetallePedido;
    @FXML
    private TableColumn<detalle_pedido, Integer> columnaIdFuncionario;
    @FXML
    private TableColumn<detalle_pedido, Integer> columnaIdPedidoDetalle;
    @FXML
    private TableColumn<detalle_pedido, Integer> columnaIdEmpresa;
    @FXML
    private TableColumn<detalle_pedido, Integer> columnaIdServicio;
    @FXML
    private TableColumn<detalle_pedido, Integer> columnaCantidad;
    
    pedido p = new pedido();
    detalle_pedido dp = new detalle_pedido();
    
    ObservableList<pedido> registrosfiltrados;
    ObservableList<pedido> registros;
    ObservableList<detalle_pedido> registrosfiltrados2;
    ObservableList<detalle_pedido> registros2;
    
    ArrayList<pedido> listapedidos=new ArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       cargardatos();
    }  
    
    private void cargardatos(){
        ArrayList<pedido> lista = p.consultar();
        registros = FXCollections.observableArrayList(lista);
        columnaIdPedido.setCellValueFactory(new PropertyValueFactory<>("id_pedido"));
        columnaFechaInicio.setCellValueFactory(new PropertyValueFactory<>("fecha_inicial"));
        columnaFechaFinal.setCellValueFactory(new PropertyValueFactory<>("fecha_final"));
        columnaCostoEstimado.setCellValueFactory(new PropertyValueFactory<>("costo_estimado"));
        columnaDescripcion.setCellValueFactory(new PropertyValueFactory<>("desc_pedido"));
        columnaEstado.setCellValueFactory(new PropertyValueFactory<>("estado_pedido"));
        tablaPedido.setItems(registros);
        
        ArrayList<detalle_pedido> lista2 = dp.consultar();
        registros2 = FXCollections.observableArrayList(lista2);
        columnaIdFuncionario.setCellValueFactory(new PropertyValueFactory<>("id_funcionario"));
        columnaIdPedidoDetalle.setCellValueFactory(new PropertyValueFactory<>("id_pedido"));
        columnaIdEmpresa.setCellValueFactory(new PropertyValueFactory<>("id_empresa"));
        columnaIdServicio.setCellValueFactory(new PropertyValueFactory<>("id_servicio"));
        columnaCantidad.setCellValueFactory(new PropertyValueFactory<>("cant_pedida"));
        tablaDetallePedido.setItems(registros2);
        
        
    
    
    }
    
}
