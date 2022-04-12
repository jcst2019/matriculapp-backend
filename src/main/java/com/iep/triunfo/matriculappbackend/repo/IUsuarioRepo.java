package com.iep.triunfo.matriculappbackend.repo;


import com.iep.triunfo.matriculappbackend.model.Usuario;

public interface IUsuarioRepo extends IGenericRepo<Usuario, Integer>  {

	//select * from usuario where username = ?
	Usuario findOneByUsername(String username);
}
