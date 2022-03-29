package com.iep.triunfo.matriculappbackend.controller;

import com.iep.triunfo.matriculappbackend.exception.ModeloNotFoundException;
import com.iep.triunfo.matriculappbackend.model.Matricula;
import com.iep.triunfo.matriculappbackend.model.ProgramacionMatricula;
import com.iep.triunfo.matriculappbackend.service.IMatriculaService;
import com.iep.triunfo.matriculappbackend.service.IPorgramacionMatriculaService;
import com.iep.triunfo.matriculappbackend.util.DatoRetorno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/programacion/matriculas")
public class ProgramacionMatriculaController {

	@Autowired
	private IPorgramacionMatriculaService service;

	@PostMapping("/actualizarcantidadcupos/{id}")
	public ResponseEntity<ProgramacionMatricula> actualizarCantidadCupos(@PathVariable("id") Integer id) {

		ProgramacionMatricula p = service.listarPorId(id);
		ProgramacionMatricula progActualizado;
		if (p.getIdProgMatricula()== null) {
			throw new ModeloNotFoundException("Id No encontrado " + id);
		}else{
			 progActualizado = service.actualizarCantidadCupos(p);
		}
		return new ResponseEntity<ProgramacionMatricula>(progActualizado, HttpStatus.OK);
	}

	@GetMapping("/listar")
	public ResponseEntity<List<ProgramacionMatricula>> listar() {

		List<ProgramacionMatricula> lista = service.listar();
		return new ResponseEntity<List<ProgramacionMatricula>>(lista, HttpStatus.OK);
	}

	@GetMapping("/listar/{id}")
	public ResponseEntity<ProgramacionMatricula> listarPorId(@PathVariable("id") Integer id) {

		ProgramacionMatricula p = service.listarPorId(id);
		if (p.getIdProgMatricula()== null) {

			throw new ModeloNotFoundException("Id No encontrado " + id);

		}
		return new ResponseEntity<ProgramacionMatricula>(p, HttpStatus.OK);

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
	public ResponseEntity<Object> registrar(@Valid @RequestBody ProgramacionMatricula programacion) {

		ProgramacionMatricula p = service.registrar(programacion);
		// return new ResponseEntity<Paciente>(p, HttpStatus.CREATED);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdProgMatricula())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/modificar")
	public ResponseEntity<ProgramacionMatricula> modificar(@Valid @RequestBody ProgramacionMatricula programacion) {

		ProgramacionMatricula p = service.registrar(programacion);
		return new ResponseEntity<ProgramacionMatricula>(p, HttpStatus.CREATED);

	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {

		ProgramacionMatricula p = service.listarPorId(id);

		if (p.getIdProgMatricula() == null) {

			throw new ModeloNotFoundException("Id No encontrado " + id);

		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
