package com.iep.triunfo.matriculappbackend.repo;

import com.iep.triunfo.matriculappbackend.model.Menu;
import com.iep.triunfo.matriculappbackend.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPagoRepo extends JpaRepository<Pago, Integer> {
    //Reporte de Pago Rusumen
    @Query(value="select * from fn_listarResumenPagos()", nativeQuery = true)
    List<Object[]> listarResumenPagos();

}
