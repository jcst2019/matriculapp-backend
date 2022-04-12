package com.iep.triunfo.matriculappbackend.controller;

import com.iep.triunfo.matriculappbackend.exception.ModeloNotFoundException;
import com.iep.triunfo.matriculappbackend.model.Alumno;
import com.iep.triunfo.matriculappbackend.model.Cronograma;
import com.iep.triunfo.matriculappbackend.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@RestController
@RequestMapping("api/alumnos")
public class AlumnoController {

	@Autowired
	private IAlumnoService service;

	@GetMapping("/listar")
	public ResponseEntity<List<Alumno>> listar() {

		List<Alumno> lista = service.listar();
		return new ResponseEntity<List<Alumno>>(lista, HttpStatus.OK);
	}

	@GetMapping("/listar/{id}")
	public ResponseEntity<Alumno> listarPorId(@PathVariable("id") Integer id) {

		Alumno p = service.listarPorId(id);
		if (p.getIdAlumno() == null) {

			throw new ModeloNotFoundException("Id No encontrado " + id);

		}
		return new ResponseEntity<Alumno>(p, HttpStatus.OK);

	}

	@GetMapping("/listar/programacion/{id}")
	public ResponseEntity<List<Alumno>> listarPorProgramacion(@PathVariable("id") Integer id) throws Exception{
		//List<Cronograma> cronograma = new ArrayList<>();
		//cronograma = service.listarCronogramaPorMatricula(id);
		List<Alumno> alumnos= service.listarAlumnosPorProgramacion(id);
		return new ResponseEntity<List<Alumno>>(alumnos, HttpStatus.OK);
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
	public ResponseEntity<Object> registrar(@Valid @RequestBody Alumno alumno) {

		Alumno p = service.registrar(alumno);
		// return new ResponseEntity<Paciente>(p, HttpStatus.CREATED);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdAlumno())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/modificar")
	public ResponseEntity<Alumno> modificar(@Valid @RequestBody Alumno alumno) {

		Alumno p = service.registrar(alumno);
		return new ResponseEntity<Alumno>(p, HttpStatus.CREATED);

	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {

		Alumno p = service.listarPorId(id);

		if (p.getIdAlumno() == null) {

			throw new ModeloNotFoundException("Id No encontrado " + id);

		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
