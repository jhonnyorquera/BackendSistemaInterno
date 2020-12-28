package com.homie.backend.sisInterno.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homie.backed.sisInterno.enums.TipoPedido;
import com.homie.backend.sisInterno.dto.DashboardDto;
import com.homie.backend.sisInterno.dto.HomieCaracteristica;
import com.homie.backend.sisInterno.entity.HoPedido;
import com.homie.backend.sisInterno.entity.HoPedidoHomie;
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

		DashboardDto dash = new DashboardDto();

		dash.setCantPedidos(hoPedidoRepository.cantidadPedidos(ManejoFechas.getFechaInicio(fecha),
				ManejoFechas.getFechaFin(fecha)));
		dash.setCantClientes(hoClienteRepository.count());
		dash.setCalificacion(hoPedidoHomieRepository.getCalificacion(ManejoFechas.getFechaInicio(fecha),
				ManejoFechas.getFechaFin(fecha), "CANCELADO"));

		List<HoPedidoHomie> lista = hoPedidoHomieRepository.findByFechas(ManejoFechas.getFechaInicio(fecha),
				ManejoFechas.getFechaFin(fecha), "CANCELADO", true);

		dash.setDinero(dineroXHomie(lista));
		dash.setLimpiezas(cantLimpiezas(lista));
		dash.setDineroRecaudado(dash.getDinero().stream().mapToDouble(f -> f.getCantidad()).sum());
		
		

		
		return dash;
	}

	private List<HomieCaracteristica> cantLimpiezas(List<HoPedidoHomie> list) {
		List<HomieCaracteristica> li = new ArrayList<>();
		list.stream().forEach(
				a -> li.add(new HomieCaracteristica(a.getHoHomie().getHoCedula(), a.getHoHomie().getHoNombre(), 1.00)));

		List<HomieCaracteristica> transform = li.stream().collect(Collectors.groupingBy(foo -> foo.getCedula()))
				.entrySet().stream()
				.map(e -> e.getValue().stream().reduce((f1, f2) -> new HomieCaracteristica(f1.getCedula(),
						f1.getNombre(), f1.getCantidad() + f2.getCantidad())))
				.map(f -> f.get()).collect(Collectors.toList());

		return transform;

	}

	private List<HomieCaracteristica> dineroXHomie(List<HoPedidoHomie> list) {
		List<HomieCaracteristica> li = new ArrayList<>();
		list.stream().forEach(a -> li.add(new HomieCaracteristica(a.getHoHomie().getHoCedula(),
				a.getHoHomie().getHoNombre(), valorPedido(a.getHoPedido()))));

		List<HomieCaracteristica> transform = li.stream().collect(Collectors.groupingBy(foo -> foo.getCedula()))
				.entrySet().stream()
				.map(e -> e.getValue().stream().reduce((f1, f2) -> new HomieCaracteristica(f1.getCedula(),
						f1.getNombre(), f1.getCantidad() + f2.getCantidad())))
				.map(f -> f.get()).collect(Collectors.toList());
		
		 double count =transform.stream().mapToDouble(f -> f.getCantidad()).sum(); 
		 System.out.println("suma: "+count);
               
		
		return transform;

	}

	private double valorPedido(HoPedido pedido) {
		double var = 0;
		if (pedido.getPeTipo().equals(TipoPedido.PRINCIPAL.getKey())) {
			if (pedido.getPedidosDependientes().size() > 1) {
				int cantidad = pedido.getPedidosDependientes().size();
				var = pedido.getPeValor() / cantidad;
			} else {
				var = pedido.getPeValor();
			}
		}
		if (pedido.getPeTipo().equals(TipoPedido.PLAN.getKey())) {
			HoPedido pedPadre = pedido.getHoPedidoPadre();
			var = pedPadre.getPeValor() / (pedPadre.getPedidosDependientes().size() + 1);
		}
		return var;
	}

}