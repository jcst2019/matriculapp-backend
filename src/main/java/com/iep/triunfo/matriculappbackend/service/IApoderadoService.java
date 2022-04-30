package com.iep.triunfo.matriculappbackend.service;

import com.iep.triunfo.matriculappbackend.dto.FiltroAlumnoDTO;
import com.iep.triunfo.matriculappbackend.dto.FiltroApoderadoDTO;
import com.iep.triunfo.matriculappbackend.model.Alumno;
import com.iep.triunfo.matriculappbackend.model.Apoderado;

import java.util.List;

public interface IApoderadoService extends ICRUD<Apoderado, Integer>{

    List<Apoderado> filtrarApoderado(FiltroApoderadoDTO filtro);
    List<Apoderado> filtrarFechasApoderado(FiltroApoderadoDTO filtro);
}

