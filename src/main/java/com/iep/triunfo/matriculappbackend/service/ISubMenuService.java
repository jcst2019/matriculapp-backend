package com.iep.triunfo.matriculappbackend.service;

import com.iep.triunfo.matriculappbackend.model.Menu;
import com.iep.triunfo.matriculappbackend.model.SubMenu;

import java.util.List;


public interface ISubMenuService extends IGenericService<SubMenu, Integer>{
	
	List<SubMenu> listarSubMenuPorIdMenu(Integer id);

}
