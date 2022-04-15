package com.iep.triunfo.matriculappbackend.dto;

public class ConsultaResumenPagoDTO {

    private Integer cantidad;
    private String fecha;

    public ConsultaResumenPagoDTO() {
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
