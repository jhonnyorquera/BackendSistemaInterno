package com.homie.backend.sisInterno.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homie.backend.sisInterno.dto.DashboardDto;
import com.homie.backend.sisInterno.repositories.HoClienteRepository;
import com.homie.backend.sisInterno.repositories.HoPedidoHomieRepository;
import com.homie.backend.sisInterno.repositories.HoPedidoRepository;
import com.homie.backend.sisInterno.utils.ManejoFechas;

@Service
public class HoDashboardService {

	@Autowired
	private HoPedidoRepository hoPedidoRepository;
	
	@Autowired
	private HoClienteRepository hoClienteRepository;

	@Autowired
	private HoPedidoHomieRepository hoPedidoHomieRepository;
	
	public DashboardDto getInfoDashboard() {

		Date fecha = new Date();
		
	   DashboardDto dash =new DashboardDto();

		dash.setCantPedidos(hoPedidoRepository.cantidadPedidos(ManejoFechas.getFechaInicio(fecha), ManejoFechas.getFechaFin(fecha)));
        dash.setCantClientes(hoClienteRepository.count());
        dash.setCalificacion(hoPedidoHomieRepository.getCalificacion(ManejoFechas.getFechaInicio(fecha), ManejoFechas.getFechaFin(fecha), "CANCELADO"));
		return dash;
	}

}
