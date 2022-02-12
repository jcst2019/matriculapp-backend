package com.iep.triunfo.matriculappbackend.service.impl;

import com.iep.triunfo.matriculappbackend.model.Alumno;
import com.iep.triunfo.matriculappbackend.model.Cronograma;
import com.iep.triunfo.matriculappbackend.repo.IAlumnoRepo;
import com.iep.triunfo.matriculappbackend.repo.ICronogramaRepo;
import com.iep.triunfo.matriculappbackend.service.IAlumnoService;
import com.iep.triunfo.matriculappbackend.service.ICronogramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CronogramaServiceImpl implements ICronogramaService {

    @Autowired
    private ICronogramaRepo repo;

    @Override
    public Cronograma registrar(Cronograma obj) {
        return repo.save(obj);
    }

    @Override
    public Cronograma modificar(Cronograma obj) {
        return repo.save(obj);
    }

    @Override
    public List<Cronograma> listar() {
        return repo.findAll();
    }

    @Override
    public Cronograma listarPorId(Integer id) {
        Optional<Cronograma> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Cronograma();
    }

    @Override
    public boolean eliminar(Integer id) {
        return false;
    }
}
