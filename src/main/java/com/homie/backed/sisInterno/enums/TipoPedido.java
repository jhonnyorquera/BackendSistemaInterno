package com.homie.backed.sisInterno.enums;

public enum TipoPedido {

	PRINCIPAL("PRINCIPAL"), PLAN("PLAN");

	private final String key;

	private TipoPedido(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
	
}
