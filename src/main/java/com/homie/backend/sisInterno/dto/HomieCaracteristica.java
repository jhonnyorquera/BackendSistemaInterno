package com.homie.backend.sisInterno.dto;

public class HomieCaracteristica {

	private String cedula;
	private String nombre;
	private Double cantidad;
	
	
	

	public HomieCaracteristica(String cedula, String nombre, Double cantidad) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

}
