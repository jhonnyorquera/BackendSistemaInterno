package com.homie.backend.sisInterno.dto;

public class PedidoServicioDto {
	
	private Integer psCodigo;
	private String psNombre;
	private Double psCantidad;
	private double psValor;
	private String hoPedidoCod;
	
	
	
	public Double getPsCantidad() {
		return psCantidad;
	}
	public void setPsCantidad(Double psCantidad) {
		this.psCantidad = psCantidad;
	}
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
	public double getPsValor() {
		return psValor;
	}
	public void setPsValor(double psValor) {
		this.psValor = psValor;
	}
	public String getHoPedidoCod() {
		return hoPedidoCod;
	}
	public void setHoPedidoCod(String hoPedidoCod) {
		this.hoPedidoCod = hoPedidoCod;
	}
	
	
	

}
