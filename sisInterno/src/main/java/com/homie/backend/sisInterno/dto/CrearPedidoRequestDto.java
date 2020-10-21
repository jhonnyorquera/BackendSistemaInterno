package com.homie.backend.sisInterno.dto;

import java.util.Date;
import java.util.List;

import com.homie.backend.sisInterno.entity.HoPedidoServicio;

public class CrearPedidoRequestDto {

	private Date fechaPedido;
	private Long cantidadHoras;
	private String observacion;
	private Integer idCliente;
	private Double valorServicio;
	private String estadoPedido ;
	private List<String> cedulasHomies;
	private List<HoPedidoServicio> servicios;
	
	
	
	
	public List<HoPedidoServicio> getServicios() {
		return servicios;
	}
	public void setServicios(List<HoPedidoServicio> servicios) {
		this.servicios = servicios;
	}
	public String getEstadoPedido() {
		return estadoPedido;
	}
	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}
	public Date getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public Long getCantidadHoras() {
		return cantidadHoras;
	}
	public void setCantidadHoras(Long cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Double getValorServicio() {
		return valorServicio;
	}
	public void setValorServicio(Double valorServicio) {
		this.valorServicio = valorServicio;
	}
	public List<String> getCedulasHomies() {
		return cedulasHomies;
	}
	public void setCedulasHomies(List<String> cedulasHomies) {
		this.cedulasHomies = cedulasHomies;
	}


	
}
