package com.homie.backend.sisInterno.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homie.backend.sisInterno.dto.CrearPedidoRequestDto;
import com.homie.backend.sisInterno.entity.HoCliente;
import com.homie.backend.sisInterno.entity.HoHomie;
import com.homie.backend.sisInterno.entity.HoPedido;
import com.homie.backend.sisInterno.entity.HoPedidoHomie;
import com.homie.backend.sisInterno.entity.HoPedidoServicio;
import com.homie.backend.sisInterno.repositories.HoClienteRepository;
import com.homie.backend.sisInterno.repositories.HoHomieRepository;
import com.homie.backend.sisInterno.repositories.HoPedidoHomieRepository;
import com.homie.backend.sisInterno.repositories.HoPedidoRepository;

@Service
public class HoPedidoService {
	private HoPedidoRepository hoPedidoRepository;

	@Autowired
	private HoHomieRepository hoHomieRepository;

	@Autowired
	private HoClienteRepository hoClienteRepository;

	@Autowired
	private HoPedidoHomieRepository hoPedidoHomieRepository;

	public HoPedidoService(HoPedidoRepository hoPedidoRepository) {
		this.hoPedidoRepository = hoPedidoRepository;
	}

	public String guardarPedido(CrearPedidoRequestDto entidad) {

		String codigoPedido = null;
		// crearPedido
		HoPedido pedido = new HoPedido();
		pedido.setPeCantidadHoras(entidad.getCantidadHoras());
		pedido.setPeFechaPedido(entidad.getFechaPedido());
		pedido.setPeObservacion(entidad.getObservacion());
		pedido.setPeValor(entidad.getValorServicio());
		pedido.setPeEstado(entidad.getEstadoPedido());
		pedido.setPeCodigo(generarCodigoPedido());
		pedido.setHoCliente(hoClienteRepository.findByClId(entidad.getIdCliente()));

		// asigna pedido a servcios
		for (HoPedidoServicio var : entidad.getServicios()) {
			var.setHoPedido(pedido);
		}

		pedido.setHoPedidoServicioList(entidad.getServicios());

		// buscar Cliente
		// HoCliente cliente = new HoCliente();
		// cliente = hoClienteRepository.findByClId(entidad.getIdCliente());

		// guarda pedido
		HoPedido hoPedidoGuardado = new HoPedido();

		hoPedidoGuardado = hoPedidoRepository.save(pedido);

		// guardar pedido Servicio;
		List<HoHomie> listaHomies = new ArrayList<>();
		if (!entidad.getCedulasHomies().isEmpty()) {

			for (String var : entidad.getCedulasHomies()) {
				listaHomies.add(hoHomieRepository.findByHoCedula(var));
			}

			for (HoHomie varDos : listaHomies) {
				hoPedidoHomieRepository.save(new HoPedidoHomie(varDos, hoPedidoGuardado));
			}

		}

		return codigoPedido;
	}

	private String generarCodigoPedido() {
		String codigo = null;
		Calendar fechaInicio = Calendar.getInstance();
		fechaInicio.set(Calendar.DAY_OF_MONTH, 1);

		Calendar fechaFin = fechaInicio;
		fechaFin.add(Calendar.MONTH, 1);
		fechaFin.add(Calendar.DAY_OF_YEAR, -1);

		Long cantidad = hoPedidoRepository.findCantidad(fechaInicio.getTime(), fechaFin.getTime());

		cantidad += 1;

		codigo = "PE" + fechaInicio.get(Calendar.YEAR)+fechaInicio.get(Calendar.MONTH)+"P"+cantidad.toString();
		return codigo;

	}

}
