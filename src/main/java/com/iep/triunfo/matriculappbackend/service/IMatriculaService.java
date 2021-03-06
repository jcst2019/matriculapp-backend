package com.iep.triunfo.matriculappbackend.service;
import com.iep.triunfo.matriculappbackend.model.Matricula;
import com.iep.triunfo.matriculappbackend.model.ProgramacionMatricula;

public interface IMatriculaService extends ICRUD<Matricula, Integer>{

    byte[] generarConstanciaMatricula(Integer id);

    Matricula actualizarEstadoAnulado(Matricula matricula);
}

