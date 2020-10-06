package com.homie.backend.sisInterno.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class HoPedidoHomie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer hoPeHoId;
	
	@Column(scale = 2)
	private Double hoPeHoCalificacion;
	
	
	@ManyToOne( fetch=FetchType.LAZY )
	@JoinColumn(name="ho_homie")
	@JsonIgnore
	private HoHomie hoHomie;
		
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="ho_pedido" ) 
	private HoPedido hoPedido;

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
	
	
	
	
	
	

}
