package com.homie.backend.sisInterno.dto;

public class User {

	private String user;
	private String pwd;
	private String token;

	
	
	public User() {
		super();
	}

	public User(String user, String pwd) {
		super();
		this.user = user;
		this.pwd = pwd;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
