package com.homie.backend.sisInterno.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HoRolAcceso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer rolAcc;
	
	
	@ManyToOne
	@JoinColumn(name="ho_acceso")
	private HoAcceso hoAcceso;
	
	
	@ManyToOne
	@JoinColumn(name="ho_rol")
	private HoRol hoRol;
	
	
	
	

	public Integer getRolAcc() {
		return rolAcc;
	}

	public void setRolAcc(Integer rolAcc) {
		this.rolAcc = rolAcc;
	}

	public HoAcceso getHoAcceso() {
		return hoAcceso;
	}

	public void setHoAcceso(HoAcceso hoAcceso) {
		this.hoAcceso = hoAcceso;
	}

	public HoRol getHoRol() {
		return hoRol;
	}

	public void setHoRol(HoRol hoRol) {
		this.hoRol = hoRol;
	}


	
	
	
	

}
