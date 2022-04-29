package com.iep.triunfo.matriculappbackend.repo;

import com.iep.triunfo.matriculappbackend.model.Alumno;
import com.iep.triunfo.matriculappbackend.model.Cronograma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IAlumnoRepo extends JpaRepository<Alumno, Integer> {

    @Query(value="select a.* from alumno a inner join matricula b on a.id_alumno = b.id_alumno where b.id_prog_matricula=:id", nativeQuery = true)
    List<Alumno> listarAlumnosPorProgramacion(@Param("id") Integer id);

    //JQPL
    @Query("FROM Alumno a WHERE a.idAlumno =:idAlumno " +
            "OR a.numDocumento =:numDocumento " +
            "OR LOWER(a.nombre) like %:nombre% " +
            "OR LOWER(a.apellidos) like %:apellidos% " +
            "OR a.tipoDescuento = :tipoDescuento")
    List<Alumno> filtrarAlumnos(@Param("idAlumno") Integer idAlumno,
                                @Param("numDocumento") String dni,
                                @Param("nombre") String nombre,
                                @Param("apellidos") String apellidos,
                                @Param("tipoDescuento") Integer tipoDescuento);

    //JQPL
    @Query("FROM Alumno a WHERE a.fechaNacimiento between :fechaNacimientoanetrior and :fechaNacimiento " +
            "OR a.fechaIngreso between :fechaIngresoAnterior and :fechaIngreso")
    List<Alumno> filtrarFechasAlumnos(@Param("fechaNacimientoanetrior") LocalDateTime fechaNacimientoAnterior,
                                      @Param("fechaNacimiento") LocalDateTime fechaNacimiento,
                                      @Param("fechaIngresoAnterior") LocalDateTime fechaIngresoAnterior,
                                      @Param("fechaIngreso") LocalDateTime fechaIngreso);

}
