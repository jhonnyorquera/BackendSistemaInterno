package com.homie.backend.sisInterno.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homie.backend.sisInterno.dto.PedidoServicioDto;
import com.homie.backend.sisInterno.entity.HoPedidoServicio;
import com.homie.backend.sisInterno.repositories.HoPedidoRepository;
import com.homie.backend.sisInterno.repositories.HoPedidoServicioRepository;

@Service
public class HoPedidoServicioService {
	private HoPedidoServicioRepository hoPedidoServicioRepository;

	@Autowired
	private HoPedidoRepository hoPedidoRepository;

	public HoPedidoServicioService(HoPedidoServicioRepository hoPedidoServicioRepository) {
		this.hoPedidoServicioRepository = hoPedidoServicioRepository;
	}

	public HoPedidoServicio crearPedido(PedidoServicioDto pedidoDto) {
		HoPedidoServicio pedidoServicio = llenarPedido(pedidoDto);
		pedidoServicio.setHoPedido(this.hoPedidoRepository.findByPeCodigo(pedidoDto.getHoPedidoCod()));
		return this.hoPedidoServicioRepository.save(pedidoServicio);
	}

	public HoPedidoServicio edit(PedidoServicioDto pedidoDto) {

		HoPedidoServicio var = llenarPedido(pedidoDto);
		var.setHoPedido(this.hoPedidoRepository.findByPeCodigo(pedidoDto.getHoPedidoCod()));
		var.setPsCodigo(this.hoPedidoServicioRepository.findByPsCodigo(pedidoDto.getPsCodigo()).getPsCodigo());
		return this.hoPedidoServicioRepository.save(var);

	}

	private HoPedidoServicio llenarPedido(PedidoServicioDto pedidoDto) {

		HoPedidoServicio var = new HoPedidoServicio();

		var.setPsCantidad(pedidoDto.getPsCantidad());
		var.setPsNombre(pedidoDto.getPsNombre());
		var.setPsValor(pedidoDto.getPsValor());

		return var;
	}

}
