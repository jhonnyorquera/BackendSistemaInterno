package com.homie.backend.sisInterno.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

import org.springframework.stereotype.Service;

import com.homie.backend.sisInterno.dto.ListaPedidosDto;
import com.homie.backend.sisInterno.dto.PedidoListDto;
import com.homie.backend.sisInterno.dto.PedidoListDtoResponse;
import com.homie.backend.sisInterno.repositories.HoPedidoHomieRepository;
import com.homie.backend.sisInterno.utils.ManejoFechas;
import com.sun.el.stream.Optional;

@Service
public class HoPedidoHomieService {
	private HoPedidoHomieRepository hoPedidoHomieRepository;

	public HoPedidoHomieService(HoPedidoHomieRepository hoPedidoHomieRepository) {
		this.hoPedidoHomieRepository = hoPedidoHomieRepository;
	}

	public List<PedidoListDtoResponse> getPedidosPorClienteFecha(Date fecha) {
		if (fecha == null) {
			fecha = new Date();
		}
		List<PedidoListDto> listaTotal = this.hoPedidoHomieRepository
				.getPedidosPorClienteFecha(ManejoFechas.quitarHora(fecha));

		return listaPedidosHomie(
				this.hoPedidoHomieRepository.getPedidosPorClienteFecha(ManejoFechas.quitarHora(fecha)));
	}

	private List<PedidoListDtoResponse> listaPedidosHomie(List<PedidoListDto> listaTotal) {

		List<PedidoListDtoResponse> listaResponse = new ArrayList<>();

		PedidoListDtoResponse pedidoBandera = creaObjetoResponse(listaTotal.get(0));
		List<ListaPedidosDto> listaBandera = new ArrayList<>();
		
		for(PedidoListDto var : listaTotal) {
			System.out.println("cedula"+var.getPlHoCedula());
			
		}

		for (PedidoListDto var : listaTotal) {
			System.out.println("for "+var.getPlHoCedula()+" "+var.getPlHoNombre()+" "+var.getPlHoTelefono()+" "+var.getPlHoModalidad()+" "+var.getPlNombreCliente()+" "+var.getPlCantidadHoras()+" "+var.getPlEstado());
			System.out.println("pedidoBandera.gethHoCedula(): "+pedidoBandera.gethHoCedula()+ " var.getPlHoCedula() "+var.getPlHoCedula());
			if (pedidoBandera.gethHoCedula().equals(var.getPlHoCedula()) ) {
				System.out.println("Añade lista ");
							listaBandera.add(crearElemento(var));

			} // crea objeto
			else {
				System.out.println("Añade elemento");
				pedidoBandera.setPedidos(listaBandera);
				
				listaResponse.add(pedidoBandera);
				pedidoBandera = new PedidoListDtoResponse();
				listaBandera = new ArrayList<>();
				listaBandera.add(crearElemento(var));
				pedidoBandera = creaObjetoResponse(var);

			}

		}
		if(!pedidoBandera.gethHoCedula().isEmpty() && !listaBandera.isEmpty())
		{
			pedidoBandera.setPedidos(listaBandera);
			listaResponse.add(pedidoBandera);
		}

		return listaResponse;

	}

	private PedidoListDtoResponse creaObjetoResponse(PedidoListDto var) {
		PedidoListDtoResponse pedido = new PedidoListDtoResponse();
		System.out.println("entra Response: "+var.getPlHoCedula()+" "+var.getPlHoNombre()+" "+var.getPlHoTelefono()+" "+var.getPlHoModalidad());
		pedido.sethHoCedula(var.getPlHoCedula());
		pedido.setHlHoNombre(var.getPlHoNombre());
		pedido.setHlHoTelefono(var.getPlHoTelefono());
		pedido.setHlHoModalidad(var.getPlHoModalidad());
		return pedido;

	}

	private ListaPedidosDto crearElemento(PedidoListDto var) {
		System.out.println("entra Lista: "+var.getPlNombreCliente()+" "+var.getPlCantidadHoras()+" "+var.getPlEstado());
		
		ListaPedidosDto list = new ListaPedidosDto();
		list.setLpNombreCliente(var.getPlNombreCliente());
		list.setLpCantidadHoras(var.getPlCantidadHoras());
		list.setLpEstado(var.getPlEstado());
		list.setLpFechaPedido(var.getPlFechaPedido());
		return list;
	}

}
