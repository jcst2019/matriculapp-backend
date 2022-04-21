package com.iep.triunfo.matriculappbackend.service;
import com.iep.triunfo.matriculappbackend.model.Matricula;
import com.iep.triunfo.matriculappbackend.model.ProgramacionMatricula;

public interface IPorgramacionMatriculaService extends ICRUD<ProgramacionMatricula, Integer>{

    ProgramacionMatricula actualizarCantidadCupos(ProgramacionMatricula programacionMatricula);

    ProgramacionMatricula actualizarEstadoCerrado(ProgramacionMatricula programacionMatricula);
}

