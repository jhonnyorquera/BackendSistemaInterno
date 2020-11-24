package com.homie.backend.sisInterno.controllers;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homie.backend.sisInterno.dto.PedidoPagoDto;
import com.homie.backend.sisInterno.dto.SaldosPagoDto;
import com.homie.backend.sisInterno.entity.HoPedido;
import com.homie.backend.sisInterno.entity.HoPedidoPagos;
import com.homie.backend.sisInterno.service.HoPedidoPagosService;

@RestController
@RequestMapping("/api/HoPedidoPagos")

public class HoPedidoPagosController {

	private HoPedidoPagosService hoPedidoPagosService;

	public HoPedidoPagosController(HoPedidoPagosService hoPedidoPagosService) {
		this.hoPedidoPagosService = hoPedidoPagosService;
	}

	@PutMapping
	public ResponseEntity<HoPedidoPagos> editar(@RequestBody HoPedidoPagos entidad) {
		HoPedidoPagos item = hoPedidoPagosService.edit(entidad);
		return new ResponseEntity<HoPedidoPagos>(item, HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<HoPedidoPagos> guardar(@RequestBody PedidoPagoDto entidad) {
		HoPedidoPagos newServicio = this.hoPedidoPagosService.guardar(entidad);
		return ResponseEntity.status(HttpStatus.CREATED).body(newServicio);
	}
	
	@GetMapping
	@RequestMapping("/saldo")
	public ResponseEntity<List<SaldosPagoDto>> saldosPago() {
		List<SaldosPagoDto> saldos = hoPedidoPagosService.saldosPago();
		return new ResponseEntity<List<SaldosPagoDto>>(saldos, HttpStatus.OK);

	}
	

	
	
}