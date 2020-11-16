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

import com.homie.backend.sisInterno.dto.BusquedaDto;
import com.homie.backend.sisInterno.dto.HoPedidoHomieCrearDto;
import com.homie.backend.sisInterno.dto.ListaPedidosDto;
import com.homie.backend.sisInterno.dto.PedidoListDto;
import com.homie.backend.sisInterno.dto.PedidoListDtoRequest;
import com.homie.backend.sisInterno.dto.PedidoListDtoResponse;
import com.homie.backend.sisInterno.entity.HoHomie;
import com.homie.backend.sisInterno.entity.HoPedidoHomie;
import com.homie.backend.sisInterno.service.HoPedidoHomieService;

@RestController
@RequestMapping("/api/HoPedidoHomie")

public class HoPedidoHomieController {

	private HoPedidoHomieService hoPedidoHomieService;

	public HoPedidoHomieController(HoPedidoHomieService hoPedidoHomieService) {
		this.hoPedidoHomieService = hoPedidoHomieService;
	}

	@PostMapping
	@RequestMapping("/HoPedidosPorHomie")
	public ResponseEntity<List<PedidoListDtoResponse>> listarDisponible(@RequestBody PedidoListDtoRequest entidad) {
		List<PedidoListDtoResponse> lista = hoPedidoHomieService.getPedidosPorClienteFecha(entidad.fecha);
		return new ResponseEntity<List<PedidoListDtoResponse>>(lista, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<List<HoPedidoHomie>> actualizarPedido(@RequestBody HoPedidoHomieCrearDto entidad) {
		List<HoPedidoHomie>pedidoHomie = hoPedidoHomieService.crear(entidad);
		return new ResponseEntity<List<HoPedidoHomie>>(pedidoHomie, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<HoPedidoHomie> crearPedido(@RequestBody HoPedidoHomie entidad) {
		HoPedidoHomie pedidoHomie = hoPedidoHomieService.update(entidad);
		return new ResponseEntity<HoPedidoHomie>(pedidoHomie, HttpStatus.OK);
	}
	

}
