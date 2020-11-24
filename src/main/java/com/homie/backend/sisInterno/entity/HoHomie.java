package com.homie.backend.sisInterno.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class HoHomie {

	@Id
	private String hoCedula;

	@Column(length = 70)
	private String hoNombre;

	@Column(length = 30)
	private String hoTelefono;

	@Column(length = 30)
	private String hoCorreo;

	@Column(length = 150)
	private String hoNroCuenta;

	@Column(length = 30)
	private String hoModalidad;

	@Column(length = 30)
	private String hoSector;

	@Column(length = 50)
	private String hoNivelEducativo;

	@Column(length = 50)
	private String hoDireccion;

	@Column(length = 20)
	private String hoSueldo;

	@Column(length = 50)
	private String hoEstadoCivil;

	@Column(length = 100)
	private String hoHijos;

	@Temporal(TemporalType.DATE)
	private Date hoFechaNacimiento;

	@Temporal(TemporalType.DATE)
	private Date hoFechaIngreso;

	@Temporal(TemporalType.TIMESTAMP)
	private Date hoFechaRegistro;

	@Column(length = 15)
	private String hoStatus;

	@Temporal(TemporalType.DATE)
	private Date hoFechaSalida;

	@OneToMany(mappedBy = "hoHomie", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<HoPedidoHomie> hoPedidoList;

	public String getHoCedula() {
		return hoCedula;
	}

	public void setHoCedula(String hoCedula) {
		this.hoCedula = hoCedula;
	}

	public String getHoNombre() {
		return hoNombre;
	}

	public void setHoNombre(String hoNombre) {
		this.hoNombre = hoNombre.toUpperCase();
	}

	public String getHoTelefono() {
		return hoTelefono;
	}

	public void setHoTelefono(String hoTelefono) {
		this.hoTelefono = hoTelefono;
	}

	public String getHoCorreo() {
		return hoCorreo;
	}

	public void setHoCorreo(String hoCorreo) {
		this.hoCorreo = hoCorreo.toLowerCase();
	}

	public String getHoNroCuenta() {
		return hoNroCuenta;
	}

	public void setHoNroCuenta(String hoNroCuenta) {
		this.hoNroCuenta = hoNroCuenta;
	}

	public String getHoModalidad() {
		return hoModalidad;
	}

	public void setHoModalidad(String hoModalidad) {
		this.hoModalidad = hoModalidad;
	}

	public String getHoSector() {
		return hoSector;
	}

	public void setHoSector(String hoSector) {
		this.hoSector = hoSector;
	}

	public String getHoNivelEducativo() {
		return hoNivelEducativo;
	}

	public void setHoNivelEducativo(String hoNivelEducativo) {
		this.hoNivelEducativo = hoNivelEducativo;
	}

	public String getHoDireccion() {
		return hoDireccion;
	}

	public void setHoDireccion(String hoDireccion) {
		this.hoDireccion = hoDireccion;
	}

	public String getHoSueldo() {
		return hoSueldo;
	}

	public void setHoSueldo(String hoSueldo) {
		this.hoSueldo = hoSueldo;
	}

	public String getHoEstadoCivil() {
		return hoEstadoCivil;
	}

	public void setHoEstadoCivil(String hoEstadoCivil) {
		this.hoEstadoCivil = hoEstadoCivil;
	}

	public String getHoHijos() {
		return hoHijos;
	}

	public void setHoHijos(String hoHijos) {
		this.hoHijos = hoHijos;
	}

	public Date getHoFechaNacimiento() {
		return hoFechaNacimiento;
	}

	public void setHoFechaNacimiento(Date hoFechaNacimiento) {
		this.hoFechaNacimiento = hoFechaNacimiento;
	}

	public Date getHoFechaIngreso() {
		return hoFechaIngreso;
	}

	public void setHoFechaIngreso(Date hoFechaIngreso) {
		this.hoFechaIngreso = hoFechaIngreso;
	}

	public Date getHoFechaSalida() {
		return hoFechaSalida;
	}

	public void setHoFechaSalida(Date hoFechaSalida) {
		this.hoFechaSalida = hoFechaSalida;
	}

	public Date getHoFechaRegistro() {
		return hoFechaRegistro;
	}

	public void setHoFechaRegistro(Date hoFechaRegistro) {
		this.hoFechaRegistro = hoFechaRegistro;
	}

	public List<HoPedidoHomie> getHoPedidoList() {
		return hoPedidoList;
	}

	public void setHoPedidoList(List<HoPedidoHomie> hoPedidoList) {
		this.hoPedidoList = hoPedidoList;
	}

	public String getHoStatus() {
		return hoStatus;
	}

	public void setHoStatus(String hoStatus) {
		this.hoStatus = hoStatus;
	}
}
