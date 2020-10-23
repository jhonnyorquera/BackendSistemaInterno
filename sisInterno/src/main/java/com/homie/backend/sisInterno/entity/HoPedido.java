package com.homie.backend.sisInterno.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class HoPedido {
	
	@Id
	private String peCodigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date peFechaPedido;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date peFechaCreacion;
		
	@Column(scale = 2)
	private Long peCantidadHoras;
	
	@Column(length = 300)
	private String peServicios;
	
	@Column(length = 300)
	private String peObservacion;
	
	@Column(scale = 2)
	private Double peValor;
		
	@Column(length = 300)
	private String peEstado;
	
	@Column(length = 300)
	private String peDireccion;

	
	public String getPeDireccion() {
		return peDireccion;
	}



	public void setPeDireccion(String peDireccion) {
		this.peDireccion = peDireccion;
	}

	@JsonIgnore
	@OneToMany(mappedBy="hoPedido", cascade=CascadeType.ALL)
	private List<HoPedidoHomie> hoHomieList;
	
	@OneToMany(mappedBy="hoPedido", cascade=CascadeType.ALL)
	private List<HoComentario> hoComentarioList;
	
	@OneToMany(mappedBy="hoPedido", cascade=CascadeType.ALL)
	private List<HoPedidoServicio> hoPedidoServicioList;
	
	@ManyToOne
	@JoinColumn(name="ho_cliente" ) 
	private HoCliente hoCliente;
	

	
	
	

	

	public Date getPeFechaCreacion() {
		return peFechaCreacion;
	}



	public void setPeFechaCreacion(Date peFechaCreacion) {
		this.peFechaCreacion = peFechaCreacion;
	}



	public HoPedido() {
		super();
	}



	public HoPedido(String peCodigo, Date peFechaPedido, Long peCantidadHoras, String peEstado) {
		super();
		this.peCodigo = peCodigo;
		this.peFechaPedido = peFechaPedido;
		this.peCantidadHoras = peCantidadHoras;
		this.peEstado = peEstado;
	}



	public String getPeCodigo() {
		return peCodigo;
	}

	public void setPeCodigo(String peCodigo) {
		this.peCodigo = peCodigo;
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

	public String getPeServicios() {
		return peServicios;
	}

	public void setPeServicios(String peServicios) {
		this.peServicios = peServicios;
	}

	public String getPeObservacion() {
		return peObservacion;
	}

	public void setPeObservacion(String peObservacion) {
		this.peObservacion = peObservacion;
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

	public List<HoPedidoHomie> getHoHomieList() {
		return hoHomieList;
	}

	public void setHoHomieList(List<HoPedidoHomie> hoHomieList) {
		this.hoHomieList = hoHomieList;
	}

	public List<HoComentario> getHoComentarioList() {
		return hoComentarioList;
	}

	public void setHoComentarioList(List<HoComentario> hoComentarioList) {
		this.hoComentarioList = hoComentarioList;
	}

	public List<HoPedidoServicio> getHoPedidoServicioList() {
		return hoPedidoServicioList;
	}

	public void setHoPedidoServicioList(List<HoPedidoServicio> hoPedidoServicioList) {
		this.hoPedidoServicioList = hoPedidoServicioList;
	}

	public HoCliente getHoCliente() {
		return hoCliente;
	}

	public void setHoCliente(HoCliente hoCliente) {
		this.hoCliente = hoCliente;
	}
	
	
	
	
	

}
