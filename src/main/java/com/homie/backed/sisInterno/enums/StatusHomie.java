package com.homie.backed.sisInterno.enums;

public enum StatusHomie {

	HABILITADO("HABILITADO"), NOHABILITADO("NOHABILITADO");

	private final String key;

	private StatusHomie(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

}
