package com.iep.triunfo.matriculappbackend.service.impl;

import com.iep.triunfo.matriculappbackend.model.Cronograma;
import com.iep.triunfo.matriculappbackend.model.DetalleCronograma;
import com.iep.triunfo.matriculappbackend.model.Matricula;
import com.iep.triunfo.matriculappbackend.model.ProgramacionMatricula;
import com.iep.triunfo.matriculappbackend.repo.ICronogramaRepo;
import com.iep.triunfo.matriculappbackend.repo.IDetalleCronogramaRepo;
import com.iep.triunfo.matriculappbackend.service.ICronogramaService;
import com.iep.triunfo.matriculappbackend.service.IDetalleCronogramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleCronogramaServiceImpl implements IDetalleCronogramaService {

    @Autowired
    private IDetalleCronogramaRepo repo;


    @Override
    public DetalleCronograma registrar(DetalleCronograma obj) {
        return repo.save(obj);
    }

    @Override
    public DetalleCronograma modificar(DetalleCronograma obj) {
        return repo.save(obj);
    }

    @Override
    public List<DetalleCronograma> listar() {
        return repo.findAll();
    }

    @Override
    public DetalleCronograma listarPorId(Integer id) {
        Optional<DetalleCronograma> op = repo.findById(id);
        return op.isPresent() ? op.get() : new DetalleCronograma();
    }

    @Override
    public boolean eliminar(Integer id) {
        return false;
    }


    @Override
    public DetalleCronograma registrarMontoPagado(DetalleCronograma detalleCronograma, double montoPagado) {
        double montoPagadoAnterior,montoPagadoActualizado, deudaActualizada;
        if (montoPagado > 0){
            montoPagadoAnterior =  detalleCronograma.getMontoPagado();
            deudaActualizada =  detalleCronograma.getMontoPagar();
            if (deudaActualizada>=(montoPagado+montoPagadoAnterior)){
                montoPagadoActualizado = montoPagadoAnterior + montoPagado;
                detalleCronograma.setMontoPagado(montoPagadoActualizado);
                return repo.save(detalleCronograma);
            }
        }
        return new DetalleCronograma();
    }
}
