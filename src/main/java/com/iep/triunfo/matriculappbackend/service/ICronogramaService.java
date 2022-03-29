package com.iep.triunfo.matriculappbackend.service;

import com.iep.triunfo.matriculappbackend.model.Cronograma;
import com.iep.triunfo.matriculappbackend.model.Matricula;
import com.iep.triunfo.matriculappbackend.service.ICRUD;

import java.util.List;

public interface ICronogramaService extends ICRUD<Cronograma, Integer> {

    Float obtenerMontoDescuento(Matricula matricula);

}

