package com.iep.triunfo.matriculappbackend.controller;

import com.iep.triunfo.matriculappbackend.dto.FiltroApoderadoDTO;
import com.iep.triunfo.matriculappbackend.exception.ModeloNotFoundException;
import com.iep.triunfo.matriculappbackend.model.Apoderado;
import com.iep.triunfo.matriculappbackend.model.Rol;
import com.iep.triunfo.matriculappbackend.service.IApoderadoService;
import com.iep.triunfo.matriculappbackend.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/roles")
public class RolController {

	@Autowired
	private IRolService service;

	@GetMapping("/listar")
	public ResponseEntity<List<Rol>> listar() {

		List<Rol> lista = service.listar();
		return new ResponseEntity<List<Rol>>(lista, HttpStatus.OK);
	}

	@GetMapping("/listar/{id}")
	public ResponseEntity<Rol> listarPorId(@PathVariable("id") Integer id) {

		Rol p = service.listarPorId(id);
		if (p.getIdRol() == null) {

			throw new ModeloNotFoundException("Id No encontrado " + id);

		}
		return new ResponseEntity<Rol>(p, HttpStatus.OK);

	}

	@PostMapping("/registrar")
	public ResponseEntity<Object> registrar(@Valid @RequestBody Rol rol) {

		Rol p = service.registrar(rol);
		// return new ResponseEntity<Paciente>(p, HttpStatus.CREATED);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdRol())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/modificar")
	public ResponseEntity<Rol> modificar(@Valid @RequestBody Rol rol) {

		Rol p = service.registrar(rol);
		return new ResponseEntity<Rol>(p, HttpStatus.CREATED);

	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {

		Rol p = service.listarPorId(id);

		if (p.getIdRol()== null) {

			throw new ModeloNotFoundException("Id No encontrado " + id);

		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
