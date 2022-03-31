package com.iep.triunfo.matriculappbackend.repo;

import com.iep.triunfo.matriculappbackend.model.Cronograma;
import com.iep.triunfo.matriculappbackend.model.DetalleCronograma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICronogramaRepo extends JpaRepository<Cronograma, Integer> {

   // @Query(value="select * from cronograma a inner join detalle_cronograma b on a.id_cronograma = b.id_cronograma where a.id_matricula= :id", nativeQuery = true)
    @Query(value="select a.* from cronograma a  where a.id_matricula=:id", nativeQuery = true)

    Cronograma listarCronogramaPorMatricula(@Param("id") Integer id);


}
