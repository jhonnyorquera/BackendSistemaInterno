package com.homie.backend.sisInterno.repositories;

import org.springframework.data.repository.CrudRepository;

import com.homie.backend.sisInterno.entity.HoCliente;


public interface HoClienteRepository extends CrudRepository<HoCliente, String>{
	
	HoCliente findByClCedulaRuc(String ClCedulaRuc);
	
	HoCliente findByClId(Integer lId); 


}
