package com.homie.backend.sisInterno.dto;

import java.util.Date;
import java.util.List;

import com.homie.backend.sisInterno.entity.HoCatalogo;
import com.homie.backend.sisInterno.entity.HoPedidoServicio;

public class CrearPedidoRequestDto {

	private Date peFechaPedido;
	private Long peCantidadHoras;
	private String peObservacion;
	private Integer peCliente;
	private Double peValor;
	private String peEstado ;
	private String peDireccion;
	private List<String> cedulasHomies;
	private List<HoCatalogo> peServicios;
	
	
	
	
	
	public String getPeDireccion() {
		return peDireccion;
	}
	public void setPeDireccion(String peDireccion) {
		this.peDireccion = peDireccion;
	}
	public Date getPeFechaPedido() {
		return peFechaPedido;
	}
	public void setPeFechaPedido(Date peFechaPedido) {
		this.peFechaPedido = peFechaPedido;
	}
	public Long getPeCantidadHoras() {
		return peCantidadHoras;
	}
	public void setPeCantidadHoras(Long peCantidadHoras) {
		this.peCantidadHoras = peCantidadHoras;
	}
	public String getPeObservacion() {
		return peObservacion;
	}
	public void setPeObservacion(String peObservacion) {
		this.peObservacion = peObservacion;
	}

	public Integer getPeCliente() {
		return peCliente;
	}
	public void setPeCliente(Integer peCliente) {
		this.peCliente = peCliente;
	}
	public Double getPeValor() {
		return peValor;
	}
	public void setPeValor(Double peValor) {
		this.peValor = peValor;
	}
	public String getPeEstado() {
		return peEstado;
	}
	public void setPeEstado(String peEstado) {
		this.peEstado = peEstado;
	}
	public List<String> getCedulasHomies() {
		return cedulasHomies;
	}
	public void setCedulasHomies(List<String> cedulasHomies) {
		this.cedulasHomies = cedulasHomies;
	}
	public List<HoCatalogo> getPeServicios() {
		return peServicios;
	}
	public void setPeServicios(List<HoCatalogo> peServicios) {
		this.peServicios = peServicios;
	}
	
	
	
}
