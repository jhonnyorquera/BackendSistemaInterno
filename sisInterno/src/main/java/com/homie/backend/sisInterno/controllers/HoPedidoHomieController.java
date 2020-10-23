package com.homie.backend.sisInterno.controllers;


import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.homie.backend.sisInterno.dto.ListaPedidosDto;
import com.homie.backend.sisInterno.dto.PedidoListDto;
import com.homie.backend.sisInterno.dto.PedidoListDtoRequest;
import com.homie.backend.sisInterno.dto.PedidoListDtoResponse;
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
	public ResponseEntity<List<PedidoListDtoResponse>> listarDisponible(
			@RequestBody PedidoListDtoRequest entidad) {
		List<PedidoListDtoResponse> lista = hoPedidoHomieService.getPedidosPorClienteFecha(entidad.fecha);
		
		for (PedidoListDtoResponse var : lista) {
			if (var.getPedidos() != null) {
				for (ListaPedidosDto aaa : var.getPedidos()) {
					if (aaa.getLpFechaPedido() != null) {
						System.out.println("fecha Pedido:  " + aaa.getLpFechaPedido());
					}
				}
			}
		}
		return new ResponseEntity<List<PedidoListDtoResponse>>(lista, HttpStatus.OK);
	}
	
	
	

	
	
}
