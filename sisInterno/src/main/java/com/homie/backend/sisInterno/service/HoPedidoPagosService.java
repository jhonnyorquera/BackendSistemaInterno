package com.homie.backend.sisInterno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homie.backend.sisInterno.dto.PedidoPagoDto;
import com.homie.backend.sisInterno.dto.SaldosPagoDto;
import com.homie.backend.sisInterno.entity.HoPedido;
import com.homie.backend.sisInterno.entity.HoPedidoPagos;
import com.homie.backend.sisInterno.repositories.HoPedidoPagosRepository;
import com.homie.backend.sisInterno.repositories.HoPedidoRepository;

@Service
public class HoPedidoPagosService {
	private HoPedidoPagosRepository hoPedidoPagosRepository;

	@Autowired
	private HoPedidoRepository hoPedidoRepository;

	public HoPedidoPagosService(HoPedidoPagosRepository hoPedidoPagosRepository) {
		this.hoPedidoPagosRepository = hoPedidoPagosRepository;
	}

	public HoPedidoPagos edit(HoPedidoPagos entity) {
		HoPedidoPagos pedido = hoPedidoPagosRepository.findByPpPagoId(entity.getPpPagoId());
		pedido.setPpComentario(entity.getPpComentario());
		pedido.setPpEstado(entity.isPpEstado());
		pedido.setPpFormaPago(entity.getPpFormaPago());
		pedido.setPpValor(entity.getPpValor());
		return this.hoPedidoPagosRepository.save(pedido);
	}

	public HoPedidoPagos guardar(PedidoPagoDto entity) {
		// consulta el pedido

		HoPedido pedido = this.hoPedidoRepository.findByPeCodigo(entity.getHoPedidoCodigo());
		HoPedidoPagos pedidoPagos = new HoPedidoPagos();

		pedidoPagos.setHoPedido(pedido);
		pedidoPagos.setPpComentario(entity.getPpComentario());
		pedidoPagos.setPpEstado(entity.isPpEstado());
		pedidoPagos.setPpFormaPago(entity.getPpFormaPago());
		pedidoPagos.setPpValor(entity.getPpValor());
		return this.hoPedidoPagosRepository.save(pedidoPagos);
	}
	
	public List<SaldosPagoDto>  saldosPago(){
		
		return this.hoPedidoRepository.saldosPago();
	}

}
