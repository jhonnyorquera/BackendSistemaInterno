package com.homie.backend.sisInterno.repositories;

import org.springframework.data.repository.CrudRepository;

import com.homie.backend.sisInterno.entity.HoUsuario;


public interface HoUsuarioRepository extends CrudRepository<HoUsuario, String>{
	
	public HoUsuario findByUsCedula(String cedula);
	
	
	
}
