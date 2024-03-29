package com.homie.backend.sisInterno.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class HoComentario {
	
	@Id
	@Temporal(TemporalType.TIMESTAMP)
	private Date obFechaComentario;
	
	@Column(length = 300)
	private String obComentario;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="ho_pedido" ) 
	private HoPedido hoPedido;

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

	public HoPedido getHoPedido() {
		return hoPedido;
	}

	public void setHoPedido(HoPedido hoPedido) {
		this.hoPedido = hoPedido;
	}
	
	
	
	
	

}
