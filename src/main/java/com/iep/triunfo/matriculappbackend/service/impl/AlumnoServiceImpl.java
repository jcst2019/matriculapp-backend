package com.iep.triunfo.matriculappbackend.service.impl;

import com.iep.triunfo.matriculappbackend.dto.FiltroAlumnoDTO;
import com.iep.triunfo.matriculappbackend.model.Alumno;
import com.iep.triunfo.matriculappbackend.repo.IAlumnoRepo;

import com.iep.triunfo.matriculappbackend.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    @Override
    public List<Alumno> listarAlumnosPorProgramacion(Integer id) {
        return repo.listarAlumnosPorProgramacion(id);
    }

    @Override
    public List<Alumno> filtrarAlumnos(FiltroAlumnoDTO filtro) {
        return repo.filtrarAlumnos( filtro.getIdAlumno(),filtro.getNumDocumento(),filtro.getNombre(),filtro.getApellidos(),filtro.getTipoDescuento());
    }

    @Override
    public List<Alumno> filtrarFechasAlumnos(FiltroAlumnoDTO filtro) {

        LocalDateTime fechaNacimientoAnterior = null,fechaIngresoAnterior = null;

        if (filtro.getFechaNacimiento()!= null){
            fechaNacimientoAnterior = filtro.getFechaNacimiento().minusDays(1); //Debería de ser solo 1 día
        }
        if (filtro.getFechaIngreso()!= null){
            fechaIngresoAnterior = filtro.getFechaIngreso().minusDays(1);//Debería de ser solo 1 día
        }
        return repo.filtrarFechasAlumnos(fechaNacimientoAnterior,filtro.getFechaNacimiento(),fechaIngresoAnterior,filtro.getFechaIngreso());
    }

}
