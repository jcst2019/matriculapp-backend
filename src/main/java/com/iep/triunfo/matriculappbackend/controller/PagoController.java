package com.iep.triunfo.matriculappbackend.controller;

import com.iep.triunfo.matriculappbackend.dto.ConsultaResumenPagoDTO;
import com.iep.triunfo.matriculappbackend.exception.ModeloNotFoundException;
import com.iep.triunfo.matriculappbackend.model.Alumno;
import com.iep.triunfo.matriculappbackend.model.Pago;
import com.iep.triunfo.matriculappbackend.service.IAlumnoService;
import com.iep.triunfo.matriculappbackend.service.IPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/pagos")
public class PagoController {

	@Autowired
	private IPagoService service;


	@GetMapping("/listar")
	public ResponseEntity<List<Pago>> listar() {

		List<Pago> lista = service.listar();
		return new ResponseEntity<List<Pago>>(lista, HttpStatus.OK);
	}

	@GetMapping("/listar/{id}")
	public ResponseEntity<Pago> listarPorId(@PathVariable("id") Integer id) {

		Pago p = service.listarPorId(id);
		if (p.getIdPago() == null) {

			throw new ModeloNotFoundException("Id No encontrado " + id);

		}
		return new ResponseEntity<Pago>(p, HttpStatus.OK);

	}
	/*
	@GetMapping("/hateos/listar/{id}")
	public EntityModel<Alumno> listarPorIdHateoas(@PathVariable("id") Integer id) {

		Alumno p = service.listarPorId(id);

		EntityModel<Alumno> recurso = new EntityModel<Alumno>(p);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		recurso.add(linkTo.withRel("paciente-recurso"));
	}
   */
	/*
	 * @PostMapping public ResponseEntity<Paciente> registrar(@Valid @RequestBody
	 * Paciente paciente) {
	 * 
	 * Paciente p = service.registrar(paciente); return new
	 * ResponseEntity<Paciente>(p, HttpStatus.CREATED);
	 * 
	 * }
	 */

	@PostMapping("/registrar")
	public ResponseEntity<Object> registrar(@Valid @RequestBody Pago pago) {

		Pago p = service.registrar(pago);
		// return new ResponseEntity<Paciente>(p, HttpStatus.CREATED);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdPago())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/modificar")
	public ResponseEntity<Pago> modificar(@Valid @RequestBody Pago pago) {

		Pago p = service.registrar(pago);
		return new ResponseEntity<Pago>(p, HttpStatus.CREATED);

	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {

		Pago p = service.listarPorId(id);

		if (p.getIdPago() == null) {

			throw new ModeloNotFoundException("Id No encontrado " + id);

		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	//Servicio para Generar el reporte de Pagos

	@GetMapping(value = "/listarResumenPagos")
	public ResponseEntity<List<ConsultaResumenPagoDTO>> listarResumenPagos() {
		List<ConsultaResumenPagoDTO> consultas = new ArrayList<>();
		consultas = service.listarResumenPagos();
		return new ResponseEntity<List<ConsultaResumenPagoDTO>>(consultas, HttpStatus.OK);
	}

	@GetMapping(value = "/generarConstanciaPago/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> generarConstanciaPago(@PathVariable("id") Integer id) {
		byte[] data = null;
		data = service.generarConstanciaPago(id);
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
	}


}
