package com.homie.backed.sisInterno.enums;

public enum PedidoStatusPago {

	PAGADO("PAGADO"), PORCOBRAR("POR COBRAR");

	private final String key;

	private PedidoStatusPago(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
	
}
