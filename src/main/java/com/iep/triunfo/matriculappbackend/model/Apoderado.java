package com.iep.triunfo.matriculappbackend.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Información del Apoderado")
@Entity
@Table(name = "apoderado")
public class Apoderado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idApoderado;

    @Schema(description = "Nombre debe de Tener mínimo 70 caracteres")
    @Size(min = 3, message = "Nombre debe de Tener mínimo 3 caracteres")
    @Column(name="nombres", nullable = false, length = 70)
    private String nombre;

    @Schema(description = "Apellidos debe de Tener mínimo 70 caracteres")
    @Size(min = 3, message = "Apellidos debe de Tener mínimo 3 caracteres")
    @Column(name="apellidos", nullable = false, length = 70)
    private String apellidos;

    @Schema(description = "Género debe de Tener 1 dígito")
    @Column(name="tipo", nullable = true)
    private Integer tipo;

    @Schema(description = "Tipo de Documento")
    @Column(name="tipo_documento", nullable = false)
    private Integer tipoDocumento;

    @Schema(description = "Número de Documento")
    @Column(name="num_documento", nullable = false)
    private String numDocumento;

    @Schema(description = "Dirección debe de Tener mínimo 200 caracteres")
    @Size(min = 3, max = 200, message = "Dirección debe de Tener mínimo 200 caracteres")
    @Column(name="direccion", nullable = true, length = 200)
    private String direccion;

    @Column(name="telefono", nullable = true, length = 25)
    private String telefono;

    @Column(name = "fecha_nacimiento", nullable = true)
    private LocalDateTime fechaNacimiento;

    @Column(name = "fecha_reg", nullable = true)
    private LocalDateTime fechaRegistro;

    @Column(name = "fecha_modif", nullable = true)
    private LocalDateTime fechaModificacion;

    @Email
    @Column(name="email", nullable = true, length = 70)
    private String email;

    /*
    @OneToMany(mappedBy = "apoderado", cascade = { CascadeType.ALL }, orphanRemoval = true)
    private List<Alumno> listaAlumnos;*/

    @Column(name = "estado", nullable = false)
    private Integer estado;

    public Integer getIdApoderado() {
        return idApoderado;
    }

    public void setIdApoderado(Integer idApoderado) {
        this.idApoderado = idApoderado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Integer tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}
