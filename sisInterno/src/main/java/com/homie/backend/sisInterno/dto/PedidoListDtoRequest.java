package com.homie.backend.sisInterno.dto;
import java.util.Date;

public class PedidoListDtoRequest {
	
	public String cedula;
	public Date fecha;
	
	
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	

}
