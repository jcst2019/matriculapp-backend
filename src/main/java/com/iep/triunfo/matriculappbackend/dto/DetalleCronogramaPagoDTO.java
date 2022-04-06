package com.iep.triunfo.matriculappbackend.dto;

public class DetalleCronogramaPagoDTO {

    private Integer idDetalleCronograma;
    private double montoPorPagar;

    public Integer getIdDetalleCronograma() {
        return idDetalleCronograma;
    }

    public void setIdDetalleCronograma(Integer idDetalleCronograma) {
        this.idDetalleCronograma = idDetalleCronograma;
    }

    public double getMontoPorPagar() {
        return montoPorPagar;
    }

    public void setMontoPorPagar(double montoPorPagar) {
        this.montoPorPagar = montoPorPagar;
    }
}
