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
import modelo.funcionario;
import modelo.reportes;
/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class FuncionarioController implements Initializable {

    @FXML
    private TextField txtcodigo;
    @FXML
    private TextField txtnombre;
    @FXML
    private TextField txtci;
    @FXML
    private TextField txtprofesion;
    @FXML
    private TextField txtespecialidad;
    @FXML
    private TextField txttelefono;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField buscar;
    @FXML
    private TableView<funcionario> tablaFuncionario;
    @FXML
    private TableColumn<funcionario, Integer> columnaIdFuncionario;
    @FXML
    private TableColumn<funcionario, String> columnaNombreFuncionario;
    @FXML
    private TableColumn<funcionario, String> columnaCiEspecialista;
    @FXML
    private TableColumn<funcionario, String> columnaProfesionFuncionario;
    @FXML
    private TableColumn<funcionario, String> columnaEspecialidadFuncionario;
    @FXML
    private TableColumn<funcionario, String> columnaTelEspecialista;
    @FXML
    private TableColumn<funcionario, String> columnaEmailFuncionario;
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
    funcionario f = new funcionario();
    ObservableList<funcionario> registros;
    ObservableList<funcionario> registrosfiltrados;
    reportes r = new reportes();
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
            tablaFuncionario.setItems(registros);
        } else {
            registrosfiltrados.clear();
            for (funcionario registro : registros) {
                if (registro.getNombre_funcionario().toLowerCase().contains(cadena.toLowerCase())) {
                    registrosfiltrados.add(registro);
                }
            }
        tablaFuncionario.setItems(registrosfiltrados);
        }
    }

    @FXML
    private void mostrarDatos(MouseEvent event) {
        f = tablaFuncionario.getSelectionModel().getSelectedItem();
        txtcodigo.setText(String.valueOf(f.getId_funcionario()));
        txtnombre.setText(String.valueOf(f.getNombre_funcionario()));
        txtci.setText(String.valueOf(f.getCi_especialista()));
        txtprofesion.setText(String.valueOf(f.getProfesion_funcionario()));
        txtespecialidad.setText(String.valueOf(f.getEspecialidad_funcionario()));
        txttelefono.setText(String.valueOf(f.getTel_especialista()));
        txtemail.setText(String.valueOf(f.getEmail_funcionario()));
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
        txtci.setDisable(false);
        txtprofesion.setDisable(false);
        txtespecialidad.setDisable(false);
        txttelefono.setDisable(false);
        txtemail.setDisable(false);
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
        txtci.setDisable(false);
        txtprofesion.setDisable(false);
        txtespecialidad.setDisable(false);
        txttelefono.setDisable(false);
        txtemail.setDisable(false);
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
            if (f.borrar()) {
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
            f.setId_funcionario(Integer.parseInt(txtcodigo.getText()));
            f.setNombre_funcionario(txtnombre.getText());
            f.setCi_especialista(txtci.getText());
            f.setProfesion_funcionario(txtprofesion.getText());
            f.setEspecialidad_funcionario(txtespecialidad.getText());
            f.setTel_especialista(txttelefono.getText());
            f.setEmail_funcionario(txtemail.getText());
            limpiarcampos();
            txtcodigo.setDisable(true);
            txtnombre.setDisable(true);
            txtci.setDisable(true);
            txtprofesion.setDisable(true);
            txtespecialidad.setDisable(true);
            txttelefono.setDisable(true);
            txtemail.setDisable(true);
            if (f.modificar()) {
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
            f.setId_funcionario(Integer.parseInt(txtcodigo.getText()));
            f.setNombre_funcionario(txtnombre.getText());
            f.setCi_especialista(txtci.getText());
            f.setProfesion_funcionario(txtprofesion.getText());
            f.setEspecialidad_funcionario(txtespecialidad.getText());
            f.setTel_especialista(txttelefono.getText());
            f.setEmail_funcionario(txtemail.getText());
            limpiarcampos();
            txtcodigo.setDisable(true);
            txtnombre.setDisable(true);
            txtci.setDisable(true);
            txtprofesion.setDisable(true);
            txtespecialidad.setDisable(true);
            txttelefono.setDisable(true);
            txtemail.setDisable(true);
            if (f.insertar()) {
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
        txtnombre.setDisable(true);
        txtci.setDisable(true);
        txtprofesion.setDisable(true);
        txtespecialidad.setDisable(true);
        txttelefono.setDisable(true);
        txtemail.setDisable(true);
        btnModificar.setDisable(true);
        btnEliminar.setDisable(true);
        btnNuevo.setDisable(false);
    }
    
   private void cargardatos(){
       ArrayList<funcionario> lista = f.consultar();
       registros = FXCollections.observableArrayList(lista);
       columnaIdFuncionario.setCellValueFactory(new PropertyValueFactory<>("id_funcionario"));
       columnaNombreFuncionario.setCellValueFactory(new PropertyValueFactory<>("nombre_funcionario"));
       columnaCiEspecialista.setCellValueFactory(new PropertyValueFactory<>("ci_especialista"));
       columnaProfesionFuncionario.setCellValueFactory(new PropertyValueFactory<>("profesion_funcionario"));
       columnaEspecialidadFuncionario.setCellValueFactory(new PropertyValueFactory<>("especialidad_funcionario"));
       columnaTelEspecialista.setCellValueFactory(new PropertyValueFactory<>("tel_especialista"));
       columnaEmailFuncionario.setCellValueFactory(new PropertyValueFactory<>("email_funcionario"));
       tablaFuncionario.setItems(registros);
    }
   
    private void limpiarcampos() {
        txtcodigo.clear();
        txtnombre.clear();
        txtci.clear();
        txtprofesion.clear();
        txtespecialidad.clear();
        txttelefono.clear();
        txtemail.clear();
    }
}
