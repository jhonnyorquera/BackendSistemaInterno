package com.homie.backend.sisInterno.service;



import org.springframework.stereotype.Service;

import com.homie.backend.sisInterno.repositories.HoPedidoHomieRepository;

@Service
public class HoPedidoHomieService {
	private HoPedidoHomieRepository hoPedidoHomieRepository;

	
	public HoPedidoHomieService(HoPedidoHomieRepository hoPedidoHomieRepository) {
		this.hoPedidoHomieRepository = hoPedidoHomieRepository;
	}
	
	
	
}
