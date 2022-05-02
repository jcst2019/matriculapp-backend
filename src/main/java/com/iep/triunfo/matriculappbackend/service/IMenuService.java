package com.iep.triunfo.matriculappbackend.service;

import com.iep.triunfo.matriculappbackend.model.Menu;

import java.util.List;


public interface IMenuService extends IGenericService<Menu, Integer>{
	
	List<Menu> listarMenuPorUsuario(String nombre);
	List<Menu> listarMenuPorRol(Integer idRol);
	List<Menu> regsitrarMenuPorRol(List<Menu> listaMenu);
	List<Menu> borrarMenuPorRol(Integer idRol);

}
