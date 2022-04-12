package com.iep.triunfo.matriculappbackend.controller;

import com.iep.triunfo.matriculappbackend.dto.DetalleCronogramaPagoDTO;
import com.iep.triunfo.matriculappbackend.exception.ModeloNotFoundException;
import com.iep.triunfo.matriculappbackend.model.Cronograma;
import com.iep.triunfo.matriculappbackend.model.DetalleCronograma;
import com.iep.triunfo.matriculappbackend.model.Matricula;
import com.iep.triunfo.matriculappbackend.model.ProgramacionMatricula;
import com.iep.triunfo.matriculappbackend.service.ICronogramaService;
import com.iep.triunfo.matriculappbackend.service.IDetalleCronogramaService;
import com.iep.triunfo.matriculappbackend.util.DatoRetorno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("api/detallecronogramas")
public class DetalleCronogramaController {

	@Autowired
	private IDetalleCronogramaService service;

	@GetMapping("/listar")
	public ResponseEntity<List<DetalleCronograma>> listar() {

		List<DetalleCronograma> lista = service.listar();
		return new ResponseEntity<List<DetalleCronograma>>(lista, HttpStatus.OK);
	}


	@GetMapping("/listar/{id}")
	public ResponseEntity<DetalleCronograma> listarPorId(@PathVariable("id") Integer id) {

		DetalleCronograma p = service.listarPorId(id);
		if (p.getIdDetalleCronograma()== null) {

			throw new ModeloNotFoundException("Id No encontrado " + id);

		}
		return new ResponseEntity<DetalleCronograma>(p, HttpStatus.OK);

	}

	@PostMapping("/registrar")
	public ResponseEntity<Object> registrar(@Valid @RequestBody DetalleCronograma detalleCronograma) {

		DetalleCronograma p = service.registrar(detalleCronograma);
		// return new ResponseEntity<Paciente>(p, HttpStatus.CREATED);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdDetalleCronograma())
				.toUri();
		return ResponseEntity.created(location).build();

	}

	@PutMapping("/modificar")
	public ResponseEntity<DetalleCronograma> modificar(@Valid @RequestBody DetalleCronograma detalleCronograma) {

		DetalleCronograma p = service.registrar(detalleCronograma);
		return new ResponseEntity<DetalleCronograma>(p, HttpStatus.CREATED);

	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {

		DetalleCronograma p = service.listarPorId(id);

		if (p.getIdDetalleCronograma() == null) {

			throw new ModeloNotFoundException("Id No encontrado " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/registrar/montopagado")
	public ResponseEntity<DetalleCronograma> registrarMontoPagado(@Valid @RequestBody DetalleCronogramaPagoDTO obj) {

		DetalleCronograma detalleCronogramaActualizado = service.listarPorId(obj.getIdDetalleCronograma());

		DetalleCronograma p = service.registrarMontoPagado(detalleCronogramaActualizado,obj.getMontoPorPagar());
		return new ResponseEntity<DetalleCronograma>(p, HttpStatus.CREATED);

	}


}
