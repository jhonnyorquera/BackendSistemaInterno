package com.homie.backend.sisInterno.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class PedidoListDto {
	
	private Date plFechaPedido;
	private Long plCantidadHoras;
	private String plNombreCliente;
	private String plEstado;
	
	
	
	public PedidoListDto() {
		super();
	}

	public PedidoListDto(Date plFechaPedido, Long plCantidadHoras, String plNombreCliente, String plEstado) {
		super();
		this.plFechaPedido = plFechaPedido;
		this.plCantidadHoras = plCantidadHoras;
		this.plNombreCliente = plNombreCliente;
		this.plEstado = plEstado;
	}

	public Date getPlFechaPedido() {
		return plFechaPedido;
	}

	public void setPlFechaPedido(Date plFechaPedido) {
		this.plFechaPedido = plFechaPedido;
	}

	public Long getPlCantidadHoras() {
		return plCantidadHoras;
	}

	public void setPlCantidadHoras(Long plCantidadHoras) {
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
	
	
	
	
	
	
	

}
