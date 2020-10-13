package com.homie.backend.sisInterno.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homie.backend.sisInterno.entity.HoPedidoHomie;
import com.homie.backend.sisInterno.service.HoPedidoHomieService;

@RestController
@RequestMapping("/api/HoPedidoHomie")

public class HoPedidoHomieController {

	private HoPedidoHomieService hoPedidoHomieService;

	public HoPedidoHomieController(HoPedidoHomieService hoPedidoHomieService) {
		this.hoPedidoHomieService = hoPedidoHomieService;
	}

	@GetMapping("/disponibilidadHomie")
	public ResponseEntity<List<HoPedidoHomie>> listar(
			@RequestParam(required = false) String cedula,
			@RequestParam(required=true) @DateTimeFormat(pattern="dd-MM-yyyy") Date createdDate) {
		HashMap<String, Object> data = new HashMap<>();
		data.put("hoCedula", cedula);
		data.put("peFechaPedido", createdDate);
		List<HoPedidoHomie> lista = hoPedidoHomieService.listarPedidos(data);

		return new ResponseEntity<List<HoPedidoHomie>>(lista, HttpStatus.OK);
	}



}
