package com.homie.backend.sisInterno.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class HoCliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer clId;
	
	@Column(length = 50)
	private String clTipo;
	
	@Column(length = 50)
	private String clNombre;
	
	@Column(length = 50)
	private String clSector;
	
	@Column(length = 300)
	private String clDireccion;
	
	@Column(length = 50)
	private String clTelefono;
	
	@Column(length = 50)
	private String clCorreo;

	@Column(length = 100)
	private String obFactura;
	
	@OneToMany(mappedBy="hoCliente", cascade=CascadeType.ALL)
	private List<HoPedido> hoPedidoList;
	
	
	
	
	
	
	
	
	
	
	

}
