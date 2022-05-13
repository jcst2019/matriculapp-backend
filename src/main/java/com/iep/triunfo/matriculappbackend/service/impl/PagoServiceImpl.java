package com.iep.triunfo.matriculappbackend.service.impl;

import com.iep.triunfo.matriculappbackend.dto.ConsultaResumenPagoDTO;
import com.iep.triunfo.matriculappbackend.model.Alumno;
import com.iep.triunfo.matriculappbackend.model.Pago;
import com.iep.triunfo.matriculappbackend.repo.IAlumnoRepo;
import com.iep.triunfo.matriculappbackend.repo.IPagoRepo;
import com.iep.triunfo.matriculappbackend.service.IAlumnoService;
import com.iep.triunfo.matriculappbackend.service.IPagoService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImpl implements IPagoService {

    @Autowired
    private IPagoRepo repo;

    @Autowired
    ResourceLoader resourceLoader;

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

    @Override
    public List<ConsultaResumenPagoDTO> listarResumenPagos() {

        List<ConsultaResumenPagoDTO> consultas = new ArrayList<>();
        repo.listarResumenPagos().forEach(x->{
            ConsultaResumenPagoDTO cr = new ConsultaResumenPagoDTO();
            cr.setCantidad((Integer) x[0]);
            cr.setFecha(String.valueOf(x[1]));
            consultas.add(cr);
        });
        return consultas;
    }
    @Override
    public byte[] generarConstanciaPago(Integer id) {

        Resource resource = resourceLoader.getResource("classpath:ConstanciaPago.jasper");
        ClassLoader classLoader = getClass().getClassLoader();

        byte[] data = null;

        try {
            InputStream input =  classLoader.getResourceAsStream("ConstanciaPago.jasper");
            JasperPrint print = JasperFillManager.fillReport(input , null, new JRBeanCollectionDataSource(Collections.singleton(this.listarPorId(id))));

            data = JasperExportManager.exportReportToPdf(print);
        }catch(Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
