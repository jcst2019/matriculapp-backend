package com.iep.triunfo.matriculappbackend.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.time.LocalDateTime;

@Schema(description = "Información del Detalle del Cronograma")
@Entity
@Table(name = "detalle_cronograma")
public class DetalleCronograma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleCronograma;

    @ManyToOne
    @JoinColumn(name = "id_cronograma", nullable = false, foreignKey = @ForeignKey(name = "fk_cronograma_detalle"))
    private Cronograma cronograma;

    @Column(name = "periodo", nullable = false)
    private String periodo;

    @Column(name = "monto_sistema", nullable = false)
    private Float montoSistema;

    @Column(name = "monto_descuento", nullable = false)
    private Float montoDescuento;

    @Column(name = "monto_pagar", nullable = false)
    private Float montoPagar;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @Column(name = "fecha_registro", nullable = true)
    private LocalDateTime fechaRegistro;

    @Column(name = "fecha_modificacion", nullable = true)
    private LocalDateTime fechaModificacion;

    public Integer getIdDetalleCronograma() {
        return idDetalleCronograma;
    }

    public void setIdDetalleCronograma(Integer idDetalleCronograma) {
        this.idDetalleCronograma = idDetalleCronograma;
    }

    public Cronograma getCronograma() {
        return cronograma;
    }

    public void setCronograma(Cronograma cronograma) {
        this.cronograma = cronograma;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Float getMontoSistema() {
        return montoSistema;
    }

    public void setMontoSistema(Float montoSistema) {
        this.montoSistema = montoSistema;
    }

    public Float getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(Float montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    public Float getMontoPagar() {
        return montoPagar;
    }

    public void setMontoPagar(Float montoPagar) {
        this.montoPagar = montoPagar;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
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
