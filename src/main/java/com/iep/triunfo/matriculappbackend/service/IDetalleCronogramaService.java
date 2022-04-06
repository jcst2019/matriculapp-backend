package com.iep.triunfo.matriculappbackend.service;

import com.iep.triunfo.matriculappbackend.model.Cronograma;
import com.iep.triunfo.matriculappbackend.model.DetalleCronograma;
import com.iep.triunfo.matriculappbackend.model.Matricula;
import com.iep.triunfo.matriculappbackend.model.ProgramacionMatricula;

import java.util.List;

public interface IDetalleCronogramaService extends ICRUD<DetalleCronograma, Integer> {

    DetalleCronograma registrarMontoPagado(DetalleCronograma detalleCronograma, double montoPagado);

}

