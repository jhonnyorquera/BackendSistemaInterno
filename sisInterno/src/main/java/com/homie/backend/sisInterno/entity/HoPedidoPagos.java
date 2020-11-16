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
public class HoPedidoPagos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ppPagoId;
	
	@Column(length = 50)
	private String ppFormaPago;
	
	
	@Column(length = 100)
	private String ppComentario;
	
	
	@Column(scale = 2)
	private Double ppValor;
	
	@Column
	private boolean ppEstado;
	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="ho_pedido" ) 
	private HoPedido hoPedido;
	
	
	
	
		
	public HoPedidoPagos() {
		super();
	}





	





	public HoPedidoPagos(HoPedido hoPedido) {
		super();
		this.hoPedido = hoPedido;
	}











	public Integer getPpPagoId() {
		return ppPagoId;
	}





	public void setPpPagoId(Integer ppPagoId) {
		this.ppPagoId = ppPagoId;
	}





	public String getPpFormaPago() {
		return ppFormaPago;
	}





	public void setPpFormaPago(String ppFormaPago) {
		this.ppFormaPago = ppFormaPago;
	}





	public Double getPpValor() {
		return ppValor;
	}





	public void setPpValor(Double ppValor) {
		this.ppValor = ppValor;
	}





	public HoPedido getHoPedido() {
		return hoPedido;
	}





	public void setHoPedido(HoPedido hoPedido) {
		this.hoPedido = hoPedido;
	}





	public String getPpComentario() {
		return ppComentario;
	}





	public void setPpComentario(String ppComentario) {
		this.ppComentario = ppComentario;
	}





	public boolean isPpEstado() {
		return ppEstado;
	}





	public void setPpEstado(boolean ppEstado) {
		this.ppEstado = ppEstado;
	}




	
	
	

}
