/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.cliente;
import modelo.detalle_pedido;
import modelo.funcionario;
import modelo.pedido;
import modelo.servicios;

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
    private DatePicker fechaInicial;
    @FXML
    private DatePicker fechaFinal;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Label lbCliente;
    
    detalle_pedido dp = new detalle_pedido();
    servicios s = new servicios();
    funcionario f = new funcionario();
    cliente c = new cliente();
    
    ArrayList<cliente> listaclientes = new ArrayList();
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
    }

    @FXML
    private void cancelar(ActionEvent event) {
    }
    
    @FXML
    private void seleccionarServicio(Event event){
        String cliente = comboCliente.getSelectionModel().getSelectedItem();
        String servicio = comboServicio.getSelectionModel().getSelectedItem();
        String funcionario = comboFuncionario.getSelectionModel().getSelectedItem();
        String empresa = "Empresa: " + cliente;
        int idC = 0, idS = 0, idF = 0;
        for (cliente clientes : listaclientes){
            if (clientes.getNombre_empresa().equals(cliente)){
                idC = clientes.getId_empresa();
                lbCliente.setText(empresa);
            }
        }
       /* for (profesor profesores : listap){
            if (profesores.getCod_profe() == codp){
                String nom_p = profesores.getNom_prof();
                String ape_p = profesores.getApe_prof();
                String profe = "Profesor/a: "+nom_p+" "+ape_p;
                txtProfesor.setText(profe);
            }
        }
        for (horario horarios : listah){
            if (horarios.getCod_materia() == codm && horarios.getCurso().equals(curso) && horarios.getTurno().equals(turno)){
                comboHoraInicial.getItems().add(horarios.gethInicial());
                comboHoraFinal.getItems().add(horarios.gethFinal());
            }
        }*/
    
    
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
