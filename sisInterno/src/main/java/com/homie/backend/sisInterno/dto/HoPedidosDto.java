package com.homie.backend.sisInterno.dto;

import java.util.Date;

public class HoPedidosDto {
	private String peCodigo;
	private Date peFecha;
	private Date peEstado;
	
	
	public String getPeCodigo() {
		return peCodigo;
	}
	public void setPeCodigo(String peCodigo) {
		this.peCodigo = peCodigo;
	}
	public Date getPeFecha() {
		return peFecha;
	}
	public void setPeFecha(Date peFecha) {
		this.peFecha = peFecha;
	}
	public Date getPeEstado() {
		return peEstado;
	}
	public void setPeEstado(Date peEstado) {
		this.peEstado = peEstado;
	}
	
	
	

}
