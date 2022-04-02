package com.iep.triunfo.matriculappbackend.service.impl;

import com.iep.triunfo.matriculappbackend.model.Alumno;
import com.iep.triunfo.matriculappbackend.model.Matricula;
import com.iep.triunfo.matriculappbackend.repo.IAlumnoRepo;
import com.iep.triunfo.matriculappbackend.repo.IMatriculaRepo;
import com.iep.triunfo.matriculappbackend.service.IAlumnoService;
import com.iep.triunfo.matriculappbackend.service.IMatriculaService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private IMatriculaRepo repo;

    @Value("classpath:/constancia.jasper") // Do not use field injection
    private Resource resource;

    //@Autowired
    //ResourceLoader resourceLoader;

    @Override
    public Matricula registrar(Matricula obj) {
            return repo.save(obj);
    }

    @Override
    public Matricula modificar(Matricula obj) {
            return repo.save(obj);
    }

    @Override
    public List<Matricula> listar() {
        return repo.findAll();
    }

    @Override
    public Matricula listarPorId(Integer id) {
        Optional<Matricula> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Matricula();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public byte[] generarConstanciaMatricula(Integer id) {

        //Resource resource = resourceLoader.getResource("classpath:constancia.jasper");

        byte[] data = null;

        try {
            //File file = new ClassPathResource("/reports/constancia.jasper").getFile();//Funciona Pero en el despliegue NO. No encuentra la ruta de la carpeta resource
            //JasperPrint print = JasperFillManager.fillReport(file.getPath(), null, new JRBeanCollectionDataSource(Collections.singleton(this.listarPorId(id))));
            File file = resource.getFile();
            JasperPrint print = JasperFillManager.fillReport(file.getPath(), null, new JRBeanCollectionDataSource(Collections.singleton(this.listarPorId(id))));
            data = JasperExportManager.exportReportToPdf(print);
        }catch(Exception e) {
            e.printStackTrace();
        }

        return data;
    }

}
