package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Cita;
import utils.ArchivoUtils;

public class PrincipalController {
    
    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtPaciente;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtHora;

    @FXML
    private ComboBox<String> cmbMedico;

    @FXML
    private ComboBox<String> cmbEspecialidad;

    @FXML
    private ComboBox<String> cmbEstado;

    @FXML
    private DatePicker dpFecha;

    @FXML
    private TextArea taMotivo;

    @FXML
    private TableView<Cita> tvCitas;

    @FXML
    private TableColumn<Cita, String> colCodigo;

    @FXML
    private TableColumn<Cita, String> colPaciente;

    @FXML
    private TableColumn<Cita, String> colMedico;

    @FXML
    private TableColumn<Cita, String> colEspecialidad;

    @FXML
    private TableColumn<Cita, LocalDate> colFecha;

    @FXML
    private TableColumn<Cita, LocalTime> colHora;

    @FXML
    private TableColumn<Cita, String> colEstado;

    private ObservableList<Cita> listaCitas;

    @FXML
    public void initialize(){
        cmbEstado.setItems(FXCollections.observableArrayList("Programada", "Atendida", "Cancelada"));
        cmbEspecialidad.setItems(FXCollections.observableArrayList("Cardiologia", "Neurologia", "Ortopedia", "Pediatria", "Medicina Familiar"));
        cmbMedico.setItems(FXCollections.observableArrayList("Dr. Abreu", "Dr. Correa", "Dr. Martinez", "Dra. Hidalgo"));

        listaCitas = FXCollections.observableArrayList();

        colCodigo.setCellValueFactory(
            new PropertyValueFactory<>("codigo")
        );
        colPaciente.setCellValueFactory(
            new PropertyValueFactory<>("nombrePaciente")
        );
        colMedico.setCellValueFactory(
            new PropertyValueFactory<>("medico")
        );
        colEspecialidad.setCellValueFactory(
            new PropertyValueFactory<>("especialidad")
        );
        colFecha.setCellValueFactory(
            new PropertyValueFactory<>("fechaCita")
        );
        colHora.setCellValueFactory(
            new PropertyValueFactory<>("hora")
        );
        colEstado.setCellValueFactory(
            new PropertyValueFactory<>("estado")
        );

        tvCitas.setItems(listaCitas);
    }

    private Cita crearCita(){
        Cita cita = new Cita(txtCodigo.getText(), txtPaciente.getText(), 
                            Long.parseLong(txtCedula.getText()), Long.parseLong(txtTelefono.getText()), 
                            cmbMedico.getValue(), cmbEspecialidad.getValue(), dpFecha.getValue(), 
                            LocalTime.parse(txtHora.getText()), taMotivo.getText(),cmbEstado.getValue());
        return cita;
    }

    @FXML
    private void Limpiar(){
        txtCodigo.clear();
        txtPaciente.clear();
        txtCedula.clear();
        txtTelefono.clear();
        cmbMedico.getSelectionModel().clearSelection();
        cmbEspecialidad.getSelectionModel().clearSelection();
        cmbEstado.getSelectionModel().clearSelection();
        dpFecha.setValue(null);
        dpFecha.getEditor().clear();
        txtHora.clear();
        taMotivo.clear();
    }

    @FXML
    private void guardarCitas(){
        try {
            if (listaCitas.isEmpty()) {
                mostrarAlerta("Sin datos", "No hay citas registradas para guardar.", Alert.AlertType.WARNING);
                return;
            }

            ArchivoUtils.guardarCita(listaCitas);
            mostrarAlerta("Éxito", "Citas almacenadas correctamente.", Alert.AlertType.INFORMATION);
            
        } catch (Exception e) {
            mostrarAlerta("Error", "No se pudo guardar el archivo: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void registrarCita(){
        Cita cita = crearCita();
        listaCitas.add(cita);

        Limpiar();
    }

    @FXML
    private void cancelarCita(){
        int indice = tvCitas.getSelectionModel().getSelectedIndex();
        Cita cita = tvCitas.getSelectionModel().getSelectedItem();
        
        if (cita == null) {
            mostrarAlerta("Selección Requerida", 
                         "Por favor, seleccione una cita de la tabla para cancelarla.", 
                                  Alert.AlertType.WARNING);
            return;
        }
        
        cita.setEstado("Cancelada");
        listaCitas.set(indice, cita);
        mostrarAlerta("Cita Cancelada", 
                     "El estado de la cita ha sido modificado a 'Cancelada'.", 
                              Alert.AlertType.INFORMATION);
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @FXML
    private void CargarCitas(){
        try {
        List<Cita> citasCargadas = ArchivoUtils.leerCitas();

        listaCitas.clear();
        listaCitas.addAll(citasCargadas);

    } catch (Exception e) {
       System.out.println("Error al cargar el archivo de citas: " + e.getMessage());
    }
    }
}
