package com.homie.backend.sisInterno.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homie.backed.sisInterno.enums.TipoPedido;
import com.homie.backend.sisInterno.dto.DashboardDto;
import com.homie.backend.sisInterno.dto.HomieCaracteristica;
import com.homie.backend.sisInterno.dto.ResumenHomieDto;
import com.homie.backend.sisInterno.entity.HoPedido;
import com.homie.backend.sisInterno.entity.HoPedidoHomie;
import com.homie.backend.sisInterno.repositories.HoClienteRepository;
import com.homie.backend.sisInterno.repositories.HoPedidoHomieRepository;
import com.homie.backend.sisInterno.repositories.HoPedidoRepository;
import com.homie.backend.sisInterno.utils.ManejoDecimal;
import com.homie.backend.sisInterno.utils.ManejoFechas;

@Service
public class HoDashboardService {

	@Autowired
	private HoPedidoRepository hoPedidoRepository;

	@Autowired
	private HoClienteRepository hoClienteRepository;

	@Autowired
	private HoPedidoHomieRepository hoPedidoHomieRepository;

	public DashboardDto getInfoDashboard(Date fechaInicial, Date fechaFinal) {
		

		DashboardDto dash = new DashboardDto();

		dash.setCantPedidos(
				hoPedidoRepository.cantidadPedidos(ManejoFechas.quitarHora(fechaInicial),
						ManejoFechas.finDia(fechaFinal)));
		dash.setCantClientes(hoClienteRepository.count());

		dash.setCalificacion(
				hoPedidoHomieRepository.getCalificacion(ManejoFechas.quitarHora(fechaInicial),
						ManejoFechas.finDia(fechaFinal), "CANCELADO"));

		List<HoPedidoHomie> lista = hoPedidoHomieRepository.findByFechas(
				ManejoFechas.quitarHora(fechaInicial),
				ManejoFechas.finDia(fechaFinal), "CANCELADO", true);

		dash.setDinero(dineroXHomie(lista));
		dash.setLimpiezas(cantLimpiezas(lista));
		dash.setDineroRecaudado(
				ManejoDecimal.truncar(dash.getDinero().stream().mapToDouble(f -> f.getCantidad()).sum()));

		dash.setResumenHomie(cargarResumen(dash));
		return dash;
	}

	private List<ResumenHomieDto> cargarResumen(DashboardDto dash) {
		List<ResumenHomieDto> resumen = new ArrayList<>();

		// res
		dash.getDinero().stream().forEach(a -> resumen.add(new ResumenHomieDto(a.getCedula(), a.getNombre())));
		dash.getLimpiezas().stream().forEach(a -> resumen.add(new ResumenHomieDto(a.getCedula(), a.getNombre())));
		dash.getCalificacion().stream().forEach(a -> resumen.add(new ResumenHomieDto(a.getCedula(), a.getNombre())));

	//	List<ResumenHomieDto> res = (List<ResumenHomieDto>) resumen.stream().sorted();

		 Map<String, ResumenHomieDto> mapPersonas = new HashMap<String, ResumenHomieDto>();
		 
		 for(ResumenHomieDto var: resumen) {
		 mapPersonas.put(var.getCedula(), var);
		 }
		 
		 List<ResumenHomieDto> listaLimpia= new ArrayList <>();
		 
		 for(Entry<String, ResumenHomieDto> p: mapPersonas.entrySet()) {
			 listaLimpia.add(p.getValue());
			 
		 }

		
		listaLimpia.stream().forEach(a -> a.setDinero(agregarCaracteristica(a.getCedula(), dash.getDinero())));
		listaLimpia.stream().forEach(a -> a.setCalificacion(agregarCaracteristica(a.getCedula(), dash.getCalificacion())));
		listaLimpia.stream().forEach(a -> a.setLimpiezas(agregarCaracteristica(a.getCedula(), dash.getLimpiezas())));

		
		
		
		return listaLimpia;

	}

	private double agregarCaracteristica(String cedula, List<HomieCaracteristica> res) {
		double dinero = 0;
		Optional<HomieCaracteristica> dinero1 = res.stream().filter(a -> a.getCedula().equals(cedula)).findFirst();
		if (dinero1.get().getCantidad() != null) {
			dinero = dinero1.get().getCantidad();
		}
		return dinero;
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
				.map(e -> e.getValue().stream()
						.reduce((f1, f2) -> new HomieCaracteristica(f1.getCedula(), f1.getNombre(),
								ManejoDecimal.truncar((f1.getCantidad() + f2.getCantidad())))))
				.map(f -> f.get()).collect(Collectors.toList());

		return transform;

	}

	private double valorPedido(HoPedido pedido) {
		double var = 0;
		if (pedido.getPeTipo().equals(TipoPedido.PRINCIPAL.getKey())) {
			if (pedido.getPedidosDependientes().size() > 0) {
				int cantidad = pedido.getPedidosDependientes().size();
				var = pedido.getPeValor() / (cantidad + 1);
			} else {
				var = pedido.getPeValor();
			}
		}
		if (pedido.getPeTipo().equals(TipoPedido.PLAN.getKey())) {
			HoPedido pedPadre = pedido.getHoPedidoPadre();
			var = pedPadre.getPeValor() / (pedPadre.getPedidosDependientes().size() + 1);
		}

		if (pedido.getHoHomieList() != null) {
			float cantHomies = pedido.getHoHomieList().stream().filter(a -> a.isHoPeStatus() == true).count();
			if (cantHomies != 0) {
				var = var / cantHomies;
			}
		}

		if (var < 0) {
			return 0;
		}
		return ManejoDecimal.truncar(var);
	}

}
