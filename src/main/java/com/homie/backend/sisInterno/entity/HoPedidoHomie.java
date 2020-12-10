package com.homie.backend.sisInterno.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class HoPedidoHomie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer hoPeHoId;
	
	@Column(scale = 2)
	private Double hoPeHoCalificacion;
	
	@Column
	private boolean hoPeStatus;
	
	@ManyToOne
	@JoinColumn(name="ho_homie")
	private HoHomie hoHomie;
		

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="ho_pedido" ) 
	private HoPedido hoPedido;
	
	
	
	

	public HoPedidoHomie() {
		super();
	}



	public HoPedidoHomie(HoHomie hoHomie, HoPedido hoPedido,boolean hoPeStatus ) {
		super();
		
		this.hoHomie = hoHomie;
		this.hoPedido = hoPedido;
		this.hoPeStatus = hoPeStatus;
	}



	public Integer getHoPeHoId() {
		return hoPeHoId;
	}

	public void setHoPeHoId(Integer hoPeHoId) {
		this.hoPeHoId = hoPeHoId;
	}

	public Double getHoPeHoCalificacion() {
		return hoPeHoCalificacion;
	}

	public void setHoPeHoCalificacion(Double hoPeHoCalificacion) {
		this.hoPeHoCalificacion = hoPeHoCalificacion;
	}

	public HoHomie getHoHomie() {
		return hoHomie;
	}

	public void setHoHomie(HoHomie hoHomie) {
		this.hoHomie = hoHomie;
	}

	public HoPedido getHoPedido() {
		return hoPedido;
	}

	public void setHoPedido(HoPedido hoPedido) {
		this.hoPedido = hoPedido;
	}

	public boolean isHoPeStatus() {
		return hoPeStatus;
	}

	public void setHoPeStatus(boolean hoPeStatus) {
		this.hoPeStatus = hoPeStatus;
	}


	
	
	
	
	
	

}
