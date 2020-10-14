package com.homie.backend.sisInterno.controllers;

import java.util.Date;
import java.util.List;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homie.backend.sisInterno.entity.HoPedido;
import com.homie.backend.sisInterno.service.HoPedidoService;

@RestController
@RequestMapping("/api/HoPedido")

public class HoPedidoController {
	
	private HoPedidoService hoPedidoService;
	
	public HoPedidoController(HoPedidoService hoPedidoService) {
		this.hoPedidoService = hoPedidoService;
	}


	
	@GetMapping
	@RequestMapping("/HoPedidosPorHomie")
	public ResponseEntity<List<HoPedido>> listarDisponible(
			@RequestParam(required = true) String condition1,
			@RequestParam(required= true) @DateTimeFormat(pattern="dd-MM-yyyy") Date condition2
			) {
		List<HoPedido> lista = hoPedidoService.listarPedidos(condition1, condition2);
		return new ResponseEntity<List<HoPedido>>(lista, HttpStatus.OK);
	}
	

	
	
}
