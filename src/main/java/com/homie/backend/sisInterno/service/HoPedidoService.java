package com.homie.backend.sisInterno.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homie.backed.sisInterno.enums.TipoPedido;
import com.homie.backend.sisInterno.dto.BusquedaDto;
import com.homie.backend.sisInterno.dto.BusquedaDtoIn;
import com.homie.backend.sisInterno.dto.BusquedaResponseDto;
import com.homie.backend.sisInterno.dto.CrearPedidoRequestDto;
import com.homie.backend.sisInterno.entity.HoCatalogo;
import com.homie.backend.sisInterno.entity.HoHomie;
import com.homie.backend.sisInterno.entity.HoPedido;
import com.homie.backend.sisInterno.entity.HoPedidoHomie;
import com.homie.backend.sisInterno.entity.HoPedidoServicio;
import com.homie.backend.sisInterno.repositories.HoClienteRepository;
import com.homie.backend.sisInterno.repositories.HoHomieRepository;
import com.homie.backend.sisInterno.repositories.HoPedidoRepository;
import com.homie.backend.sisInterno.utils.ManejoFechas;

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

	public List<HoPedido> buscarPedidos() {
		return (List<HoPedido>) this.hoPedidoRepository.findAll();
	}

	public String guardarPedido(CrearPedidoRequestDto entidad) {

		String codigoPedido = null;
		// crearPedido Principal
		HoPedido pedido = new HoPedido();
		pedido.setPeCantidadHoras(entidad.getPeCantidadHoras());
		// pedido.setPeFechaPedido(entidad.getPeFechaPedido());
		pedido.setPeObservacion(entidad.getPeObservacion());
		pedido.setPeEstado(entidad.getPeEstado());
		pedido.setPeCodigo("PR" + generarCodigoPedido(entidad.getPeFechaPedido().get(0)));
		pedido.setPeDireccion(entidad.getPeDireccion());
		pedido.setPeFechaCreacion(new Date());
		pedido.setHoCliente(hoClienteRepository.findByClId(entidad.getPeCliente()));
		pedido.setPeFechaPedido(entidad.getPeFechaPedido().get(0));

		// asigna pedido a servcios
		List<HoPedidoServicio> ps = new ArrayList<>();
		for (HoCatalogo var : entidad.getPeServicios()) {
			ps.add(new HoPedidoServicio(var.getSeNombre(), var.getSeCantidad(), var.getSeValor(), pedido));
		}
		pedido.setHoPedidoServicioList(ps);
		pedido.setHoPedidoPagoList(entidad.getPePagos());

		pedido.setPeValor(entidad.getPeValor());
		// asigna pedido a pagos
		entidad.getPePagos().stream().forEach((a) -> a.setHoPedido(pedido));
		entidad.getPePagos().stream().forEach((a) -> a.setPpEstado(true));
		// agrega lista de servicios por homie
		pedido.setHoHomieList(crearListaServiciosXHomie(entidad.getCedulasHomies(), pedido));
		pedido.setPeTipo(TipoPedido.PRINCIPAL.getKey());

		// guarda pedido
		HoPedido hoPedidoGuardado = new HoPedido();
		hoPedidoGuardado = hoPedidoRepository.save(pedido);
		codigoPedido = hoPedidoGuardado.getPeCodigo();

		List<HoPedido> listaPedidods = new ArrayList<>();

		if (entidad.getPeFechaPedido().size() > 1) {
			entidad.getPeFechaPedido().remove(0);
			for (Date var : entidad.getPeFechaPedido()) {
				HoPedido auxPedido = new HoPedido();
				auxPedido = pedido;
				auxPedido.setPeFechaPedido(var);
				auxPedido.setPeCodigo("PL" + this.generarCodigoPedido(var));
				auxPedido.setHoPedidoPadre(hoPedidoRepository.findByPeCodigo(codigoPedido));
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
	 * Crea lista de pedidosHomie buscando los homies con la cedula de identidad y
	 * creando entidadees
	 * 
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
				pedidosPorHomie.add(new HoPedidoHomie(varDos, pedido, true));
			}
		}
		return pedidosPorHomie;

	}

	private String generarCodigoPedido(Date fecha) {
		String codigo = null;
		Calendar fecha1 = Calendar.getInstance();
		fecha1.setTime(fecha);
		
		Long cantidad = hoPedidoRepository.findCantidad(
				ManejoFechas.primerDiaDelMes(ManejoFechas.quitarHora(fecha1.getTime())), 
				ManejoFechas.ultimoDiaDelMes(ManejoFechas.finDia((fecha1.getTime()))));
		cantidad = cantidad + 1;
		int mes=fecha1.get(Calendar.MONTH);
		mes=mes+1;

		codigo = fecha1.get(Calendar.YEAR) + "M" + mes + "N" + cantidad.toString();
		return codigo;

	}

	public HoPedido findPedidoById(String codigo) {
		return hoPedidoRepository.findByPeCodigo(codigo);

	}

	public HoPedido editar(HoPedido entity) {

		return hoPedidoRepository.save(entity);
	}

	public List<BusquedaResponseDto> buscarPedidos(BusquedaDto var) {

		List<BusquedaResponseDto> lista = new ArrayList<>();
		if (var.getCodigo().length() > 2) {
			lista = this.hoPedidoRepository.buscarPedidosXCodigo(var.getCodigo());
		} else {
			
			if (var.getFechaInicio() == null && var.getFechaFin() == null) {
				Calendar today = Calendar.getInstance();
				today.add(Calendar.MONTH, -1);
				var.setFechaInicio(ManejoFechas.quitarHora(today.getTime()));
				today.add(Calendar.MONTH, 2);
				var.setFechaFin(ManejoFechas.quitarHora(today.getTime()));

			}

			if (var.getFechaInicio() != null && var.getFechaFin() == null) {
				Calendar today =Calendar.getInstance();
				today.setTime(var.getFechaInicio());
				today.add(Calendar.MONTH, 2);
				var.setFechaFin(today.getTime());
			}
			
			if (var.getFechaInicio() == null && var.getFechaFin() != null) {
				Calendar today =Calendar.getInstance();
				today.setTime(var.getFechaFin());
				today.add(Calendar.MONTH, -2);
				var.setFechaInicio(today.getTime());
			}
			

			if(var.getCliente()== null) {
				var.setCliente("");				
			}
			if(var.getEstado() ==null) {
				var.setEstado("");
			}
			
			
			List<BusquedaDtoIn> busqueda = this.hoPedidoRepository.buscarPedidosXCamposInter("%"+var.getEstado()+"%", 
					"%"+var.getCliente()+"%", var.getFechaInicio(), var.getFechaFin());

			for (BusquedaDtoIn varAux : busqueda) {
				lista.add(crearObjeto(varAux));
			}

		}
		return lista;
	}

	private final BusquedaResponseDto crearObjeto(BusquedaDtoIn var) {

		BusquedaResponseDto aux = new BusquedaResponseDto();
		aux.setPeCodigo(var.getPeCodigo());
		aux.setClCliente(var.getClCliente());
		aux.setPeEstado(var.getPeEstado());
		
		aux.setPeCantidadHoras(var.getPeCantidadHoras());
		aux.setPePadre(var.getPePadre());
		aux.setPeTipo(var.getPeTipo());
		aux.setPeFecha(var.getPeFecha());

		return aux;
	}

}
