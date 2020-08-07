package com.homie.backend.sisInterno.repositories;

import org.springframework.data.repository.CrudRepository;

import com.homie.backend.sisInterno.entity.HoCliente;
import com.homie.backend.sisInterno.entity.HoHomie;


public interface HoClienteRepository extends CrudRepository<HoCliente, String>{
	
	HoHomie findByClCedulaRuc(String ClCedulaRuc);


}
