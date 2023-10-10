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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import modelo.servicios;

/**
 * FXML Controller class
 *
 * @author Fabrizio
 */
public class ServiciosController implements Initializable {

   @FXML
    private TextField buscar;
   @FXML
    private Button btnNuevo;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TableView<servicios> tablaServicio;
    @FXML
    private TableColumn<servicios, Integer> columnaId;
    @FXML
    private TableColumn<servicios, String> columnaNombre;
    @FXML
    private TableColumn<servicios, String> columnaDescripcion;
    @FXML
    private TableColumn<servicios, Integer> columnaCosto;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtCosto;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDescripcion;
    
    servicios s = new servicios();
    ObservableList<servicios> registros;
    ObservableList<servicios> registrosfiltrados;
    ArrayList<String> combos = new ArrayList<>();
    boolean modificar = false;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargardatos();
    }
    
    @FXML
    private void buscar(KeyEvent event) {
        registrosfiltrados = FXCollections.observableArrayList();
        String cadena = buscar.getText();
        if (cadena.isEmpty()) {
            tablaServicio.setItems(registros);
        } else {
            registrosfiltrados.clear();
            for (servicios registro : registros) {
                if (registro.getNombre().toLowerCase().contains(cadena.toLowerCase())) {
                    registrosfiltrados.add(registro);
                }
            }
        tablaServicio.setItems(registrosfiltrados);
        }
    }
    
    @FXML
    private void mostrarDatos(MouseEvent event) {
        s = tablaServicio.getSelectionModel().getSelectedItem();
        txtId.setText(String.valueOf(s.getId()));
        txtCosto.setText(String.valueOf(s.getCosto()));
        txtNombre.setText(String.valueOf(s.getNombre()));
        txtDescripcion.setText(String.valueOf(s.getDescripcion()));
        btnCancelar.setDisable(false);
        btnModificar.setDisable(false);
        btnEliminar.setDisable(false);
        btnNuevo.setDisable(true);
    }
    
    @FXML
    private void nuevo(ActionEvent event) {
        btnGuardar.setDisable(false);
        btnNuevo.setDisable(true);
        btnCancelar.setDisable(false);
        txtId.setDisable(false);
        txtDescripcion.setDisable(false);
        txtNombre.setDisable(false);
        txtCosto.setDisable(false);
        txtId.requestFocus();
    }
    
   @FXML
    private void modificar(ActionEvent event) {
        btnGuardar.setDisable(false);
        btnNuevo.setDisable(true);
        btnModificar.setDisable(true);
        btnCancelar.setDisable(false);
        btnEliminar.setDisable(true);
        txtId.setDisable(false);
        txtDescripcion.setDisable(false);
        txtNombre.setDisable(false);
        txtCosto.setDisable(false);
        txtId.requestFocus();
        modificar = true;
    }
    
    @FXML
     private void eliminar(ActionEvent event) {
        btnGuardar.setDisable(true);
        btnModificar.setDisable(true);
        btnCancelar.setDisable(true);
        btnEliminar.setDisable(true);
        btnNuevo.setDisable(false);
        limpiarcampos();
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"Desea eliminar el dato seleccionado?"+"\n"+"1- Si"+"\n"+"2- No"));
        if (opcion == 1){
            if (s.borrar()) {
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setHeaderText(null);
                alerta.setTitle("El sistema comunica");
                alerta.setContentText("Datos borrados correctamente");
                alerta.show();
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setTitle("El sistema comunica");
                alerta.setContentText("Ha ocurrido un error");
                alerta.show();
            }
            cargardatos();
        } else {
            
        }
    }

     
    @FXML
    private void guardar(ActionEvent event) {
        if (!modificar) {
            btnModificar.setDisable(true);
            btnEliminar.setDisable(true);
            btnGuardar.setDisable(true);
            btnCancelar.setDisable(true);
            s.setId(Integer.parseInt(txtId.getText()));
            s.setNombre(txtNombre.getText());
            s.setDescripcion(txtDescripcion.getText());
            s.setCosto(Integer.parseInt(txtCosto.getText()));
            txtId.setDisable(true);
            txtNombre.setDisable(true);
            txtDescripcion.setDisable(true);
            txtCosto.setDisable(true);
            if (s.insertar()) {
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
            
        } else {//insertar
            
          
            btnModificar.setDisable(true);
            btnEliminar.setDisable(true);
            btnGuardar.setDisable(true);
            btnCancelar.setDisable(true);
            s.setId(Integer.parseInt(txtId.getText()));
            s.setNombre(txtNombre.getText());
            s.setDescripcion(txtDescripcion.getText());
            s.setCosto(Integer.parseInt(txtCosto.getText()));
            limpiarcampos();
            txtId.setDisable(true);
            txtNombre.setDisable(true);
            txtDescripcion.setDisable(true);
            txtCosto.setDisable(true);
            if (s.modificar()) {
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setHeaderText(null);
                alerta.setTitle("El sistema comunica");
                alerta.setContentText("Datos modificados correctamente");
                alerta.show();
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setTitle("El sistema comunica");
                alerta.setContentText("Ha ocurrido un error");
                alerta.show();
            }
        }
        cancelar(event);
        cargardatos();
    }
    
    @FXML
    private void cancelar(ActionEvent event) {
        limpiarcampos();
        btnGuardar.setDisable(true);
        btnCancelar.setDisable(true);
        txtId.setDisable(true);
        txtNombre.setDisable(true);
        txtDescripcion.setDisable(true);
        txtCosto.setDisable(true);
        btnModificar.setDisable(true);
        btnEliminar.setDisable(true);
        btnNuevo.setDisable(false);
    }
    
    private void limpiarcampos(){
        txtId.clear();
        txtDescripcion.clear();
        txtNombre.clear();
        txtCosto.clear();
    }

    private void cargardatos(){
       ArrayList<servicios> lista = s.consultar();
       registros = FXCollections.observableArrayList(lista);
       columnaId.setCellValueFactory(new PropertyValueFactory<>("id"));
       columnaDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
       columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
       columnaCosto.setCellValueFactory(new PropertyValueFactory<>("costo"));
       tablaServicio.setItems(registros);
    }
    
}
