package com.iep.triunfo.matriculappbackend.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Información del Alumno")
@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlumno;
/*
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_apoderado", nullable = false, foreignKey = @ForeignKey(name = "fk_apoderado_alumno"))
    private Apoderado apoderado;
*/
    @ManyToMany(fetch = FetchType.EAGER) // Porque es poca data se carga en la lista apoderados y se usa EAGER
    @JoinTable(name = "alumno_apoderado", joinColumns = @JoinColumn(name = "idAlumno", referencedColumnName = "idAlumno"), inverseJoinColumns = @JoinColumn(name = "idApoderado", referencedColumnName = "idApoderado"))
    private List<Apoderado> apoderados;

    @Schema(description = "Nombre debe de Tener mínimo 70 caracteres")
    @Size(min = 3, message = "Nombre debe de Tener mínimo 3 caracteres")
    @Column(name="nombres", nullable = false, length = 70)
    private String nombre;

    @Schema(description = "Apellidos debe de Tener mínimo 70 caracteres")
    @Size(min = 3, message = "Apellidos debe de Tener mínimo 3 caracteres")
    @Column(name="apellidos", nullable = false, length = 70)
    private String apellidos;

    @Schema(description = "Género debe de Tener 1 dígito")
    @Min(1)
    @Max(2)
    @Column(name="genero", nullable = true)
    private Integer genero;

    @Schema(description = "DNI debe de Tener mínimo 8 caracteres")
    @Size(min = 8, max = 8, message = "DNI debe de Tener mínimo 8 caracteres")
    @Column(name="dni", nullable = false, length = 8)
    private String dni;

    @Schema(description = "Dirección debe de Tener mínimo 200 caracteres")
    @Size(min = 3, max = 200, message = "Dirección debe de Tener mínimo 200 caracteres")
    @Column(name="direccion", nullable = true, length = 200)
    private String direccion;

    @Column(name="telefono", nullable = true,length = 25)
    private String telefono;

    @Column(name = "fecha_nacimiento", nullable = true)
    private LocalDateTime fechaNacimiento;

    @Column(name = "fecha_ingreso", nullable = true)
    private LocalDateTime fechaIngreso;

    @Column(name = "fecha_registro", nullable = true)
    private LocalDateTime fechaRegistro;

    @Email
    @Column(name="email", nullable = true, length = 70)
    private String email;

    @Column(name = "tipo_descuento", nullable = false)
    private Integer tipoDescuento;

    @Column(name = "estado", nullable = true)
    private Integer estado;

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public List<Apoderado> getApoderados() {
        return apoderados;
    }

    public void setApoderados(List<Apoderado> apoderados) {
        this.apoderados = apoderados;
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

    public Integer getGenero() {
        return genero;
    }

    public void setGenero(Integer genero) {
        this.genero = genero;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTipoDescuento() {
        return tipoDescuento;
    }

    public void setTipoDescuento(Integer tipoDescuento) {
        this.tipoDescuento = tipoDescuento;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
