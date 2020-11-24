package com.homie.backend.sisInterno.controllers;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homie.backend.sisInterno.entity.HoCliente;
import com.homie.backend.sisInterno.service.HoClienteService;

@RestController
@RequestMapping("/api/HoCliente")

public class HoClienteController {
	
	private HoClienteService hoClienteService;
	
	public HoClienteController(HoClienteService hoClienteService) {
		this.hoClienteService = hoClienteService;
	}

	@PostMapping
	public ResponseEntity<HoCliente> guardar(@RequestBody HoCliente entidad) {
		HoCliente newCliente = hoClienteService.registrarCliente(entidad);
		if (newCliente == null) {
			throw new DataIntegrityViolationException("ya existe entidad");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(newCliente);
	}
	
	
	@GetMapping
	public ResponseEntity<List<HoCliente>> listar() {
		List<HoCliente> lista = hoClienteService.listarClientes();
		return new ResponseEntity<List<HoCliente>>(lista, HttpStatus.OK);
	}
	
	
	@GetMapping
	@RequestMapping("/findByNombre/{name}")
	public ResponseEntity<List<HoCliente>> findByNombre(@PathVariable String name) {
		List<HoCliente> lista = hoClienteService.findByNombre(name);
		System.out.println("tamaño de lista: "+lista.size());
		return new ResponseEntity<List<HoCliente>>(lista, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<HoCliente> editar(@RequestBody HoCliente entidad) {
		HoCliente updatedCliente = hoClienteService.editarCliente(entidad);
		return new ResponseEntity<HoCliente>(updatedCliente, HttpStatus.OK);
		
	}
	
	
	
	
}
