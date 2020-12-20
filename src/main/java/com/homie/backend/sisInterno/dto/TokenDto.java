package com.homie.backend.sisInterno.dto;

public class TokenDto {
	
	public String token;
	public String usuario;
	
	
	
	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public TokenDto() {
		super();
	}

	public TokenDto(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
