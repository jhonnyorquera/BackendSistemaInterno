package com.homie.backend.sisInterno.repositories;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;


import com.homie.backend.sisInterno.entity.HoComentario;


public interface HoComentarioRepository extends CrudRepository<HoComentario, Date>{
	
	public HoComentario findByObFechaComentario(Date fecha);
	

}
