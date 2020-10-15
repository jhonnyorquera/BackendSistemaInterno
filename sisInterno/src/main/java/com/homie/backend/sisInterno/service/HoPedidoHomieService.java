package com.homie.backend.sisInterno.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.homie.backend.sisInterno.dto.PedidoListDto;
import com.homie.backend.sisInterno.repositories.HoPedidoHomieRepository;
import com.homie.backend.sisInterno.utils.ManejoFechas;

@Service
public class HoPedidoHomieService {
	private HoPedidoHomieRepository hoPedidoHomieRepository;

	public HoPedidoHomieService(HoPedidoHomieRepository hoPedidoHomieRepository) {
		this.hoPedidoHomieRepository = hoPedidoHomieRepository;
	}

	public List<PedidoListDto> getPedidosPorClienteFecha(Date fecha, String cedula) {
		if(fecha==null) {
			fecha=new Date();
		}
		return this.hoPedidoHomieRepository.getPedidosPorClienteFecha(ManejoFechas.quitarHora(fecha), cedula);
	}
	
	
}
