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
import modelo.cliente;
import modelo.reportes;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class ClienteController implements Initializable {

    @FXML
    private TextField txtcodigo;
    @FXML
    private TextField txtnombre;
    @FXML
    private TextField txtdireccion;
    @FXML
    private TextField txtpropietario;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txttelcontacto;
    @FXML
    private TextField buscar;
    @FXML
    private TableView<cliente> tablaCliente;
    @FXML
    private TableColumn<cliente, Integer> columnaIdEmpresa;
    @FXML
    private TableColumn<cliente, String> columnaNombreEmpresa;
    @FXML
    private TableColumn<cliente, String> columnaDirEmpresa;
    @FXML
    private TableColumn<cliente, String> columnaPropietarioEmpresa;
    @FXML
    private TableColumn<cliente, String> columnaEmailContacto;
    @FXML
    private TableColumn<cliente, String> columnaTelContacto;
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
    cliente c = new cliente();
    ObservableList<cliente> registros;
    ObservableList<cliente> registrosfiltrados;
    reportes r = new reportes();
    boolean modificar = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargardatos();
    }    
    
    @FXML
    private void reporte(ActionEvent event) {
        r.generarReporte("reportes/cliente.jasper", "Informe Cliente");
    }
    
 
    @FXML
    private void buscar(KeyEvent event) {
        registrosfiltrados = FXCollections.observableArrayList();
        String cadena = buscar.getText();
        if (cadena.isEmpty()) {
            tablaCliente.setItems(registros);
        } else {
            registrosfiltrados.clear();
            for (cliente registro : registros) {
                if (registro.getNombre_empresa().toLowerCase().contains(cadena.toLowerCase())) {
                    registrosfiltrados.add(registro);
                }
            }
        tablaCliente.setItems(registrosfiltrados);
        }
    }
 
    @FXML
    private void mostrarDatos(MouseEvent event) {
        c = tablaCliente.getSelectionModel().getSelectedItem();
        txtcodigo.setText(String.valueOf(c.getId_empresa()));
        txtnombre.setText(String.valueOf(c.getNombre_empresa()));
        txtdireccion.setText(String.valueOf(c.getDir_empresa()));
        txtpropietario.setText(String.valueOf(c.getPropietario_empresa()));
        txtemail.setText(String.valueOf(c.getEmail_contacto()));
        txttelcontacto.setText(String.valueOf(c.getTel_contacto()));
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
        txtcodigo.setDisable(false);
        txtnombre.setDisable(false);
        txtdireccion.setDisable(false);
        txtpropietario.setDisable(false);
        txtemail.setDisable(false);
        txttelcontacto.setDisable(false);
        txtcodigo.requestFocus();
    }

    @FXML
    private void modificar(ActionEvent event) {
        btnGuardar.setDisable(false);
        btnNuevo.setDisable(true);
        btnModificar.setDisable(true);
        btnCancelar.setDisable(false);
        btnEliminar.setDisable(true);
        txtcodigo.setDisable(false);
        txtnombre.setDisable(false);
        txtdireccion.setDisable(false);
        txtpropietario.setDisable(false);
        txtemail.setDisable(false);
        txttelcontacto.setDisable(false);
        txtcodigo.requestFocus();
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
            if (c.borrar()) {
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setHeaderText(null);
                alerta.setTitle("El sistema comunica");
                alerta.setContentText("Datos borrados correctamente");
                alerta.show();
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setTitle("El sistema comunica");
                alerta.setContentText("Error");
                alerta.show();
            }
            cargardatos();
        } else {
            
        }
    }

    @FXML
    private void guardar(ActionEvent event) {
        if (modificar) {
            btnModificar.setDisable(true);
            btnEliminar.setDisable(true);
            btnGuardar.setDisable(true);
            btnCancelar.setDisable(true);
            c.setId_empresa(Integer.parseInt(txtcodigo.getText()));
            c.setNombre_empresa(txtnombre.getText());
            c.setDir_empresa(txtdireccion.getText());
            c.setPropietario_empresa(txtpropietario.getText());
            c.setEmail_contacto(txtemail.getText());
            c.setTel_contacto(txttelcontacto.getText());
            limpiarcampos();
            txtcodigo.setDisable(true);
            txtnombre.setDisable(true);
            txtdireccion.setDisable(true);
            txtpropietario.setDisable(true);
            txtemail.setDisable(true);
            txttelcontacto.setDisable(true);
            if (c.modificar()) {
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setHeaderText(null);
                alerta.setTitle("El sistema comunica");
                alerta.setContentText("Datos modificados correctamente");
                alerta.show();
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setTitle("El sistema comunica");
                alerta.setContentText("Ndi");
                alerta.show();
            }
        } else {//insertar
            btnModificar.setDisable(true);
            btnEliminar.setDisable(true);
            btnGuardar.setDisable(true);
            btnCancelar.setDisable(true);
            c.setId_empresa(Integer.parseInt(txtcodigo.getText()));
            c.setNombre_empresa(txtnombre.getText());
            c.setDir_empresa(txtdireccion.getText());
            c.setPropietario_empresa(txtpropietario.getText());
            c.setEmail_contacto(txtemail.getText());
            c.setTel_contacto(txttelcontacto.getText());
            limpiarcampos();
            txtcodigo.setDisable(true);
            txtnombre.setDisable(true);
            txtdireccion.setDisable(true);
            txtpropietario.setDisable(true);
            txtemail.setDisable(true);
            txttelcontacto.setDisable(true);
            if (c.insertar()) {
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setHeaderText(null);
                alerta.setTitle("El sistema comunica");
                alerta.setContentText("Datos insertados correctamente");
                alerta.show();
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setTitle("El sistema comunica");
                alerta.setContentText("Ndi");
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
        txtcodigo.setDisable(true);
        txtcodigo.setDisable(true);
        txtnombre.setDisable(true);
        txtdireccion.setDisable(true);
        txtpropietario.setDisable(true);
        txtemail.setDisable(true);
        txttelcontacto.setDisable(true);
        btnModificar.setDisable(true);
        btnEliminar.setDisable(true);
        btnNuevo.setDisable(false);
    }
   
    
   private void cargardatos(){
       ArrayList<cliente> lista = c.consultar();
       registros = FXCollections.observableArrayList(lista);
       columnaIdEmpresa.setCellValueFactory(new PropertyValueFactory<>("id_empresa"));
       columnaNombreEmpresa.setCellValueFactory(new PropertyValueFactory<>("nombre_empresa"));
       columnaDirEmpresa.setCellValueFactory(new PropertyValueFactory<>("dir_empresa"));
       columnaPropietarioEmpresa.setCellValueFactory(new PropertyValueFactory<>("propietario_empresa"));
       columnaEmailContacto.setCellValueFactory(new PropertyValueFactory<>("email_contacto"));
       columnaTelContacto.setCellValueFactory(new PropertyValueFactory<>("tel_contacto"));
       tablaCliente.setItems(registros);
    } 
   
   private void limpiarcampos(){
        txtcodigo.clear();
        txtnombre.clear();
        txtdireccion.clear();
        txtpropietario.clear();
        txtemail.clear();
        txttelcontacto.clear();
    }
    
}
