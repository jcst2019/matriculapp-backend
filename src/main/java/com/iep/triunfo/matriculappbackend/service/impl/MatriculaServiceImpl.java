package com.iep.triunfo.matriculappbackend.service.impl;

import com.iep.triunfo.matriculappbackend.model.Alumno;
import com.iep.triunfo.matriculappbackend.model.Matricula;
import com.iep.triunfo.matriculappbackend.repo.IAlumnoRepo;
import com.iep.triunfo.matriculappbackend.repo.IMatriculaRepo;
import com.iep.triunfo.matriculappbackend.service.IAlumnoService;
import com.iep.triunfo.matriculappbackend.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private IMatriculaRepo repo;


    @Override
    public Matricula registrar(Matricula obj) {
            return repo.save(obj);
    }

    @Override
    public Matricula modificar(Matricula obj) {
            return repo.save(obj);
    }

    @Override
    public List<Matricula> listar() {
        return repo.findAll();
    }

    @Override
    public Matricula listarPorId(Integer id) {
        Optional<Matricula> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Matricula();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }
}
