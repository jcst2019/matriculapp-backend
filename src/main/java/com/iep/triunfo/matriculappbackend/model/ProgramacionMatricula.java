package com.iep.triunfo.matriculappbackend.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Schema(description = "Información de la Programación de la Matricula")
@Entity
@Table(name = "prog_matricula")
public class ProgramacionMatricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProgMatricula;
    /*
        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "id_apoderado", nullable = false, foreignKey = @ForeignKey(name = "fk_apoderado_alumno"))
        private Apoderado apoderado;
    */

    @Schema(description = "Código de Matrícula debe de Tener mínimo 4 caracteres")
    @Size(min = 4, message = "Código de Matrícula debe de Tener mínimo 4 caracteres")
    @Column(name = "codigo_matricula", nullable = false, length = 70)
    private String codigoMatricula;

    @Schema(description = "Descripción debe de Tener máximo 200 caracteres")
    @Column(name = "descripcion", nullable = true, length = 200)
    private String Descripción;

    @Schema(description = "Cantidad de Cupos Total debe de Tener mínimo 1 dígito")
    @Min(1)
    @Max(200)
    @Column(name = "cupos_total", nullable = false)
    private Integer cantidadCuposTotal;

    @Schema(description = "Cantidad de Cupos Registrados debe de Tener mínimo 1 dígito")
    @Min(1)
    @Max(200)
    @Column(name = "cupos_registrados", nullable = false)
    private Integer cantidadCuposRegistrados;

    @Schema(description = "Año debe de Tener mínimo 4 caracteres")
    @Size(min = 4, max = 4, message = "Año debe de Tener mínimo 4 caracteres")
    @Column(name = "anio", nullable = true, length = 4)
    private String year;

    @Schema(description = "Grado debe de Tener 1 dígito")
    @Min(1)
    @Max(2)
    @Column(name = "grado", nullable = false)
    private Integer grado;

    @Schema(description = "Seccion debe de Tener 1 caracter")
    @Size(min = 1, max = 1, message = "Seccion debe de Tener mínimo 1 caracter")
    @Column(name = "seccion", nullable = false)
    private String seccion;

    @Schema(description = "Nivel debe de Tener 1 dígito")
    @Min(1)
    @Max(2)
    @Column(name = "nivel", nullable = false)
    private Integer nivel;

    @Column(name = "mto_matricula", nullable = false)
    private Float montoMatricula;

    @Column(name = "mto_mensualidad", nullable = false)
    private Float montoMensualidad;

    @Column(name = "fecha_registro", nullable = true)
    private LocalDateTime fechaRegistro;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    public Integer getIdProgMatricula() {
        return idProgMatricula;
    }

    public void setIdProgMatricula(Integer idProgMatricula) {
        this.idProgMatricula = idProgMatricula;
    }

    public String getCodigoMatricula() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(String codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }

    public String getDescripción() {
        return Descripción;
    }

    public void setDescripción(String descripción) {
        Descripción = descripción;
    }

    public Integer getCantidadCuposTotal() {
        return cantidadCuposTotal;
    }

    public void setCantidadCuposTotal(Integer cantidadCuposTotal) {
        this.cantidadCuposTotal = cantidadCuposTotal;
    }

    public Integer getCantidadCuposRegistrados() {
        return cantidadCuposRegistrados;
    }

    public void setCantidadCuposRegistrados(Integer cantidadCuposRegistrados) {
        this.cantidadCuposRegistrados = cantidadCuposRegistrados;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}