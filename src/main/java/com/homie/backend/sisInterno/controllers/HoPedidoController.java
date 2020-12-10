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

import com.homie.backend.sisInterno.dto.BusquedaDto;
import com.homie.backend.sisInterno.dto.BusquedaResponseDto;
import com.homie.backend.sisInterno.dto.CrearPedidoRequestDto;
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
	public ResponseEntity<List<HoPedido>> listar() {
		List<HoPedido> lista = hoPedidoService.buscarPedidos();
		return new ResponseEntity<List<HoPedido>>(lista, HttpStatus.OK);
	}
	

	
	@PostMapping
	@RequestMapping("/HoCrearPedido")
	public ResponseEntity<String> guardarPedido(@RequestBody CrearPedidoRequestDto entidad) {
		String codigoPedido=hoPedidoService.guardarPedido(entidad);

		return ResponseEntity.status(HttpStatus.CREATED).body(codigoPedido);
	}
	
	@GetMapping
	@RequestMapping("/{codigo}")
	public ResponseEntity<HoPedido> guardarPedido(@PathVariable String codigo) {
		HoPedido pedido=hoPedidoService.findPedidoById(codigo);

		return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
	}
	
	
	@PostMapping
	@RequestMapping("/pedidos")
	public ResponseEntity<List<BusquedaResponseDto>> listarPedidos(@RequestBody BusquedaDto busqueda){
		List<BusquedaResponseDto> lista = this.hoPedidoService.buscarPedidos(busqueda);
		return new ResponseEntity<List<BusquedaResponseDto>>(lista, HttpStatus.OK);
	}
	
	
	@PutMapping
	public ResponseEntity<HoPedido> guardarPedido(@RequestBody HoPedido entidad) {
		HoPedido pedido =hoPedidoService.editar(entidad);
		return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
	}

	
	
}
