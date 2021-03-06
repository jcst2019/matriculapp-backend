package com.iep.triunfo.matriculappbackend.service.impl;

import com.iep.triunfo.matriculappbackend.model.Cronograma;
import com.iep.triunfo.matriculappbackend.model.Matricula;
import com.iep.triunfo.matriculappbackend.model.ProgramacionMatricula;
import com.iep.triunfo.matriculappbackend.repo.IMatriculaRepo;
import com.iep.triunfo.matriculappbackend.repo.IProgramacionMatriculaRepo;
import com.iep.triunfo.matriculappbackend.service.IMatriculaService;
import com.iep.triunfo.matriculappbackend.service.IPorgramacionMatriculaService;
import com.iep.triunfo.matriculappbackend.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramacionMatriculaServiceImpl implements IPorgramacionMatriculaService {

    @Autowired
    private IProgramacionMatriculaRepo repo;

    @Override
    public ProgramacionMatricula actualizarCantidadCupos(ProgramacionMatricula programacionMatricula) {
        int cantidadCupos,cantidadCuposTotal;
        cantidadCuposTotal =  programacionMatricula.getCantidadCuposTotal();
        cantidadCupos = programacionMatricula.getCantidadCuposRegistrados();
        if (cantidadCuposTotal>=cantidadCupos){
            programacionMatricula.setCantidadCuposRegistrados(cantidadCupos + 1);
            return repo.save(programacionMatricula);
        }
        return new ProgramacionMatricula();
    }

    @Override
    public ProgramacionMatricula actualizarEstadoCerrado(ProgramacionMatricula programacionMatricula) {
        int cantidadCupos,cantidadCuposTotal;
        cantidadCuposTotal =  programacionMatricula.getCantidadCuposTotal();
        cantidadCupos = programacionMatricula.getCantidadCuposRegistrados();
        if (cantidadCuposTotal==cantidadCupos){
            programacionMatricula.setEstado(Util.ESTADO_PROG_ACADEMICA_CERRADO);
            return repo.save(programacionMatricula);
        }
        return new ProgramacionMatricula();
    }

    @Override
    public ProgramacionMatricula registrar(ProgramacionMatricula obj) {
        return repo.save(obj);
    }

    @Override
    public ProgramacionMatricula modificar(ProgramacionMatricula obj) {
        return repo.save(obj);

    }

    @Override
    public List<ProgramacionMatricula> listar() {
        return repo.findAll();
    }

    @Override
    public ProgramacionMatricula listarPorId(Integer id) {
        Optional<ProgramacionMatricula> op = repo.findById(id);
        return op.isPresent() ? op.get() : new ProgramacionMatricula();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }

}
