package com.iep.triunfo.matriculappbackend.service;
import com.iep.triunfo.matriculappbackend.model.Matricula;

public interface IMatriculaService extends ICRUD<Matricula, Integer>{

    byte[] generarConstanciaMatricula(Integer id);
}

