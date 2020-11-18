package com.homie.backend.sisInterno.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.homie.backend.sisInterno.dto.PedidoServicioDto;
import com.homie.backend.sisInterno.entity.HoPedidoServicio;
import com.homie.backend.sisInterno.service.HoPedidoServicioService;

@RestController
@RequestMapping("/api/HoPedidoServicio")

public class HoPedidoServicioController {

	private HoPedidoServicioService hoPedidoServicioService;

	public HoPedidoServicioController(HoPedidoServicioService hoPedidoServicioService) {
		this.hoPedidoServicioService = hoPedidoServicioService;
	}

	@PutMapping
	public ResponseEntity<HoPedidoServicio> editar(@RequestBody PedidoServicioDto entidad) {
		HoPedidoServicio item = hoPedidoServicioService.edit(entidad);
		return new ResponseEntity<HoPedidoServicio>(item, HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<HoPedidoServicio> guardar(@RequestBody PedidoServicioDto entidad) {
		HoPedidoServicio newServicio = this.hoPedidoServicioService.crearPedido(entidad);
		return ResponseEntity.status(HttpStatus.CREATED).body(newServicio);
	}
	
}