package com.homie.backend.sisInterno.dto;

import java.util.List;

public class PedidoListDtoResponse {
	
	private String hHoCedula;
	private String hlHoNombre;
	private String hlHoModalidad;
	private String hlHoTelefono;
	private List<ListaPedidosDto> pedidos;
	
	
	
	
	public String gethHoCedula() {
		return hHoCedula;
	}
	public void sethHoCedula(String hHoCedula) {
		this.hHoCedula = hHoCedula;
	}
	public String getHlHoNombre() {
		return hlHoNombre;
	}
	public void setHlHoNombre(String hlHoNombre) {
		this.hlHoNombre = hlHoNombre;
	}
	public String getHlHoModalidad() {
		return hlHoModalidad;
	}
	public void setHlHoModalidad(String hlHoModalidad) {
		this.hlHoModalidad = hlHoModalidad;
	}
	public String getHlHoTelefono() {
		return hlHoTelefono;
	}
	public void setHlHoTelefono(String hlHoTelefono) {
		this.hlHoTelefono = hlHoTelefono;
	}
	public List<ListaPedidosDto> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<ListaPedidosDto> pedidos) {
		this.pedidos = pedidos;
	}
	
	
	
 
}
