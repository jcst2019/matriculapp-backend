package com.iep.triunfo.matriculappbackend.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Schema(description = "Información de la Matricula")
@Entity
@Table(name = "matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMatricula;
/*
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_apoderado", nullable = false, foreignKey = @ForeignKey(name = "fk_apoderado_alumno"))
    private Apoderado apoderado;
*/
    /*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProgMatricula", referencedColumnName = "idProgMatricula")
    private ProgramacionMatricula programacionMatricula;*/

    @ManyToOne
    @JoinColumn(name = "id_prog_matricula", nullable = false, foreignKey = @ForeignKey(name = "fk_matricula_programacion"))
    private ProgramacionMatricula programacionMatricula;

    @Column(name = "fecha_matricula", nullable = true)
    private LocalDateTime fechaMatricula;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false, foreignKey = @ForeignKey(name = "fk_matricula_alumno"))
    private Alumno alumno;

    public Integer getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }

    public ProgramacionMatricula getProgramacionMatricula() {
        return programacionMatricula;
    }

    public void setProgramacionMatricula(ProgramacionMatricula programacionMatricula) {
        this.programacionMatricula = programacionMatricula;
    }

    public LocalDateTime getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDateTime fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}
