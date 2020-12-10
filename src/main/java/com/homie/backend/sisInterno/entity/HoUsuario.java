package com.homie.backend.sisInterno.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HoUsuario {
	
	@Id
	private String usCedula;
	 
	private String usName;
	
	private String usPassword;
	
	private String usEstado;
	
	@ManyToOne
	@JoinColumn(name="ho_rol")
	private HoRol hoRol;
	
	
	
	public HoUsuario() {
		super();
	}


	public HoUsuario(String usCedula, String usName, String usPassword) {
		super();
		this.usCedula = usCedula;
		this.usName = usName;
		this.usPassword = usPassword;
	}
	

	public String getUsCedula() {
		return usCedula;
	}

	public void setUsCedula(String usCedula) {
		this.usCedula = usCedula;
	}

	public String getUsPassword() {
		return usPassword;
	}

	public void setUsPassword(String usPassword) {
		this.usPassword = usPassword;
	}

	public String getUsEstado() {
		return usEstado;
	}

	public void setUsEstado(String usEstado) {
		this.usEstado = usEstado;
	}

	public HoRol getHoRol() {
		return hoRol;
	}

	public void setHoRol(HoRol hoRol) {
		this.hoRol = hoRol;
	}

	public String getUsName() {
		return usName;
	}

	public void setUsName(String usName) {
		this.usName = usName;
	}

	
	
	
	
	

	
	
}
