package com.iep.triunfo.matriculappbackend.controller;

import java.util.ArrayList;
import java.util.List;

import com.iep.triunfo.matriculappbackend.model.Menu;
import com.iep.triunfo.matriculappbackend.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/menus")
public class MenuController {
	
	@Autowired
	private IMenuService service;

	@GetMapping("/listar")
	public ResponseEntity<List<Menu>> listar() throws Exception{
		List<Menu> menus = new ArrayList<>();
		menus = service.listar();
		return new ResponseEntity<List<Menu>>(menus, HttpStatus.OK);
	}
	
	@PostMapping("/usuario")
	public ResponseEntity<List<Menu>> listar(@RequestBody String nombre) throws Exception{
		List<Menu> menus = new ArrayList<>();
		menus = service.listarMenuPorUsuario(nombre);
		return new ResponseEntity<List<Menu>>(menus, HttpStatus.OK);
	}

	@PostMapping("/roles")
	public ResponseEntity<List<Menu>> listarPorRol(@RequestBody Integer idRol) throws Exception{
		List<Menu> menus = new ArrayList<>();
		menus = service.listarMenuPorRol(idRol);
		return new ResponseEntity<List<Menu>>(menus, HttpStatus.OK);
	}

	@PostMapping("/borrarMenuPorRol")
	public ResponseEntity<List<Menu>> borrarMenuPorRol(@RequestBody Integer idRol) throws Exception{
		List<Menu> menus = new ArrayList<>();
		menus =  service.borrarMenuPorRol(idRol);
		return new ResponseEntity<List<Menu>>(menus, HttpStatus.OK);
	}

	@PostMapping("/registrarMenuPorRol")
	public ResponseEntity<List<Menu>> registrarMenuPorRol(@RequestBody List<Menu> listaMenu) throws Exception{

		List<Menu> menus = new ArrayList<>();

		service.regsitrarMenuPorRol(listaMenu);

		return new ResponseEntity<List<Menu>>(menus, HttpStatus.OK);
	}

}
