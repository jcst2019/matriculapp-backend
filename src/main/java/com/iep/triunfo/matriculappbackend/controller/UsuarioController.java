package com.iep.triunfo.matriculappbackend.controller;

import com.iep.triunfo.matriculappbackend.exception.ModeloNotFoundException;
import com.iep.triunfo.matriculappbackend.model.Menu;
import com.iep.triunfo.matriculappbackend.model.Rol;
import com.iep.triunfo.matriculappbackend.model.Usuario;
import com.iep.triunfo.matriculappbackend.repo.IUsuarioRepo;
import com.iep.triunfo.matriculappbackend.service.IMenuService;
import com.iep.triunfo.matriculappbackend.service.IRolService;
import com.iep.triunfo.matriculappbackend.service.IUsuarioService;
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
@RequestMapping("api/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUsuarioRepo repo; //Debería de ser un Service

	@Autowired
	private IUsuarioService service;

	@GetMapping("/listarPorUsername/{username}")
	public ResponseEntity<Usuario> listarPorUsername(@PathVariable("username") String username) throws Exception{
		Usuario usuario = new Usuario();
		usuario = repo.findOneByUsername(username);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Usuario>> listar() {

		List<Usuario> lista = service.listar();
		return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
	}

	@GetMapping("/listar/{id}")
	public ResponseEntity<Usuario> listarPorId(@PathVariable("id") Integer id) {

		Usuario p = service.listarPorId(id);
		if (p.getIdUsuario() == null) {

			throw new ModeloNotFoundException("Id No encontrado " + id);

		}
		return new ResponseEntity<Usuario>(p, HttpStatus.OK);

	}

	@PostMapping("/registrar")
	public ResponseEntity<Object> registrar(@Valid @RequestBody Usuario usuario) {

		Usuario p = service.registrar(usuario);
		// return new ResponseEntity<Paciente>(p, HttpStatus.CREATED);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdUsuario())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/modificar")
	public ResponseEntity<Usuario> modificar(@Valid @RequestBody Usuario usuario) {

		Usuario p = service.modificar(usuario);
		return new ResponseEntity<Usuario>(p, HttpStatus.CREATED);

	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {

		Usuario p = service.listarPorId(id);

		if (p.getIdUsuario()== null) {

			throw new ModeloNotFoundException("Id No encontrado " + id);

		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
