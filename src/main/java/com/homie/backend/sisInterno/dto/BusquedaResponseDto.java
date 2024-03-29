package com.homie.backend.sisInterno.dto;

import java.util.Date;

public class BusquedaResponseDto implements BusquedaDtoIn {
	
	private String peCodigo;
	private String clCliente;
	private Date peFecha;
	private String peEstado;
	private Double peCantidadHoras;
	private String peTipo;
	private String pePadre;
	
	
	
	
	public BusquedaResponseDto() {
		super();
	}


	public BusquedaResponseDto(String peCodigo, String clCliente, Date peFecha, String peEstado, Double peCantidadHoras,
			String peTipo, String pePadre) {
		super();
		this.peCodigo = peCodigo;
		this.clCliente = clCliente;
		this.peFecha = peFecha;
		this.peEstado = peEstado;
		this.peCantidadHoras = peCantidadHoras;
		this.peTipo = peTipo;
		this.pePadre = pePadre;
	}
	
	
	public String getPeCodigo() {
		return peCodigo;
	}
	public void setPeCodigo(String peCodigo) {
		this.peCodigo = peCodigo;
	}
	public String getClCliente() {
		return clCliente;
	}
	public void setClCliente(String clCliente) {
		this.clCliente = clCliente;
	}
	public Date getPeFecha() {
		return peFecha;
	}
	public void setPeFecha(Date peFecha) {
		this.peFecha = peFecha;
	}
	public String getPeEstado() {
		return peEstado;
	}
	public void setPeEstado(String peEstado) {
		this.peEstado = peEstado;
	}

	public Double getPeCantidadHoras() {
		return peCantidadHoras;
	}


	public void setPeCantidadHoras(Double peCantidadHoras) {
		this.peCantidadHoras = peCantidadHoras;
	}
	public String getPeTipo() {
		return peTipo;
	}
	public void setPeTipo(String peTipo) {
		this.peTipo = peTipo;
	}
	public String getPePadre() {
		return pePadre;
	}
	public void setPePadre(String pePadre) {
		this.pePadre = pePadre;
	}
	

	
	
}
