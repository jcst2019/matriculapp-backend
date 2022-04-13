package com.iep.triunfo.matriculappbackend.controller;

import com.iep.triunfo.matriculappbackend.model.Menu;
import com.iep.triunfo.matriculappbackend.model.SubMenu;
import com.iep.triunfo.matriculappbackend.service.IMenuService;
import com.iep.triunfo.matriculappbackend.service.ISubMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/submenus")
public class SubMenuController {
	
	@Autowired
	private ISubMenuService service;

	@GetMapping( "/listar/menu/{id}")
	public ResponseEntity<List<SubMenu>> listar(@PathVariable("id") Integer id) throws Exception{
		List<SubMenu> submenus = new ArrayList<>();
		submenus = service.listarSubMenuPorIdMenu(id);
		return new ResponseEntity<List<SubMenu>>(submenus, HttpStatus.OK);

	}

}
