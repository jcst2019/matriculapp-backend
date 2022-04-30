package com.iep.triunfo.matriculappbackend;

import com.iep.triunfo.matriculappbackend.model.Usuario;
import com.iep.triunfo.matriculappbackend.repo.IUsuarioRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MatriculappBackendApplicationTests {

	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Autowired
	private IUsuarioRepo repo;

	@Test
	void crearUsuario() {

		Usuario us = new Usuario();
		us.setIdUsuario(2);
		us.setUsername("sunat");
		us.setPassword(bcrypt.encode("123"));
		us.setEnabled(String.valueOf(true));
		//us.setEstado(1);
		Usuario retorno = repo.save(us);

		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));

	}

}
