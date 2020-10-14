package com.homie.backend.sisInterno.service;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.homie.backend.sisInterno.entity.HoPedido;
import com.homie.backend.sisInterno.repositories.HoPedidoRepository;

@Service
public class HoPedidoService {
	private HoPedidoRepository hoPedidoRepository;

	
	public HoPedidoService(HoPedidoRepository hoPedidoRepository) {
		this.hoPedidoRepository = hoPedidoRepository;
	}
	
	

	
	public List<HoPedido> listarPedidos(String condition1,Date condition2) {	
		return (List<HoPedido>) hoPedidoRepository.getPedidos(condition1, condition2);
	}
	
}
