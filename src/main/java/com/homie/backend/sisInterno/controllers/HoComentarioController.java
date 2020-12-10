package com.homie.backend.sisInterno.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homie.backend.sisInterno.dto.ComentarioPedidoDto;
import com.homie.backend.sisInterno.entity.HoComentario;
import com.homie.backend.sisInterno.service.HoPedidoComentarioService;

@RestController
@RequestMapping("/api/HoComentario")

public class HoComentarioController {

	private HoPedidoComentarioService hoComentarioService;

	public HoComentarioController(HoPedidoComentarioService hoPedidoComentarioService) {
		this.hoComentarioService = hoPedidoComentarioService;
	}

	@PutMapping
	public ResponseEntity<HoComentario> editar(@RequestBody ComentarioPedidoDto entidad) {
		HoComentario item = hoComentarioService.edit(entidad);
		return new ResponseEntity<HoComentario>(item, HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<HoComentario> guardar(@RequestBody ComentarioPedidoDto entidad) {
		HoComentario coment = this.hoComentarioService.guardar(entidad);
		return ResponseEntity.status(HttpStatus.CREATED).body(coment);
	}
	
}