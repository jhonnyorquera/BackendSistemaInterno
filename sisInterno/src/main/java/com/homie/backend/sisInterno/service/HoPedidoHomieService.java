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
import com.homie.backend.sisInterno.dto.BusquedaDto;
import com.homie.backend.sisInterno.dto.BusquedaResponseDto;
import com.homie.backend.sisInterno.dto.HoPedidoHomieCrearDto;
import com.homie.backend.sisInterno.dto.ListaPedidosDto;
import com.homie.backend.sisInterno.dto.PedidoListDto;
import com.homie.backend.sisInterno.dto.PedidoListDtoResponse;
import com.homie.backend.sisInterno.entity.HoHomie;
import com.homie.backend.sisInterno.entity.HoPedido;
import com.homie.backend.sisInterno.entity.HoPedidoHomie;
import com.homie.backend.sisInterno.repositories.HoHomieRepository;
import com.homie.backend.sisInterno.repositories.HoPedidoHomieRepository;
import com.homie.backend.sisInterno.repositories.HoPedidoRepository;
import com.homie.backend.sisInterno.utils.ManejoFechas;
import com.sun.el.stream.Optional;

@Service
public class HoPedidoHomieService {
	private HoPedidoHomieRepository hoPedidoHomieRepository;

	@Autowired
	private HoHomieRepository hoHomieRepository;

	@Autowired
	private HoPedidoRepository hoPedidoRepository;

	public HoPedidoHomieService(HoPedidoHomieRepository hoPedidoHomieRepository) {
		this.hoPedidoHomieRepository = hoPedidoHomieRepository;
	}

	public List<HoPedidoHomie> buscarPedidos() {
		return (List<HoPedidoHomie>) hoPedidoHomieRepository.findAll();
	}

	public List<PedidoListDtoResponse> getPedidosPorClienteFecha(Date fecha) {
		if (fecha == null) {
			fecha = new Date();
		}

		return homies(fecha);
	}

	private List<PedidoListDtoResponse> homies(Date fecha) {
		List<PedidoListDtoResponse> listaResponse = new ArrayList<>();

		listaResponse.addAll(listaPedidosHomie(
				this.hoPedidoHomieRepository.getPedidosPorClienteFecha(ManejoFechas.quitarHora(fecha))));

		return listaResponse;

	}

	private List<PedidoListDtoResponse> listaPedidosHomie(List<PedidoListDto> listaTotal) {

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

	public HoPedidoHomie update(HoPedidoHomie entity) {
		HoPedidoHomie pedido = new HoPedidoHomie();
		pedido = hoPedidoHomieRepository.findByHoPeHoId(entity.getHoPeHoId());
		pedido.setHoPeHoCalificacion(entity.getHoPeHoCalificacion());
		pedido.setHoPeStatus(entity.isHoPeStatus());
		return hoPedidoHomieRepository.save(pedido);
	}

	public List<HoPedidoHomie> crear(HoPedidoHomieCrearDto entity) {
		// buscar homie

		HoPedido pedido = new HoPedido();
		pedido = hoPedidoRepository.findByPeCodigo(entity.getPeCodigo());
		List<HoHomie> homies = new ArrayList<>();
		for (String var : entity.getCedulaHomies()) {
			homies.add(this.hoHomieRepository.findByHoCedula(var));
		}
		return crearPedidoHomie(homies, pedido);
	}

	private List<HoPedidoHomie> crearPedidoHomie(List<HoHomie> homies, HoPedido pedidos) {
		for (HoHomie hom : homies) {			
			if (this.hoPedidoHomieRepository.getByPedidoHomie(pedidos, hom) == null) {
				HoPedidoHomie var = new HoPedidoHomie();
				var.setHoHomie(hom);
				var.setHoPedido(pedidos);
				var.setHoPeStatus(true);
				this.hoPedidoHomieRepository.save(var);
			}
		}

		return this.hoPedidoHomieRepository.findByHoPedido(pedidos);
	}

}
