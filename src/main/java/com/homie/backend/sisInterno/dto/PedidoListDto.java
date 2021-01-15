package com.homie.backend.sisInterno.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class PedidoListDto {
	
	
	private String plHoCedula;
	private String plHoNombre;
	private String plHoModalidad;
	private String plHoTelefono;
	private Date plFechaPedido;
	private Double plCantidadHoras;
	private String plNombreCliente;
	private String plEstado;
	private String peCodigo;
	
	
	
	public PedidoListDto() {
		super();
	}

	

	public PedidoListDto(String plHoCedula, String plHoNombre, String plHoModalidad, String plHoTelefono, Date plFechaPedido,
			Double plCantidadHoras, String plNombreCliente, String plEstado) {
		super();
		this.plHoCedula=plHoCedula;
		this.plHoNombre = plHoNombre;
		this.plHoModalidad = plHoModalidad;
		this.plHoTelefono = plHoTelefono;
		this.plFechaPedido = plFechaPedido;
		this.plCantidadHoras = plCantidadHoras;
		this.plNombreCliente = plNombreCliente;
		this.plEstado = plEstado;
	}
	
	
	
	



	public PedidoListDto(String plHoCedula, String plHoNombre, Date plFechaPedido, Double plCantidadHoras,
			String plNombreCliente, String plEstado, String peCodigo) {
		super();
		this.plHoCedula = plHoCedula;
		this.plHoNombre = plHoNombre;
		this.plFechaPedido = plFechaPedido;
		this.plCantidadHoras = plCantidadHoras;
		this.plNombreCliente = plNombreCliente;
		this.plEstado = plEstado;
		this.peCodigo = peCodigo;
	}



	public PedidoListDto(String plHoCedula, String plHoNombre, String plHoModalidad, String plHoTelefono) {
		super();
		this.plHoCedula = plHoCedula;
		this.plHoNombre = plHoNombre;
		this.plHoModalidad = plHoModalidad;
		this.plHoTelefono = plHoTelefono;
	}



	public String getPlHoCedula() {
		return plHoCedula;
	}



	public void setPlHoCedula(String plHoCedula) {
		this.plHoCedula = plHoCedula;
	}



	public Date getPlFechaPedido() {
		return plFechaPedido;
	}

	public void setPlFechaPedido(Date plFechaPedido) {
		this.plFechaPedido = plFechaPedido;
	}

	public Double getPlCantidadHoras() {
		return plCantidadHoras;
	}

	public void setPlCantidadHoras(Double plCantidadHoras) {
		this.plCantidadHoras = plCantidadHoras;
	}

	public String getPlNombreCliente() {
		return plNombreCliente;
	}

	public void setPlNombreCliente(String plNombreCliente) {
		this.plNombreCliente = plNombreCliente;
	}

	public String getPlEstado() {
		return plEstado;
	}

	public void setPlEstado(String plEstado) {
		this.plEstado = plEstado;
	}



	public String getPlHoNombre() {
		return plHoNombre;
	}



	public void setPlHoNombre(String plHoNombre) {
		this.plHoNombre = plHoNombre;
	}



	public String getPlHoModalidad() {
		return plHoModalidad;
	}



	public void setPlHoModalidad(String plHoModalidad) {
		this.plHoModalidad = plHoModalidad;
	}



	public String getPlHoTelefono() {
		return plHoTelefono;
	}



	public void setPlHoTelefono(String plHoTelefono) {
		this.plHoTelefono = plHoTelefono;
	}



	public String getPeCodigo() {
		return peCodigo;
	}



	public void setPeCodigo(String peCodigo) {
		this.peCodigo = peCodigo;
	}
	
	
	
	
	
	
	
	

}
