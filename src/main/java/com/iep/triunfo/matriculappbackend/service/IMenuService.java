package com.iep.triunfo.matriculappbackend.service;

import com.iep.triunfo.matriculappbackend.model.Menu;

import java.util.List;


public interface IMenuService extends IGenericService<Menu, Integer>{
	
	List<Menu> listarMenuPorUsuario(String nombre);

}
