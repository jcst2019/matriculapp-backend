package com.iep.triunfo.matriculappbackend.service.impl;

import com.iep.triunfo.matriculappbackend.model.Alumno;
import com.iep.triunfo.matriculappbackend.model.Pago;
import com.iep.triunfo.matriculappbackend.repo.IAlumnoRepo;
import com.iep.triunfo.matriculappbackend.repo.IPagoRepo;
import com.iep.triunfo.matriculappbackend.service.IAlumnoService;
import com.iep.triunfo.matriculappbackend.service.IPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImpl implements IPagoService {

    @Autowired
    private IPagoRepo repo;

    @Override
    public Pago registrar(Pago obj) {
        return repo.save(obj);
    }

    @Override
    public Pago modificar(Pago obj) {
        return repo.save(obj);
    }

    @Override
    public List<Pago> listar() {
        return repo.findAll();
    }

    @Override
    public Pago listarPorId(Integer id) {
        Optional<Pago> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Pago();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }
}
