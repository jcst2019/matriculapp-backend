package com.iep.triunfo.matriculappbackend.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.iep.triunfo.matriculappbackend.model.Menu;
import com.iep.triunfo.matriculappbackend.repo.IGenericRepo;
import com.iep.triunfo.matriculappbackend.repo.IMenuRepo;
import com.iep.triunfo.matriculappbackend.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MenuServiceImpl extends GenericServiceImpl<Menu, Integer> implements IMenuService {

	@Autowired
	private IMenuRepo repo;

	@Override
	protected IGenericRepo<Menu, Integer> getRepo() {
		return repo;
	}
	
	@Override
	public List<Menu> listarMenuPorUsuario(String nombre) {
		/*List<Menu> menus = new ArrayList<>();
		repo.listarMenuPorUsuario(nombre).forEach(x -> {
			Menu m = new Menu();
			m.setIdMenu((Integer.parseInt(String.valueOf(x[0]))));
			m.setIcono(String.valueOf(x[1]));
			m.setNombre(String.valueOf(x[2]));
			m.setUrl(String.valueOf(x[3]));		
			
			menus.add(m);
		});
		return menus;*/
		return repo.listarMenuPorUsuario(nombre);
	}

	@Override
	public List<Menu> listarMenuPorRol(Integer idRol) {
		return repo.listarMenuPorRol(idRol);
	}

	@Override
	public List<Menu> regsitrarMenuPorRol(List<Menu> listaMenu) {
		//Obtenemos el idRol (Siempre será 1, por ello lo obtenemos del indice 0)
		Integer iddRol =listaMenu.get(0).getRoles().get(0).getIdRol();

		listaMenu.forEach((final Menu menu) -> repo.insertarMenuPorRol(menu.getIdMenu(),iddRol));

		return null;
	}

	@Override
	public List<Menu> borrarMenuPorRol(Integer idRol) {

		repo.borrarMenuPorRol(idRol);
		return null;
	}


}
