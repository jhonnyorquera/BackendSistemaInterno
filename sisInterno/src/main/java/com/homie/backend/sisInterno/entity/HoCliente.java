package com.homie.backend.sisInterno.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class HoCliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer clId;
	
	@Column(length = 15)
	private String clCedulaRuc;
	
	@Column(length = 50)
	private String clTipo;
	
	@Column(length = 50)
	private String clNombre;
	
	@Column(length = 50)
	private String clSector;
	
	@Column(length = 300)
	private String clDireccion;
	
	@Column(length = 50)
	private String clTelefono;
	
	@Column(length = 50)
	private String clCorreo;

	@Column(length = 100)
	private String obFactura;
	
	@OneToMany(mappedBy="hoCliente", cascade=CascadeType.ALL)
	private List<HoPedido> hoPedidoList;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date clFechaRegistro;
	

	public Date getClFechaRegistro() {
		return clFechaRegistro;
	}

	public void setClFechaRegistro(Date clFechaRegistro) {
		this.clFechaRegistro = clFechaRegistro;
	}

	public Integer getClId() {
		return clId;
	}

	public void setClId(Integer clId) {
		this.clId = clId;
	}

	public String getClCedulaRuc() {
		return clCedulaRuc;
	}

	public void setClCedulaRuc(String clCedulaRuc) {
		this.clCedulaRuc = clCedulaRuc;
	}

	public String getClTipo() {
		return clTipo;
	}

	public void setClTipo(String clTipo) {
		this.clTipo = clTipo;
	}

	public String getClNombre() {
		return clNombre;
	}

	public void setClNombre(String clNombre) {
		this.clNombre = clNombre;
	}

	public String getClSector() {
		return clSector;
	}

	public void setClSector(String clSector) {
		this.clSector = clSector;
	}

	public String getClDireccion() {
		return clDireccion;
	}

	public void setClDireccion(String clDireccion) {
		this.clDireccion = clDireccion;
	}

	public String getClTelefono() {
		return clTelefono;
	}

	public void setClTelefono(String clTelefono) {
		this.clTelefono = clTelefono;
	}

	public String getClCorreo() {
		return clCorreo;
	}

	public void setClCorreo(String clCorreo) {
		this.clCorreo = clCorreo;
	}

	public String getObFactura() {
		return obFactura;
	}

	public void setObFactura(String obFactura) {
		this.obFactura = obFactura;
	}

	public List<HoPedido> getHoPedidoList() {
		return hoPedidoList;
	}

	public void setHoPedidoList(List<HoPedido> hoPedidoList) {
		this.hoPedidoList = hoPedidoList;
	}
	
	
	
	
	
	
	
	
	
	
	

}
