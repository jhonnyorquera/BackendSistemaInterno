package com.homie.backend.sisInterno.dto;

import java.util.List;

public class HomieDisponibleDto {
	
	private String hoNombreDis;
	private String hoTelefonoDis;
	private List<HoPedidosDto> pedidos;
	
	
	
	public String getHoNombreDis() {
		return hoNombreDis;
	}
	public void setHoNombreDis(String hoNombreDis) {
		this.hoNombreDis = hoNombreDis;
	}
	public String getHoTelefonoDis() {
		return hoTelefonoDis;
	}
	public void setHoTelefonoDis(String hoTelefonoDis) {
		this.hoTelefonoDis = hoTelefonoDis;
	}
	public List<HoPedidosDto> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<HoPedidosDto> pedidos) {
		this.pedidos = pedidos;
	} 
	
	
	
	

}
