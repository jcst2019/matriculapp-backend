package com.iep.triunfo.matriculappbackend.controller;

import com.iep.triunfo.matriculappbackend.exception.ModeloNotFoundException;
import com.iep.triunfo.matriculappbackend.model.Alumno;
import com.iep.triunfo.matriculappbackend.model.Cronograma;
import com.iep.triunfo.matriculappbackend.model.Matricula;
import com.iep.triunfo.matriculappbackend.model.ProgramacionMatricula;
import com.iep.triunfo.matriculappbackend.repo.IProgramacionMatriculaRepo;
import com.iep.triunfo.matriculappbackend.service.IAlumnoService;
import com.iep.triunfo.matriculappbackend.service.ICronogramaService;
import com.iep.triunfo.matriculappbackend.service.IMatriculaService;
import com.iep.triunfo.matriculappbackend.service.IPorgramacionMatriculaService;
import com.iep.triunfo.matriculappbackend.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("api/matriculas")
public class MatriculaController {

	@Autowired
	private IMatriculaService service;
	@Autowired
	private ICronogramaService serviceCronograma;
	@Autowired
	private IPorgramacionMatriculaService serviceProgramacionMatricula;

	@GetMapping("/listar")
	public ResponseEntity<List<Matricula>> listar() {

		List<Matricula> lista = service.listar();
		return new ResponseEntity<List<Matricula>>(lista, HttpStatus.OK);
	}


	@GetMapping("/listar/{id}")
	public ResponseEntity<Matricula> listarPorId(@PathVariable("id") Integer id) {

		Matricula p = service.listarPorId(id);
		if (p.getIdMatricula()== null) {

			throw new ModeloNotFoundException("Id No encontrado " + id);

		}
		return new ResponseEntity<Matricula>(p, HttpStatus.OK);

	}
	/*
	@GetMapping("/hateos/listar/{id}")
	public EntityModel<Alumno> listarPorIdHateoas(@PathVariable("id") Integer id) {

		Alumno p = service.listarPorId(id);

		EntityModel<Alumno> recurso = new EntityModel<Alumno>(p);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		recurso.add(linkTo.withRel("paciente-recurso"));
	}
   */
	/*
	 * @PostMapping public ResponseEntity<Paciente> registrar(@Valid @RequestBody
	 * Paciente paciente) {
	 * 
	 * Paciente p = service.registrar(paciente); return new
	 * ResponseEntity<Paciente>(p, HttpStatus.CREATED);
	 * 
	 * }
	 */

	@PostMapping("/registrar")
	public ResponseEntity<Object> registrar(@Valid @RequestBody Matricula matricula) {
        Cronograma cronograma = new Cronograma();
        //Registramos la Matr??cula
		Matricula p = service.registrar(matricula);
        //Registramos el Cronograma
		cronograma.setMatricula(p);
		cronograma.setEstado(Util.ESTADO_CRONOGRAMA_REGISTRADO);
		cronograma.setFechaCronograma(LocalDateTime.now());
		cronograma.generarDetalleCronograma(matricula);
		Cronograma c = serviceCronograma.registrar(cronograma);
		//Actualizamos la cantidad de Cupos Matriculados
		ProgramacionMatricula progActualizado1 = serviceProgramacionMatricula.listarPorId(matricula.getProgramacionMatricula().getIdProgMatricula());
		progActualizado1 = serviceProgramacionMatricula.actualizarCantidadCupos(progActualizado1);
		//Actualizamos el estado Cerrado si llenamos los cupos
		ProgramacionMatricula progActualizado2 = serviceProgramacionMatricula.listarPorId(matricula.getProgramacionMatricula().getIdProgMatricula());
		progActualizado2 = serviceProgramacionMatricula.actualizarEstadoCerrado(progActualizado2);
		// return new ResponseEntity<Paciente>(p, HttpStatus.CREATED);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdMatricula())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/modificar")
	public ResponseEntity<Matricula> modificar(@Valid @RequestBody Matricula matricula) {

		Matricula p = service.registrar(matricula);
		return new ResponseEntity<Matricula>(p, HttpStatus.CREATED);

	}

	@GetMapping("/actualizaEstadoAnulado/{id}")
	public ResponseEntity<Matricula> actualizaEstadoAnulado(@PathVariable("id") Integer id) {

		Matricula p = service.listarPorId(id);

		if (p.getIdMatricula() == null) {

			throw new ModeloNotFoundException("Id No encontrado " + id);

		}
		service.actualizarEstadoAnulado(p);

		return new ResponseEntity<Matricula>(HttpStatus.CREATED);
	}

	@GetMapping(value = "/generarConstanciaMatricula/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> generarConstanciaMatricula(@PathVariable("id") Integer id) {
		byte[] data = null;
		data = service.generarConstanciaMatricula(id);
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {

		Matricula p = service.listarPorId(id);

		if (p.getIdMatricula() == null) {

			throw new ModeloNotFoundException("Id No encontrado " + id);

		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
