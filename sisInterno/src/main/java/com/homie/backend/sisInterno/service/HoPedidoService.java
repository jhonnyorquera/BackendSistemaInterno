package com.homie.backend.sisInterno.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homie.backed.sisInterno.enums.TipoPedido;
import com.homie.backend.sisInterno.dto.CrearPedidoRequestDto;
import com.homie.backend.sisInterno.entity.HoCatalogo;
import com.homie.backend.sisInterno.entity.HoHomie;
import com.homie.backend.sisInterno.entity.HoPedido;
import com.homie.backend.sisInterno.entity.HoPedidoHomie;
import com.homie.backend.sisInterno.entity.HoPedidoServicio;
import com.homie.backend.sisInterno.repositories.HoClienteRepository;
import com.homie.backend.sisInterno.repositories.HoHomieRepository;
import com.homie.backend.sisInterno.repositories.HoPedidoRepository;


@Service
public class HoPedidoService {
	private HoPedidoRepository hoPedidoRepository;

	@Autowired
	private HoHomieRepository hoHomieRepository;

	@Autowired
	private HoClienteRepository hoClienteRepository;


	public HoPedidoService(HoPedidoRepository hoPedidoRepository) {
		this.hoPedidoRepository = hoPedidoRepository;
	}

	public String guardarPedido(CrearPedidoRequestDto entidad) {

		String codigoPedido = null;
		// crearPedido Principal
		HoPedido pedido = new HoPedido();
		pedido.setPeCantidadHoras(entidad.getPeCantidadHoras());
		// pedido.setPeFechaPedido(entidad.getPeFechaPedido());
		pedido.setPeObservacion(entidad.getPeObservacion());		
		pedido.setPeEstado(entidad.getPeEstado());
		pedido.setPeCodigo("PR"+generarCodigoPedido());
		pedido.setPeDireccion(entidad.getPeDireccion());
		pedido.setPeFechaCreacion(new Date());
		pedido.setHoCliente(hoClienteRepository.findByClId(entidad.getPeCliente()));
		pedido.setPeFechaPedido(entidad.getPeFechasPedido().get(0));

		// asigna pedido a servcios
		List<HoPedidoServicio> ps = new ArrayList<>();
		for (HoCatalogo var : entidad.getPeServicios()) {
			ps.add(new HoPedidoServicio(var.getSeNombre(),var.getSeCantidad(), var.getSeValor(), pedido));
		}
		pedido.setHoPedidoServicioList(ps);
		pedido.setHoPedidoPagoList(entidad.getPePagos());
		pedido.setPeValor(entidad.getPeServicios().stream().mapToDouble(o-> o.getSeValor()).sum());
		// asigna pedido a pagos
		entidad.getPePagos().stream().forEach((a) -> a.setHoPedido(pedido));
		//agrega lista de servicios por homie
		pedido.setHoHomieList(crearListaServiciosXHomie(entidad.getCedulasHomies(), pedido));
		pedido.setPeTipo(TipoPedido.PRINCIPAL.getKey());
		
		// guarda pedido
		HoPedido hoPedidoGuardado = new HoPedido();
		hoPedidoGuardado = hoPedidoRepository.save(pedido);
		codigoPedido = hoPedidoGuardado.getPeCodigo();
		
		
         		
		List<HoPedido> listaPedidods = new ArrayList<>();

		if (entidad.getPeFechasPedido().size() > 1) {
			entidad.getPeFechasPedido().remove(0);
			for (Date var : entidad.getPeFechasPedido()) {
				HoPedido auxPedido = new HoPedido();
				auxPedido = pedido;
				auxPedido.setPeFechaPedido(var);
				auxPedido.setPeCodigo("PL"+this.generarCodigoPedido());
				auxPedido.setHoPedidoPadre(hoPedidoGuardado);
				auxPedido.setHoPedidoPagoList(null);
				auxPedido.setPeValor(null);
				auxPedido.setPeTipo(TipoPedido.PLAN.getKey());
				hoPedidoGuardado = hoPedidoRepository.save(auxPedido);
				listaPedidods.add(auxPedido);
			}
		}
		return codigoPedido;
	}

	
/**
 * Crea lista de pedidosHomie buscando los homies con la cedula de identidad y creando entidadees
 * @param homies lista de homies
 * @param pedido lista de pedidos
 * @return lista completa
 */
	private List<HoPedidoHomie> crearListaServiciosXHomie(List<String> homies, HoPedido pedido) {
		// guardar pedido Servicio;
		List<HoHomie> listaHomies = new ArrayList<>();
		List<HoPedidoHomie> pedidosPorHomie = new ArrayList<>();
		if (!homies.isEmpty()) {
			for (String var : homies) {
				listaHomies.add(hoHomieRepository.findByHoCedula(var));
			}
			for (HoHomie varDos : listaHomies) {
				pedidosPorHomie.add(new HoPedidoHomie(varDos, pedido));
			}
		}
		return pedidosPorHomie;

	}

	private String generarCodigoPedido() {
		String codigo = null;
		Calendar fechaInicio = Calendar.getInstance();
		fechaInicio.set(Calendar.DAY_OF_MONTH, 1);
		Calendar fechaFin = Calendar.getInstance();

		fechaFin.set(Calendar.DAY_OF_MONTH, 1);
		fechaFin.add(Calendar.MONTH, 1);
		fechaFin.add(Calendar.DAY_OF_YEAR, -1);

		Long cantidad = hoPedidoRepository.findCantidad(fechaInicio.getTime(), fechaFin.getTime());
		cantidad = cantidad + 1;
		
		
		codigo =fechaInicio.get(Calendar.YEAR) +"M"+ fechaInicio.get(Calendar.MONTH) + "N" + cantidad.toString();
		return codigo;

	}

}
