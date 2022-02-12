package com.iep.triunfo.matriculappbackend.service;

import java.util.List;

public interface ICRUD<T, V> { // T=type   V =Value
	
	T registrar(T obj);
	T modificar(T obj);
	List<T> listar();
	T listarPorId(V id);
	boolean eliminar(V id);

}
