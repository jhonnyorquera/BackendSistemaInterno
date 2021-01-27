package com.homie.backend.sisInterno.dto;

public class SaldosPagoDto {

	private String peCodigo;

	private Double peValor;
	private Double peValorPagado;
	private String peCliente;
	private String peStatusPago;

	public String getPeCliente() {
		return peCliente;
	}

	public void setPeCliente(String peCliente) {
		this.peCliente = peCliente;
	}

	public SaldosPagoDto(String peCodigo, Double peValor, Double peValorPagado, String peCliente, String peStatusPago) {
		super();
		this.peCodigo = peCodigo;
		this.peValor = peValor;
		this.peValorPagado = peValorPagado;
		this.peCliente = peCliente;
		this.peStatusPago = peStatusPago;
	}

	public SaldosPagoDto() {
		super();
	}

	public String getPeCodigo() {
		return peCodigo;
	}

	public void setPeCodigo(String peCodigo) {
		this.peCodigo = peCodigo;
	}

	public Double getPeValor() {
		return peValor;
	}

	public void setPeValor(Double peValor) {
		this.peValor = peValor;
	}

	public Double getPeValorPagado() {
		return peValorPagado;
	}

	public void setPeValorPagado(Double peValorPagado) {
		this.peValorPagado = peValorPagado;
	}

	public String getPeStatusPago() {
		return peStatusPago;
	}

	public void setPeStatusPago(String peStatusPago) {
		this.peStatusPago = peStatusPago;
	}

}
