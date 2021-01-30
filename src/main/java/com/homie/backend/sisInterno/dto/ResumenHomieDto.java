package com.homie.backend.sisInterno.dto;

public class ResumenHomieDto {

	private String cedula;
	private String nombre;
	private double calificacion;
	private double dinero;
	private double limpiezas;
	
	
	
	

	public ResumenHomieDto(String cedula, String nombre) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
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
	public double getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	public double getDinero() {
		return dinero;
	}
	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	public double getLimpiezas() {
		return limpiezas;
	}
	public void setLimpiezas(double limpiezas) {
		this.limpiezas = limpiezas;
	}
}
