package com.iep.triunfo.matriculappbackend.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Información de los Pagos")
@Entity
@Table(name = "pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPago;

    @Schema(description = "Descripcion debe de Tener mínimo 200 caracteres")
    @Size(min = 1, message = "Descripcion debe de Tener mínimo 1 caracteres")
    @Column(name="descripcion", nullable = false, length = 200)
    private String descripcion;

     //1 = Pago Matricula  2 = Pago Mensualidad 3= Otros
    @Column(name = "concepto", nullable = false)
    private Integer concepto;

    @Column(name = "id_detalle_cronograma", nullable = false)
    private Long idDetalleCronograma;

    @Column(name = "mto_pago", nullable = true)
    private Float mtoPago;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @Column(name = "fecha_pago", nullable = true)
    private LocalDateTime fechaPago;

    @Column(name = "fecha_registro", nullable = true)
    private LocalDateTime fechaRegistro;

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getConcepto() {
        return concepto;
    }

    public void setConcepto(Integer concepto) {
        this.concepto = concepto;
    }

    public Long getIdDetalleCronograma() {
        return idDetalleCronograma;
    }

    public void setIdDetalleCronograma(Long idDetalleCronograma) {
        this.idDetalleCronograma = idDetalleCronograma;
    }

    public Float getMtoPago() {
        return mtoPago;
    }

    public void setMtoPago(Float mtoPago) {
        this.mtoPago = mtoPago;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
