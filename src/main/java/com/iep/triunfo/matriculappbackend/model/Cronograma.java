package com.iep.triunfo.matriculappbackend.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.iep.triunfo.matriculappbackend.util.Util.*;


@Schema(description = "Información del Cronograma")
@Entity
@Table(name = "cronograma")
public class Cronograma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCronograma;

    @OneToOne()
    @JoinColumn(name = "id_matricula", referencedColumnName = "idMatricula", foreignKey = @ForeignKey(name = "fk_cronograma_matricula"))
    private Matricula matricula;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @Column(name = "fecha_cronograma", nullable = true)
    private LocalDateTime fechaCronograma;

    @OneToMany(mappedBy = "cronograma", cascade = { CascadeType.ALL }, orphanRemoval = true)
    private List<DetalleCronograma> detalleCronograma;

    public void generarDetalleCronograma(Matricula matricula) {
        DetalleCronograma detalleCronogramaMatricula = new DetalleCronograma();
        DetalleCronograma detalleCronogramaPension = new DetalleCronograma();
        List<DetalleCronograma> listDetalleCronograma = new ArrayList<>();
        String periodo = null;
        ArrayList<String> meses = new ArrayList<String>();
        meses.add("03");
        meses.add("04");
        meses.add("05");
        meses.add("06");
        meses.add("07");
        meses.add("08");
        meses.add("09");
        meses.add("10");
        meses.add("11");
        meses.add("12");
        detalleCronogramaMatricula.setEstado(0);
        detalleCronogramaMatricula.setFechaRegistro(LocalDateTime.now());
        detalleCronogramaMatricula.setFechaModificacion(LocalDateTime.now());
        //Registrar en el cronograma la Matricula
        detalleCronogramaMatricula.setPeriodo(matricula.getProgramacionMatricula().getYear().concat("00"));
        detalleCronogramaMatricula.setMontoPagar(matricula.getProgramacionMatricula().getMontoMatricula());
        detalleCronogramaMatricula.setMontoDescuento(0.0F);
        detalleCronogramaMatricula.setMontoPagado(0.0F);
        detalleCronogramaMatricula.setMontoSistema(matricula.getProgramacionMatricula().getMontoMatricula());
        listDetalleCronograma.add(detalleCronogramaMatricula);
        //Registrar en el cronograma la mensualidad
        for (int i=0; i < meses.size(); i++){
            detalleCronogramaPension = new DetalleCronograma();
            periodo = matricula.getProgramacionMatricula().getYear().concat(meses.get(i));
            detalleCronogramaPension.setPeriodo(periodo);
            detalleCronogramaPension.setEstado(0);
            detalleCronogramaPension.setFechaRegistro(LocalDateTime.now());
            detalleCronogramaPension.setFechaModificacion(LocalDateTime.now());
            detalleCronogramaPension.setMontoDescuento(obtenerDescuentoMensualidad(matricula));
            detalleCronogramaPension.setMontoPagar(matricula.getProgramacionMatricula().getMontoMensualidad() - detalleCronogramaPension.getMontoDescuento());
            detalleCronogramaPension.setMontoPagado(0.0F);
            detalleCronogramaPension.setMontoSistema(matricula.getProgramacionMatricula().getMontoMensualidad());
            listDetalleCronograma.add(detalleCronogramaPension);
        }
        setDetalleCronograma(listDetalleCronograma);
    }

    public float obtenerDescuentoMensualidad(Matricula matricula){

        float descuento=0.0F;

        switch ( matricula.getAlumno().getTipoDescuento()){
            case TD_NINGUNO:{
                descuento = (float) (matricula.getProgramacionMatricula().getMontoMensualidad()*D_NINGUNO);
                break;
            }
            case TD_ALUMNO_DESTACADO:{
                descuento = (matricula.getProgramacionMatricula().getMontoMensualidad()*D_ALUMNO_DESTACADO);
                break;
            }
            case TD_FAMILIAR_ADMINISTRATIVO:{
                descuento = (matricula.getProgramacionMatricula().getMontoMensualidad()*D_FAMILIAR_ADMINISTRATIVO);
                break;
            }
            case TD_DEPORTISTA_CALIFICADO:{
                descuento = (matricula.getProgramacionMatricula().getMontoMensualidad()*D_DEPORTISTA_CALIFICADO);
                break;
            }
            case TD_MUSICO_CALIFICADO:{
                descuento = (matricula.getProgramacionMatricula().getMontoMensualidad()*D_MUSICO_CALIFICADO);
                break;
            }
        }//cierra SWITCH

        return descuento;
    }

    public Integer getIdCronograma() {
        return idCronograma;
    }

    public void setIdCronograma(Integer idCronograma) {
        this.idCronograma = idCronograma;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCronograma() {
        return fechaCronograma;
    }

    public void setFechaCronograma(LocalDateTime fechaCronograma) {
        this.fechaCronograma = fechaCronograma;
    }

    public List<DetalleCronograma> getDetalleCronograma() {
        return detalleCronograma;
    }

    public void setDetalleCronograma(List<DetalleCronograma> detalleCronograma) {
        this.detalleCronograma = detalleCronograma;
    }

}
