package com.homie.backend.sisInterno.controllers;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homie.backend.sisInterno.entity.HoHomie;
import com.homie.backend.sisInterno.service.HoHomieService;

@RestController
@RequestMapping("/api/HoHomie")

public class HoHomieController {
	
	private HoHomieService hoHomieService;
	
	public HoHomieController(HoHomieService hoHomieService) {
		this.hoHomieService = hoHomieService;
	}

	@PostMapping
	public ResponseEntity<HoHomie> guardar(@RequestBody HoHomie entidad) {
		HoHomie newHomie = hoHomieService.registrarHomie(entidad);
		if (newHomie == null) {
			throw new DataIntegrityViolationException("ya existe entidad");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(newHomie);
	}
	
	
	@GetMapping
	public ResponseEntity<List<HoHomie>> listar() {
		List<HoHomie> lista = hoHomieService.listarHomies();
		return new ResponseEntity<List<HoHomie>>(lista, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<HoHomie> editar(@RequestBody HoHomie entidad) {
		HoHomie updatedHomie = hoHomieService.editarHomie(entidad);
		return new ResponseEntity<HoHomie>(updatedHomie, HttpStatus.OK);
		
	}
	
	
}
