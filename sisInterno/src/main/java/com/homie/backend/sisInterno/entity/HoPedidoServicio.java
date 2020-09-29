package com.homie.backend.sisInterno.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HoPedidoServicio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer psCodigo;
	
	@Column(length = 300)
	private String psNombre;
	
	
	private Integer psCantidad;
	
	@Column(scale = 2)
	private Double psValor;
	
	@ManyToOne
	@JoinColumn(name="ho_pedido" ) 
	private HoPedido hoPedido;

	public Integer getPsCodigo() {
		return psCodigo;
	}

	public void setPsCodigo(Integer psCodigo) {
		this.psCodigo = psCodigo;
	}

	public String getPsNombre() {
		return psNombre;
	}

	public void setPsNombre(String psNombre) {
		this.psNombre = psNombre;
	}

	public Integer getPsCantidad() {
		return psCantidad;
	}

	public void setPsCantidad(Integer psCantidad) {
		this.psCantidad = psCantidad;
	}

	public Double getPsValor() {
		return psValor;
	}

	public void setPsValor(Double psValor) {
		this.psValor = psValor;
	}

	public HoPedido getHoPedido() {
		return hoPedido;
	}

	public void setHoPedido(HoPedido hoPedido) {
		this.hoPedido = hoPedido;
	}
	
	
		
	
	
	
	
	
	

}
