package com.homie.backend.sisInterno.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class HoRol {
	
	@Id
	private String roNombre;
	
	private String roEstado;
	

	@OneToMany(mappedBy="hoRol", cascade=CascadeType.ALL)
	private List<HoUsuario> hoUsuarioList;
	
	@OneToMany(mappedBy="hoRol", cascade=CascadeType.ALL)
	private List<HoRolAcceso> hoRolAccesoList;
	
	
	
	
	
	
	public String getRoNombre() {
		return roNombre;
	}
	public void setRoNombre(String roNombre) {
		this.roNombre = roNombre;
	}
	public String getRoEstado() {
		return roEstado;
	}
	public void setRoEstado(String roEstado) {
		this.roEstado = roEstado;
	}
	public List<HoUsuario> getHoUsuarioList() {
		return hoUsuarioList;
	}
	public void setHoUsuarioList(List<HoUsuario> hoUsuarioList) {
		this.hoUsuarioList = hoUsuarioList;
	}
	public List<HoRolAcceso> getHoRolAccesoList() {
		return hoRolAccesoList;
	}
	public void setHoRolAccesoList(List<HoRolAcceso> hoRolAccesoList) {
		this.hoRolAccesoList = hoRolAccesoList;
	}

	

}
