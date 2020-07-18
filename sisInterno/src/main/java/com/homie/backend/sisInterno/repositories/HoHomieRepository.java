package com.homie.backend.sisInterno.repositories;

import org.springframework.data.repository.CrudRepository;

import com.homie.backend.sisInterno.entity.HoHomie;


public interface HoHomieRepository extends CrudRepository<HoHomie, String>{
			
	HoHomie findByHoCedula(String hoCedula);
	

}
