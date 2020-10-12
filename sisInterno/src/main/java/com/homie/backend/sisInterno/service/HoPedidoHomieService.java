package com.homie.backend.sisInterno.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.homie.backend.sisInterno.entity.HoPedidoHomie;
import com.homie.backend.sisInterno.repositories.HoPedidoHomieRepository;

@Service
public class HoPedidoHomieService {
	private HoPedidoHomieRepository hoPedidoHomieRepository;

	
	public HoPedidoHomieService(HoPedidoHomieRepository hoPedidoHomieRepository) {
		this.hoPedidoHomieRepository = hoPedidoHomieRepository;
	}
	
	

	

	
	
	public List<HoPedidoHomie> listarPedidos() {
		
		return (List<HoPedidoHomie>) hoPedidoHomieRepository.findAll();
		
	}
	
}
