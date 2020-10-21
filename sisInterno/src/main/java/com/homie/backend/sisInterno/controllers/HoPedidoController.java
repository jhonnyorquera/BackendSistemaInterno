package com.homie.backend.sisInterno.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homie.backend.sisInterno.dto.CrearPedidoRequestDto;
import com.homie.backend.sisInterno.service.HoPedidoService;

@RestController
@RequestMapping("/api/HoPedido")

public class HoPedidoController {
	
	private HoPedidoService hoPedidoService;
	
	public HoPedidoController(HoPedidoService hoPedidoService) {
		this.hoPedidoService = hoPedidoService;
	}


	

	
	@PostMapping
	@RequestMapping("/HoCrearPedido")
	public ResponseEntity<String> guardarPedido(@RequestBody CrearPedidoRequestDto entidad) {
		String codigoPedido=hoPedidoService.guardarPedido(entidad);

		return ResponseEntity.status(HttpStatus.CREATED).body(codigoPedido);
	}
	

	
	
}
