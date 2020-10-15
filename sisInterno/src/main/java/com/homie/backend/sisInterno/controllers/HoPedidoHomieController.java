package com.homie.backend.sisInterno.controllers;


import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.homie.backend.sisInterno.dto.PedidoListDto;
import com.homie.backend.sisInterno.dto.PedidoListDtoRequest;

import com.homie.backend.sisInterno.service.HoPedidoHomieService;

@RestController
@RequestMapping("/api/HoPedidoHomie")

public class HoPedidoHomieController {
	
	private HoPedidoHomieService hoPedidoHomieService;
	
	public HoPedidoHomieController(HoPedidoHomieService hoPedidoHomieService) {
		this.hoPedidoHomieService = hoPedidoHomieService;
	}


	
	@GetMapping
	@RequestMapping("/HoPedidosPorHomie")
	public ResponseEntity<List<PedidoListDto>> listarDisponible(
			@RequestBody PedidoListDtoRequest entidad) {
		List<PedidoListDto> lista = hoPedidoHomieService.getPedidosPorClienteFecha(entidad.fecha, entidad.cedula);
		return new ResponseEntity<List<PedidoListDto>>(lista, HttpStatus.OK);
	}
	
	
	

	
	
}
