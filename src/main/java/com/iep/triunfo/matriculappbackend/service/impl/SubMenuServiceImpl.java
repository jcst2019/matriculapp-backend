package com.iep.triunfo.matriculappbackend.service.impl;

import com.iep.triunfo.matriculappbackend.model.Menu;
import com.iep.triunfo.matriculappbackend.model.SubMenu;
import com.iep.triunfo.matriculappbackend.repo.IGenericRepo;
import com.iep.triunfo.matriculappbackend.repo.ISubMenuRepo;
import com.iep.triunfo.matriculappbackend.service.IMenuService;
import com.iep.triunfo.matriculappbackend.service.ISubMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SubMenuServiceImpl extends GenericServiceImpl<SubMenu, Integer> implements ISubMenuService {

	@Autowired
	private ISubMenuRepo repo;

	@Override
	protected IGenericRepo<SubMenu, Integer> getRepo() {
		return null;
	}

	@Override
	public List<SubMenu> listarSubMenuPorIdMenu(Integer id) {
		return repo.listarSubMenuPorIdMenu(id);
	}
}
