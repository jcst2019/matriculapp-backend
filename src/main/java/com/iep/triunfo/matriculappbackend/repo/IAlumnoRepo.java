package com.iep.triunfo.matriculappbackend.repo;

import com.iep.triunfo.matriculappbackend.model.Alumno;
import com.iep.triunfo.matriculappbackend.model.Cronograma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAlumnoRepo extends JpaRepository<Alumno, Integer> {

    @Query(value="select a.* from alumno a inner join matricula b on a.id_alumno = b.id_alumno where b.id_prog_matricula=:id", nativeQuery = true)
    List<Alumno> listarAlumnosPorProgramacion(@Param("id") Integer id);

}
