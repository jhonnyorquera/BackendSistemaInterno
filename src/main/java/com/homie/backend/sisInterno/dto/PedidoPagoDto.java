package com.homie.backend.sisInterno.dto;


public class PedidoPagoDto {

	private String ppFormaPago;

	private String ppComentario;

	private Double ppValor;

	private boolean ppEstado;

	private String hoPedidoCodigo;
	
	public PedidoPagoDto() {
		super();
	}

	public String getPpFormaPago() {
		return ppFormaPago;
	}

	public void setPpFormaPago(String ppFormaPago) {
		this.ppFormaPago = ppFormaPago;
	}

	public String getPpComentario() {
		return ppComentario;
	}

	public void setPpComentario(String ppComentario) {
		this.ppComentario = ppComentario;
	}

	public Double getPpValor() {
		return ppValor;
	}

	public void setPpValor(Double ppValor) {
		this.ppValor = ppValor;
	}

	public boolean isPpEstado() {
		return ppEstado;
	}

	public void setPpEstado(boolean ppEstado) {
		this.ppEstado = ppEstado;
	}

	public String getHoPedidoCodigo() {
		return hoPedidoCodigo;
	}

	public void setHoPedidoCodigo(String hoPedidoCodigo) {
		this.hoPedidoCodigo = hoPedidoCodigo;
	}
	
	
}
