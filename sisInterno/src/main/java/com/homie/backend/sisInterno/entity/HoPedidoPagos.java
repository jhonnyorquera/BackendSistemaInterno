package com.homie.backend.sisInterno.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HoPedidoPagos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ppPagoId;
	
	@Column(length = 50)
	private String ppFormaPago;
	
		
	@Column(scale = 2)
	private Double ppValor;
	
	@ManyToOne
	@JoinColumn(name="ho_pedido" ) 
	private HoPedido hoPedido;
	
	
		
	public HoPedidoPagos() {
		super();
	}





	public Integer getPpPagoId() {
		return ppPagoId;
	}





	public void setPpPagoId(Integer ppPagoId) {
		this.ppPagoId = ppPagoId;
	}





	public String getPpFormaPago() {
		return ppFormaPago;
	}





	public void setPpFormaPago(String ppFormaPago) {
		this.ppFormaPago = ppFormaPago;
	}





	public Double getPpValor() {
		return ppValor;
	}





	public void setPpValor(Double ppValor) {
		this.ppValor = ppValor;
	}





	public HoPedido getHoPedido() {
		return hoPedido;
	}





	public void setHoPedido(HoPedido hoPedido) {
		this.hoPedido = hoPedido;
	}




	
	
	

}
