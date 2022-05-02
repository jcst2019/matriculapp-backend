package com.iep.triunfo.matriculappbackend.repo;

import java.util.List;

import com.iep.triunfo.matriculappbackend.model.Menu;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface IMenuRepo extends IGenericRepo<Menu, Integer>{

	@Query(value="select m.* from menu_rol mr " +
			"inner join usuario_rol ur on ur.id_rol = mr.id_rol " +
			"inner join menu m on m.id_menu = mr.id_menu " +
			"inner join usuario u on u.id_usuario = ur.id_usuario " +
			"where u.username = :nombre " +
			"order by m.id_menu", nativeQuery = true)
	List<Menu> listarMenuPorUsuario(@Param("nombre") String nombre);

	@Query(value="select m.* from menu_rol mr \n" +
			"inner join menu m on m.id_menu = mr.id_menu \n" +
			"where mr.id_rol = :idRol", nativeQuery = true)
	List<Menu> listarMenuPorRol(@Param("idRol") Integer idRol);

	@Modifying
	@Transactional
	@Query(value="delete from menu_rol where id_rol = :idRol", nativeQuery = true)
	void borrarMenuPorRol(@Param("idRol") Integer idRol);

	@Modifying
	@Transactional
	@Query(value="INSERT INTO menu_rol (id_menu, id_rol) VALUES (:idMenu, :idRol)", nativeQuery = true)
	void insertarMenuPorRol(@Param("idMenu") Integer idMenu,@Param("idRol")  Integer idRol);

}
