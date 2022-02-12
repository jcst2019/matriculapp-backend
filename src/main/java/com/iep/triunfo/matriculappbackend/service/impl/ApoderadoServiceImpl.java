package com.iep.triunfo.matriculappbackend.service.impl;

import com.iep.triunfo.matriculappbackend.model.Apoderado;
import com.iep.triunfo.matriculappbackend.repo.IApoderadoRepo;
import com.iep.triunfo.matriculappbackend.service.IApoderadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApoderadoServiceImpl implements IApoderadoService {

    @Autowired
    private IApoderadoRepo repo;

    @Override
    public Apoderado registrar(Apoderado obj) {
        return repo.save(obj);
    }

    @Override
    public Apoderado modificar(Apoderado obj) {
        return repo.save(obj);
    }

    @Override
    public List<Apoderado> listar() {
        return repo.findAll();
    }

    @Override
    public Apoderado listarPorId(Integer id) {
        Optional<Apoderado> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Apoderado();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }
}

