package com.iep.triunfo.matriculappbackend.service.impl;

import com.iep.triunfo.matriculappbackend.model.Alumno;
import com.iep.triunfo.matriculappbackend.repo.IAlumnoRepo;

import com.iep.triunfo.matriculappbackend.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

    @Autowired
    private IAlumnoRepo repo;

    @Override
    public Alumno registrar(Alumno obj) {
        return repo.save(obj);
    }

    @Override
    public Alumno modificar(Alumno obj) {
        return repo.save(obj);
    }

    @Override
    public List<Alumno> listar() {
        return repo.findAll();
    }

    @Override
    public Alumno listarPorId(Integer id) {
        Optional<Alumno> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Alumno();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }
}
