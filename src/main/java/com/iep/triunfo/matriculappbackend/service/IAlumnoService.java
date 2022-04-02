package com.iep.triunfo.matriculappbackend.service;

import com.iep.triunfo.matriculappbackend.model.Alumno;
import com.iep.triunfo.matriculappbackend.model.Cronograma;

import java.util.List;

public interface IAlumnoService extends ICRUD<Alumno, Integer>{

    List<Alumno> listarAlumnosPorProgramacion(Integer id);
}

