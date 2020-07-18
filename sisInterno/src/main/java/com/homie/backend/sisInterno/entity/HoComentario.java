package com.homie.backend.sisInterno.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class HoComentario {
	
	@Id
	@Temporal(TemporalType.DATE)
	private Date obFechaComentario;
	
	@Column(length = 300)
	private String obComentario;
	
	@ManyToOne
	@JoinColumn(name="ho_pedido" ) 
	private HoPedido hoPedido;
	
	
	
	
	

}
