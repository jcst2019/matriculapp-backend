package com.iep.triunfo.matriculappbackend.controller;

import com.iep.triunfo.matriculappbackend.model.Menu;
import com.iep.triunfo.matriculappbackend.model.Usuario;
import com.iep.triunfo.matriculappbackend.repo.IUsuarioRepo;
import com.iep.triunfo.matriculappbackend.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUsuarioRepo repo; //Debería de ser un Service

	@GetMapping("/listarPorUsername/{username}")
	public ResponseEntity<Usuario> listarPorUsername(@PathVariable("username") String username) throws Exception{
		Usuario usuario = new Usuario();
		usuario = repo.findOneByUsername(username);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

}
