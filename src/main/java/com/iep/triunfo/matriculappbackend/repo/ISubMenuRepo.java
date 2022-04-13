package com.iep.triunfo.matriculappbackend.repo;

import com.iep.triunfo.matriculappbackend.model.SubMenu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ISubMenuRepo extends IGenericRepo<SubMenu, Integer>{

	@Query(value="select * from submenu\n" +
			     "where id_menu = :id\n" +
			     "order by id_submenu ", nativeQuery = true)
	List<SubMenu> listarSubMenuPorIdMenu(@Param("id") Integer id);

}
