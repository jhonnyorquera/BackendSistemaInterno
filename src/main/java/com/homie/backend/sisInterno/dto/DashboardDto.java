package com.homie.backend.sisInterno.dto;

import java.util.List;

public class DashboardDto {

	private int cantPedidos;
	private long cantClientes;
	private double dineroRecaudado;
	private List<HomieCaracteristica> calificacion;
	private List<HomieCaracteristica> dinero;
	private List<HomieCaracteristica> limpiezas;
	
		
	
	
	public int getCantPedidos() {
		return cantPedidos;
	}

	public void setCantPedidos(int cantPedidos) {
		this.cantPedidos = cantPedidos;
	}

	public long getCantClientes() {
		return cantClientes;
	}

	public void setCantClientes(long cantClientes) {
		this.cantClientes = cantClientes;
	}

	public List<HomieCaracteristica> getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(List<HomieCaracteristica> calificacion) {
		this.calificacion = calificacion;
	}

	public List<HomieCaracteristica> getDinero() {
		return dinero;
	}

	public void setDinero(List<HomieCaracteristica> dinero) {
		this.dinero = dinero;
	}

	public List<HomieCaracteristica> getLimpiezas() {
		return limpiezas;
	}

	public void setLimpiezas(List<HomieCaracteristica> limpiezas) {
		this.limpiezas = limpiezas;
	}

	public double getDineroRecaudado() {
		return dineroRecaudado;
	}

	public void setDineroRecaudado(double dineroRecaudado) {
		this.dineroRecaudado = dineroRecaudado;
	}
	
}
