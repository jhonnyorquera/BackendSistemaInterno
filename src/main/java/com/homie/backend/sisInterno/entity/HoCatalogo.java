package com.homie.backend.sisInterno.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HoCatalogo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer seCodigo;

	@Column(length = 25)
	private String seNombre;

	private String seNombreDetalle;

	@Column(scale = 2)
	private Double seValor;

	@Column(scale = 2)
	private Double seCantidad;

	@Column(length = 3)
	private String seEstado;

	public Integer getSeCodigo() {
		return seCodigo;
	}

	public void setSeCodigo(Integer seCodigo) {
		this.seCodigo = seCodigo;
	}

	public String getSeNombre() {
		return seNombre;
	}

	public void setSeNombre(String seNombre) {
		this.seNombre = seNombre.toUpperCase();
	}

	public Double getSeValor() {
		return seValor;
	}

	public void setSeValor(Double seValor) {
		this.seValor = seValor;
	}

	public String getSeEstado() {
		return seEstado;
	}

	public void setSeEstado(String seEstado) {
		this.seEstado = seEstado;
	}

	public String getSeNombreDetalle() {
		return seNombreDetalle;
	}

	public void setSeNombreDetalle(String seNombreDetalle) {
		this.seNombreDetalle = seNombreDetalle.toUpperCase();
	}

	public Double getSeCantidad() {
		return seCantidad;
	}

	public void setSeCantidad(Double seCantidad) {
		this.seCantidad = seCantidad;
	}

}
