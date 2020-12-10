package com.homie.backend.sisInterno.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class HoAcceso {
	
	@Id
	private Integer acCodigo;
	
	private String acNombre;
	
	private String acPath;
	
	private String acMetodo;
	
	private String acStatus;
	
	@OneToMany(mappedBy="hoAcceso", cascade=CascadeType.ALL)
	private List<HoRolAcceso> hoRolAccesoList;
	
	
	public Integer getAcCodigo() {
		return acCodigo;
	}
	public void setAcCodigo(Integer acCodigo) {
		this.acCodigo = acCodigo;
	}
	public String getAcNombre() {
		return acNombre;
	}
	public void setAcNombre(String acNombre) {
		this.acNombre = acNombre;
	}
	public String getAcPath() {
		return acPath;
	}
	public void setAcPath(String acPath) {
		this.acPath = acPath;
	}
	public String getAcMetodo() {
		return acMetodo;
	}
	public void setAcMetodo(String acMetodo) {
		this.acMetodo = acMetodo;
	}
	public String getAcStatus() {
		return acStatus;
	}
	public void setAcStatus(String acStatus) {
		this.acStatus = acStatus;
	}
	public List<HoRolAcceso> getHoRolAccesoList() {
		return hoRolAccesoList;
	}
	public void setHoRolAccesoList(List<HoRolAcceso> hoRolAccesoList) {
		this.hoRolAccesoList = hoRolAccesoList;
	}
	
	
	
	

}
