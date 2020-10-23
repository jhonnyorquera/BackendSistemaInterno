package com.homie.backend.sisInterno.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homie.backed.sisInterno.enums.StatusHomie;
import com.homie.backend.sisInterno.dto.ListaPedidosDto;
import com.homie.backend.sisInterno.dto.PedidoListDto;
import com.homie.backend.sisInterno.dto.PedidoListDtoResponse;
import com.homie.backend.sisInterno.repositories.HoHomieRepository;
import com.homie.backend.sisInterno.repositories.HoPedidoHomieRepository;
import com.homie.backend.sisInterno.utils.ManejoFechas;
import com.sun.el.stream.Optional;

@Service
public class HoPedidoHomieService {
	private HoPedidoHomieRepository hoPedidoHomieRepository;

	@Autowired
	private HoHomieRepository hoHomieRepository;

	public HoPedidoHomieService(HoPedidoHomieRepository hoPedidoHomieRepository) {
		this.hoPedidoHomieRepository = hoPedidoHomieRepository;
	}

	public List<PedidoListDtoResponse> getPedidosPorClienteFecha(Date fecha) {
		if (fecha == null) {
			fecha = new Date();
		}

		return homies(fecha);
	}

	private List<PedidoListDtoResponse> homies(Date fecha) {
		List<PedidoListDtoResponse> listaResponse = new ArrayList<>();
		
		System.out.println("fecha: "+ManejoFechas.quitarHora(fecha));
		listaResponse.addAll(listaPedidosHomie(
				this.hoPedidoHomieRepository.getPedidosPorClienteFecha(ManejoFechas.quitarHora(fecha))));

		return listaResponse;

	}

	private List<PedidoListDtoResponse> listaPedidosHomie(List<PedidoListDto> listaTotal) {
		
	System.out.println("listado Tamaño"+listaTotal.size());
		listaTotal.stream().forEach(System.out::println);

		List<PedidoListDtoResponse> homiesCompletos = new ArrayList<>();
		homiesCompletos = hoPedidoHomieRepository.getHomiesByStatus(StatusHomie.HABILITADO.getKey());

		List<PedidoListDtoResponse> listaResponse = new ArrayList<>();

		if (!listaTotal.isEmpty()) {
			PedidoListDtoResponse pedidoBandera = creaObjetoResponse(listaTotal.get(0));
			List<ListaPedidosDto> listaBandera = new ArrayList<>();

			for (PedidoListDto var : listaTotal) {

				if (pedidoBandera.gethHoCedula().equals(var.getPlHoCedula())) {
					listaBandera.add(crearElemento(var));
				} else {
					pedidoBandera.setPedidos(listaBandera);
					listaResponse.add(pedidoBandera);
					pedidoBandera = new PedidoListDtoResponse();
					listaBandera = new ArrayList<>();
					listaBandera.add(crearElemento(var));
					pedidoBandera = creaObjetoResponse(var);

				}
				homiesCompletos.removeIf(
						(PedidoListDtoResponse empleado) -> (empleado.gethHoCedula().equals(var.getPlHoCedula())));

				if (!pedidoBandera.gethHoCedula().isEmpty() && !listaBandera.isEmpty()) {
					pedidoBandera.setPedidos(listaBandera);
					listaResponse.add(pedidoBandera);
				}

				homiesCompletos.add(pedidoBandera);
			}
		}
		return homiesCompletos;

	}

	private PedidoListDtoResponse creaObjetoResponse(PedidoListDto var) {
		PedidoListDtoResponse pedido = new PedidoListDtoResponse();
		pedido.sethHoCedula(var.getPlHoCedula());
		pedido.setHlHoNombre(var.getPlHoNombre());
		pedido.setHlHoTelefono(var.getPlHoTelefono());
		pedido.setHlHoModalidad(var.getPlHoModalidad());
		return pedido;

	}

	private ListaPedidosDto crearElemento(PedidoListDto var) {

		ListaPedidosDto list = new ListaPedidosDto();
		list.setLpNombreCliente(var.getPlNombreCliente());
		list.setLpCantidadHoras(var.getPlCantidadHoras());
		list.setLpEstado(var.getPlEstado());
		list.setLpFechaPedido(var.getPlFechaPedido());
		return list;
	}

}
