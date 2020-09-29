package com.homie.backend.sisInterno.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class HoPedido {
	
	@Id
	private String peCodigo;
	
	@Temporal(TemporalType.DATE)
	private Date peFechaPedido;
		
	@Column(scale = 2)
	private Long peCantidadHoras;
	
	@Column(length = 300)
	private String peServicios;
	
	@Column(length = 300)
	private String peObservacion;
	
	@Column(scale = 2)
	private Double peValor;
		
	@Column(length = 300)
	private String peEstado;

	@OneToMany(mappedBy="hoPedido", cascade=CascadeType.ALL)
	private List<HoPedidoHomie> hoHomieList;
	
	@OneToMany(mappedBy="hoPedido", cascade=CascadeType.ALL)
	private List<HoComentario> hoComentarioList;
	
	@OneToMany(mappedBy="hoPedido", cascade=CascadeType.ALL)
	private List<HoPedidoServicio> hoPedidoServicioList;
	
	@ManyToOne
	@JoinColumn(name="ho_cliente" ) 
	private HoCliente hoCliente;
	
	
	
	
	

}
