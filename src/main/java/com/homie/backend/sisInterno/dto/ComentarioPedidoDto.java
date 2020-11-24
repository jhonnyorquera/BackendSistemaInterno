package com.homie.backend.sisInterno.dto;

import java.util.Date;

public class ComentarioPedidoDto {
	
	private Date obFechaComentario;
	private String obComentario;
	private String hoPedidoCod;
	
	
	
	public Date getObFechaComentario() {
		return obFechaComentario;
	}
	public void setObFechaComentario(Date obFechaComentario) {
		this.obFechaComentario = obFechaComentario;
	}
	public String getObComentario() {
		return obComentario;
	}
	public void setObComentario(String obComentario) {
		this.obComentario = obComentario;
	}
	public String getHoPedidoCod() {
		return hoPedidoCod;
	}
	public void setHoPedidoCod(String hoPedidoCod) {
		this.hoPedidoCod = hoPedidoCod;
	}
	
	
	

	

}
