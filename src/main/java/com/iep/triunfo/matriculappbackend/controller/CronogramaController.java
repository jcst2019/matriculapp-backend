package com.iep.triunfo.matriculappbackend.controller;

import com.iep.triunfo.matriculappbackend.exception.ModeloNotFoundException;
import com.iep.triunfo.matriculappbackend.model.Cronograma;
import com.iep.triunfo.matriculappbackend.util.DatoRetorno;
import com.iep.triunfo.matriculappbackend.model.Matricula;
import com.iep.triunfo.matriculappbackend.service.ICronogramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/cronogramas")
public class CronogramaController {

	@Autowired
	private ICronogramaService service;

	@PostMapping("/getdescuentos")
	public ResponseEntity<DatoRetorno> obtenerDescuento(@RequestBody Matricula matricula) {

		float descuento = 0.0F;
		DatoRetorno datoRetorno = new DatoRetorno();

		if (matricula != null) {
			descuento = service.obtenerMontoDescuento(matricula);
			datoRetorno.setDato(descuento);
			datoRetorno.setRespuesta("Datos Obtenido Exitosamente");
		}
		return new ResponseEntity<DatoRetorno>(datoRetorno, HttpStatus.OK);
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Cronograma>> listar() {

		List<Cronograma> lista = service.listar();
		return new ResponseEntity<List<Cronograma>>(lista, HttpStatus.OK);
	}


	@GetMapping("/listar/{id}")
	public ResponseEntity<Cronograma> listarPorId(@PathVariable("id") Integer id) {

		Cronograma p = service.listarPorId(id);
		if (p.getIdCronograma()== null) {

			throw new ModeloNotFoundException("Id No encontrado " + id);

		}
		return new ResponseEntity<Cronograma>(p, HttpStatus.OK);

	}

	@PostMapping("/registrar")
	public ResponseEntity<Object> registrar(@Valid @RequestBody Cronograma cronograma) {

		Cronograma p = service.registrar(cronograma);
		// return new ResponseEntity<Paciente>(p, HttpStatus.CREATED);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdCronograma())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/modificar")
	public ResponseEntity<Cronograma> modificar(@Valid @RequestBody Cronograma cronograma) {

		Cronograma p = service.registrar(cronograma);
		return new ResponseEntity<Cronograma>(p, HttpStatus.CREATED);

	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {

		Cronograma p = service.listarPorId(id);

		if (p.getIdCronograma() == null) {

			throw new ModeloNotFoundException("Id No encontrado " + id);

		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
