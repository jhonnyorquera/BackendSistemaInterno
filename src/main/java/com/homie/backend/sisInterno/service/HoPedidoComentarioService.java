package com.homie.backend.sisInterno.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.homie.backend.sisInterno.dto.ComentarioPedidoDto;
import com.homie.backend.sisInterno.entity.HoComentario;
import com.homie.backend.sisInterno.entity.HoPedido;
import com.homie.backend.sisInterno.repositories.HoComentarioRepository;
import com.homie.backend.sisInterno.repositories.HoPedidoRepository;

@Service
public class HoPedidoComentarioService {
	private HoComentarioRepository hoComentarioRepository;

	@Autowired
	private HoPedidoRepository hoPedidoRepository;

	public HoPedidoComentarioService(HoComentarioRepository hoComentarioRepository) {
		this.hoComentarioRepository = hoComentarioRepository;
	}

	public HoComentario edit(ComentarioPedidoDto entity) {
		HoComentario item = new HoComentario();
		item = hoComentarioRepository.findByObFechaComentario(entity.getObFechaComentario());
		item.setObComentario(entity.getObComentario());
		 return this.hoComentarioRepository.save(item);

	}

	public HoComentario guardar(ComentarioPedidoDto entity) {
		// consulta el pedido
		HoPedido pedido = this.hoPedidoRepository.findByPeCodigo(entity.getHoPedidoCod());
		HoComentario comentario = new HoComentario();
		comentario.setHoPedido(pedido);
		comentario.setObFechaComentario(new Date());
		comentario.setObComentario(entity.getObComentario());
		return this.hoComentarioRepository.save(comentario);
	}

}
