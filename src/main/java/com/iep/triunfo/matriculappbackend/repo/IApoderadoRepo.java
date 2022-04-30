package com.iep.triunfo.matriculappbackend.repo;

import com.iep.triunfo.matriculappbackend.model.Alumno;
import com.iep.triunfo.matriculappbackend.model.Apoderado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IApoderadoRepo extends JpaRepository<Apoderado, Integer> {

    //JQPL
    @Query("FROM Apoderado a WHERE a.idApoderado =:idApoderado " +
            "OR a.numDocumento =:numDocumento " +
            "OR LOWER(a.nombre) like %:nombre% " +
            "OR LOWER(a.apellidos) like %:apellidos% " +
            "OR a.telefono = :telefono")
    List<Apoderado> filtrarApoderados(@Param("idApoderado") Integer idApoderado,
                                   @Param("numDocumento") String dni,
                                   @Param("nombre") String nombre,
                                   @Param("apellidos") String apellidos,
                                   @Param("telefono") String telefono);

    //JQPL
    @Query("FROM Apoderado a WHERE a.fechaNacimiento between :fechaNacimientoanetrior and :fechaNacimiento " +
            "OR a.fechaRegistro between :fechaRegistroAnterior and :fechaRegistro")
    List<Apoderado> filtrarFechasApoderados(@Param("fechaNacimientoanetrior") LocalDateTime fechaNacimientoAnterior,
                                         @Param("fechaNacimiento") LocalDateTime fechaNacimiento,
                                         @Param("fechaRegistroAnterior") LocalDateTime fechaRegistroAnterior,
                                         @Param("fechaRegistro") LocalDateTime fechaRegistro);

}
