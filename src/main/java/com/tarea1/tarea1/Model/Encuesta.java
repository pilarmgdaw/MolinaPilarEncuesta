package com.tarea1.tarea1.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

@Entity //esto es una anotación que crea una tabla en la base de datos
public class Encuesta {

    @Id //aquí declaro que el id sera la Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio.") //esto son las validaciones, sirven para establecer requisitos en cada campo
    @Size(min =2, message = "El nombre debe de tener al menos dos caracteres.")
    private String nombre;

    @NotBlank(message = "Los apellidos son obligatorios.")
    @Size(min =2, message = "El nombre debe de tener al menos dos caracteres.")
    private String apellido;

    @Email(message = "El formato es inválido.")
    @NotBlank(message = "El email es obligatorio.")
    private String email;

    @Min(value=18, message = "Debes ser mayor de 18 años.")
    private Integer edad;

    @NotBlank(message ="El teléfono es obligatorio")
    private String telefono;

    @PastOrPresent(message = "La fecha de inicio no puede ser futura.")
    private LocalDate fechaInicioEstancia;

    @NotBlank(message = "Debes seleccionar un motivo de visita.")
    private String motivoVisita;


    private List<String> serviciosUtilizados; //es un checkbox

    @NotBlank(message = "El nivel de satisfacción es obligatorio")
    private String nivelSatisfaccion;
    private String otrosComentarios;

    public Encuesta(String apellido, String nombre, Long id, String email, Integer edad, String telefono, LocalDate fechaInicioEstancia, String motivoVisita, List<String> serviciosUtilizados, String nivelSatisfaccion, String otrosComentarios) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.id = id;
        this.email = email;
        this.edad = edad;
        this.telefono = telefono;
        this.fechaInicioEstancia = fechaInicioEstancia;
        this.motivoVisita = motivoVisita;
        this.serviciosUtilizados = serviciosUtilizados;
        this.nivelSatisfaccion = nivelSatisfaccion;
        this.otrosComentarios = otrosComentarios;
    }

    public Encuesta() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOtrosComentarios() {
        return otrosComentarios;
    }

    public void setOtrosComentarios(String otrosComentarios) {
        this.otrosComentarios = otrosComentarios;
    }

    public @NotBlank(message = "El nivel de satisfacción es obligatorio") String getNivelSatisfaccion() {
        return nivelSatisfaccion;
    }

    public void setNivelSatisfaccion(@NotBlank(message = "El nivel de satisfacción es obligatorio") String nivelSatisfaccion) {
        this.nivelSatisfaccion = nivelSatisfaccion;
    }

    public @Min(value = 18, message = "Debes ser mayor de 18 años.") Integer getEdad() {
        return edad;
    }

    public void setEdad(@Min(value = 18, message = "Debes ser mayor de 18 años.") Integer edad) {
        this.edad = edad;
    }

    public @NotBlank(message = "Los apellidos son obligatorios.") @Size(min = 2, message = "El nombre debe de tener al menos dos caracteres.") String getApellido() {
        return apellido;
    }

    public void setApellido(@NotBlank(message = "Los apellidos son obligatorios.") @Size(min = 2, message = "El nombre debe de tener al menos dos caracteres.") String apellido) {
        this.apellido = apellido;
    }

    public @NotBlank(message = "El nombre es obligatorio.") @Size(min = 2, message = "El nombre debe de tener al menos dos caracteres.") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "El nombre es obligatorio.") @Size(min = 2, message = "El nombre debe de tener al menos dos caracteres.") String nombre) {
        this.nombre = nombre;
    }

    public @Email(message = "El formato es inválido.") @NotBlank(message = "El email es obligatorio.") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "El formato es inválido.") @NotBlank(message = "El email es obligatorio.") String email) {
        this.email = email;
    }

    public @NotBlank(message = "El teléfono es obligatorio") String getTelefono() {
        return telefono;
    }

    public void setTelefono(@NotBlank(message = "El teléfono es obligatorio") String telefono) {
        this.telefono = telefono;
    }

    public @PastOrPresent(message = "La fecha de inicio no puede ser futura.") LocalDate getFechaInicioEstancia() {
        return fechaInicioEstancia;
    }

    public void setFechaInicioEstancia(@PastOrPresent(message = "La fecha de inicio no puede ser futura.") LocalDate fechaInicioEstancia) {
        this.fechaInicioEstancia = fechaInicioEstancia;
    }

    public @NotBlank(message = "Debes seleccionar un motivo de visita.") String getMotivoVisita() {
        return motivoVisita;
    }

    public void setMotivoVisita(@NotBlank(message = "Debes seleccionar un motivo de visita.") String motivoVisita) {
        this.motivoVisita = motivoVisita;
    }

    public List<String> getServiciosUtilizados() {
        return serviciosUtilizados;
    }

    public void setServiciosUtilizados(List<String> serviciosUtilizados) {
        this.serviciosUtilizados = serviciosUtilizados;
    }

    @Override
    public String toString() {
        return "Encuesta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", edad=" + edad +
                ", telefono='" + telefono + '\'' +
                ", fechaInicioEstancia=" + fechaInicioEstancia +
                ", motivoVisita='" + motivoVisita + '\'' +
                ", serviciosUtilizados=" + serviciosUtilizados +
                ", nivelSatisfaccion='" + nivelSatisfaccion + '\'' +
                ", otrosComentarios='" + otrosComentarios + '\'' +
                '}';
    }
}
