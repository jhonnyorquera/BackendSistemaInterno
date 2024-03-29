package com.homie.backend.sisInterno.dto;

import java.util.Date;
import java.util.List;

import com.homie.backend.sisInterno.entity.HoCatalogo;
import com.homie.backend.sisInterno.entity.HoPedidoPagos;

public class CrearPedidoRequestDto {

	private List<Date> peFechaPedido;
	private Double peCantidadHoras;
	private String peObservacion;
	private Integer peCliente;
	private String peEstado ;
	private String peDireccion;
	private double peValor;
	private List<String> cedulasHomies;
	private List<HoCatalogo> peServicios;
	private List<HoPedidoPagos> pePagos;
	
	
	
	
	
	public String getPeDireccion() {
		return peDireccion;
	}
	public void setPeDireccion(String peDireccion) {
		this.peDireccion = peDireccion;
	}
	
	
	
	public Double getPeCantidadHoras() {
		return peCantidadHoras;
	}
	public void setPeCantidadHoras(Double peCantidadHoras) {
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
	public List<HoPedidoPagos> getPePagos() {
		return pePagos;
	}
	public void setPePagos(List<HoPedidoPagos> pePagos) {
		this.pePagos = pePagos;
	}
	public List<Date> getPeFechaPedido() {
		return peFechaPedido;
	}
	public void setPeFechaPedido(List<Date> peFechaPedido) {
		this.peFechaPedido = peFechaPedido;
	}
	public double getPeValor() {
		return peValor;
	}
	public void setPeValor(double peValor) {
		this.peValor = peValor;
	}
	
	
	
}
