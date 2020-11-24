package com.homie.backend.sisInterno.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homie.backend.sisInterno.entity.HoCatalogo;
import com.homie.backend.sisInterno.service.HoCatalogoService;

@RestController
@RequestMapping("/api/HoCatalogo")

public class HoCatalogoController {
	
	private HoCatalogoService hoCatalogoService;
	
	public HoCatalogoController(HoCatalogoService hoCatalogoService) {
		this.hoCatalogoService = hoCatalogoService;
	}

	@PostMapping
	public ResponseEntity<HoCatalogo> guardar(@RequestBody HoCatalogo entidad) {
	
		HoCatalogo newServicio = hoCatalogoService.registrarCatalogo(entidad);
		return ResponseEntity.status(HttpStatus.CREATED).body(newServicio);
	}
	
	
	@GetMapping
	public ResponseEntity<List<HoCatalogo>> listar() {
		List<HoCatalogo> lista = hoCatalogoService.listarCatalogo();
		return new ResponseEntity<List<HoCatalogo>>(lista, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<HoCatalogo> editar(@RequestBody HoCatalogo entidad) {
		HoCatalogo updatedCatalogo = hoCatalogoService.editarCatalogo(entidad);
		return new ResponseEntity<HoCatalogo>(updatedCatalogo, HttpStatus.OK);
		
	}
	
	
}
