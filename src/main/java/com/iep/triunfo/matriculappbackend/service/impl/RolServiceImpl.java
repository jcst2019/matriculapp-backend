package com.iep.triunfo.matriculappbackend.service.impl;

import com.iep.triunfo.matriculappbackend.dto.FiltroApoderadoDTO;
import com.iep.triunfo.matriculappbackend.model.Apoderado;
import com.iep.triunfo.matriculappbackend.model.Rol;
import com.iep.triunfo.matriculappbackend.repo.IApoderadoRepo;
import com.iep.triunfo.matriculappbackend.repo.IRolRepo;
import com.iep.triunfo.matriculappbackend.service.IApoderadoService;
import com.iep.triunfo.matriculappbackend.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements IRolService {

    @Autowired
    private IRolRepo repo;

    @Override
    public Rol registrar(Rol obj) {
        return repo.save(obj);
    }

    @Override
    public Rol modificar(Rol obj) {
        return repo.save(obj);
    }

    @Override
    public List<Rol> listar() {
        return repo.findAll();
    }

    @Override
    public Rol listarPorId(Integer id) {
        Optional<Rol> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Rol();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }

}

