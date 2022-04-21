package com.iep.triunfo.matriculappbackend.service.impl;

import com.iep.triunfo.matriculappbackend.model.Alumno;
import com.iep.triunfo.matriculappbackend.model.Cronograma;
import com.iep.triunfo.matriculappbackend.model.Matricula;
import com.iep.triunfo.matriculappbackend.model.ProgramacionMatricula;
import com.iep.triunfo.matriculappbackend.repo.IAlumnoRepo;
import com.iep.triunfo.matriculappbackend.repo.ICronogramaRepo;
import com.iep.triunfo.matriculappbackend.repo.IMatriculaRepo;
import com.iep.triunfo.matriculappbackend.service.IAlumnoService;
import com.iep.triunfo.matriculappbackend.service.IMatriculaService;
import com.iep.triunfo.matriculappbackend.util.Util;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.*;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private IMatriculaRepo repo;

    @Autowired
    private ICronogramaRepo repoCronograma;

    //@Value("classpath:/constancia.jasper") // Do not use field injection
    //private Resource resource;

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    ServletContext servletContext;

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
/*
    @Override
    public byte[] generarConstanciaMatricula(Integer id) {

        Resource resource = resourceLoader.getResource("classpath:constancia.jasper");
        ClassLoader classLoader = getClass().getClassLoader();

        byte[] data = null;

        try {
            //File file = new ClassPathResource("/reports/constancia.jasper").getFile();//Funciona Pero en el despliegue NO. No encuentra la ruta de la carpeta resource
            //JasperPrint print = JasperFillManager.fillReport(file.getPath(), null, new JRBeanCollectionDataSource(Collections.singleton(this.listarPorId(id))));
            //InputStream input = resource.getInputStream();
            //InputStream input =  classLoader.getResourceAsStream("classpath:constancia.jasper")
            //readFromInputStream(input);
            //reader = new BufferedReader(new InputStreamReader(input));
            //byte[] buffer = new byte[input.available()];
            //input.read(buffer);
            //File file = resource.getFile();
            File file = new File(classLoader.getResource("constancia.jasper").getFile());
            //JasperPrint print = JasperFillManager.fillReport(file.getPath(), null, new JRBeanCollectionDataSource(Collections.singleton(this.listarPorId(id))));
            JasperPrint print = JasperFillManager.fillReport(file.getPath() , null, new JRBeanCollectionDataSource(Collections.singleton(this.listarPorId(id))));

            data = JasperExportManager.exportReportToPdf(print);
        }catch(Exception e) {
            e.printStackTrace();
        }

        return data;
    }
    */
    /*
    @Override
    public byte[] generarConstanciaMatricula(Integer id) {

        //URL resource = getClass().getResource("constancia.jasper");}
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("constancia.jasper");
        final String JASPER_DIRETORIO = resource.getFile();
        JasperPrint jasperPrint = null;
        byte[] data = null;
        try {
            jasperPrint = JasperFillManager.fillReport(JASPER_DIRETORIO, null, new JRBeanCollectionDataSource(Collections.singleton(this.listarPorId(id))));
            data = JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }*/
 /*
    @Override
    public byte[] generarConstanciaMatricula(Integer id) {

        String path = servletContext.getRealPath("reports");

        //ClassLoader classLoader = getClass().getClassLoader();
        //URL resource = classLoader.getResource("constancia.jasper");
        //final String JASPER_DIRETORIO = resource.getFile();
        JasperPrint jasperPrint = null;
        byte[] data = null;
        try {
            //jasperPrint = JasperFillManager.fillReport(JASPER_DIRETORIO, null, new JRBeanCollectionDataSource(Collections.singleton(this.listarPorId(id))));
            jasperPrint = JasperFillManager.fillReport(servletContext.getRealPath("constancia.jasper"), null, new JRBeanCollectionDataSource(Collections.singleton(this.listarPorId(id))));
            data = JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }*/

    //Después de sufrir como 1 día se pudo visualizar el PDF desde HEROKU
    @Override
    public byte[] generarConstanciaMatricula(Integer id) {

        Resource resource = resourceLoader.getResource("classpath:constancia.jasper");
        ClassLoader classLoader = getClass().getClassLoader();

        byte[] data = null;

        try {
            //File file = new ClassPathResource("/reports/constancia.jasper").getFile();//Funciona Pero en el despliegue NO. No encuentra la ruta de la carpeta resource
            //JasperPrint print = JasperFillManager.fillReport(file.getPath(), null, new JRBeanCollectionDataSource(Collections.singleton(this.listarPorId(id))));
            //InputStream input = resource.getInputStream();
            InputStream input =  classLoader.getResourceAsStream("constancia.jasper");
            //readFromInputStream(input);
            //reader = new BufferedReader(new InputStreamReader(input));
            //byte[] buffer = new byte[input.available()];
            //input.read(buffer);
            //File file = resource.getFile();
            //File file = new File(classLoader.getResource("constancia.jasper").getFile());
            //JasperPrint print = JasperFillManager.fillReport(file.getPath(), null, new JRBeanCollectionDataSource(Collections.singleton(this.listarPorId(id))));
            JasperPrint print = JasperFillManager.fillReport(input , null, new JRBeanCollectionDataSource(Collections.singleton(this.listarPorId(id))));

            data = JasperExportManager.exportReportToPdf(print);
        }catch(Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    @Override
    public Matricula actualizarEstadoAnulado(Matricula matricula) {
        //Anulamos el cronograma
        Cronograma cronograma = repoCronograma.listarCronogramaPorMatricula(matricula.getIdMatricula());
        cronograma.setEstado(Util.ESTADO_CRONOGRAMA_ANULADO);
        repoCronograma.save(cronograma);
        //Anulamos la matrícula
        Matricula obj = listarPorId(matricula.getIdMatricula());
        obj.setEstado(Util.ESTADO_MATRICULA_ANULADO);



        return repo.save(obj);
    }

    public void copyToFile(InputStream inputStream, File file) throws IOException {
        try(OutputStream outputStream = new FileOutputStream(file)) {
            IOUtils.copy(inputStream, outputStream);
        }
    }

}
