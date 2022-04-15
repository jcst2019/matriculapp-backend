package com.iep.triunfo.matriculappbackend.service;

import com.iep.triunfo.matriculappbackend.dto.ConsultaResumenPagoDTO;
import com.iep.triunfo.matriculappbackend.model.Pago;

import java.util.List;

public interface IPagoService extends ICRUD<Pago, Integer>{

    List<ConsultaResumenPagoDTO> listarResumenPagos();
}

