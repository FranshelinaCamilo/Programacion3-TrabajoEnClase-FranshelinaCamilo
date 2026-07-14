package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {
    
    /** Código de la cita
* Nombre del paciente
* Cédula
* Teléfono
* Médico
* Especialidad
* Fecha de la cita
* Hora
* Motivo de consulta
* Estado */
    private String codigo;
    private String nombrePaciente;
    private long cedula;
    private long telefono;
    private String medico;
    private String especialidad;
    private LocalDate fechaCita;
    private LocalTime hora;
    private String motivoConsulta;
    private String estado;

    //contructores
    public Cita(String codigo, String nombrePaciente, long cedula, long telefono, String medico,
            String especialidad, LocalDate fechaCita, LocalTime hora, String motivoConsulta, String estado) {
        setCodigo(codigo);
        setNombrePaciente(nombrePaciente);
        setCedula(0);
        setTelefono(0);
        setMedico(medico);
        setEspecialidad(especialidad);
        setFechaCita(fechaCita);
        setHora(hora);
        setMotivoConsulta(motivoConsulta);
        setEstado(estado);
    }
    public Cita(){
        setCodigo("");
        setNombrePaciente("");
        setCedula(0);
        setTelefono(0);
        setMedico("");
        setEspecialidad("");
        setFechaCita(LocalDate.now());
        setHora(LocalTime.now());
        setMotivoConsulta("");
        setEstado("");
    }

    //getters y setters
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombrePaciente() {
        return nombrePaciente;
    }
    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }
    public long getCedula() {
        return cedula;
    }
    public void setCedula(long cedula) {
        this.cedula = cedula;
    }
    public long getTelefono() {
        return telefono;
    }
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    public String getMedico() {
        return medico;
    }
    public void setMedico(String medico) {
        this.medico = medico;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public LocalDate getFechaCita() {
        return fechaCita;
    }
    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }
    public LocalTime getHora() {
        return hora;
    }
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    public String getMotivoConsulta() {
        return motivoConsulta;
    }
    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
