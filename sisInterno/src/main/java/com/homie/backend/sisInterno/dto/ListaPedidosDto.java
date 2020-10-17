package com.homie.backend.sisInterno.dto;

import java.util.Date;

public class ListaPedidosDto {
	
	private Date  lpFechaPedido;
	private Long lpCantidadHoras;
	private String lpNombreCliente;
	private String lpEstado;
	
	
	public ListaPedidosDto() {
		super();
	}
	
	public Date getLpFechaPedido() {
		return lpFechaPedido;
	}
	public void setLpFechaPedido(Date lpFechaPedido) {
		this.lpFechaPedido = lpFechaPedido;
	}
	public Long getLpCantidadHoras() {
		return lpCantidadHoras;
	}
	public void setLpCantidadHoras(Long lpCantidadHoras) {
		this.lpCantidadHoras = lpCantidadHoras;
	}
	public String getLpNombreCliente() {
		return lpNombreCliente;
	}
	public void setLpNombreCliente(String lpNombreCliente) {
		this.lpNombreCliente = lpNombreCliente;
	}
	public String getLpEstado() {
		return lpEstado;
	}
	public void setLpEstado(String lpEstado) {
		this.lpEstado = lpEstado;
	}
	
	
	
	
	
	

}
