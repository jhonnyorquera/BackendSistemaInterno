package com.homie.backend.sisInterno.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.homie.backend.sisInterno.entity.HoCliente;


public interface HoClienteRepository extends CrudRepository<HoCliente, String>{
	
	HoCliente findByClCedulaRuc(String ClCedulaRuc);
	
	HoCliente findByClId(Integer lId); 
	
	
	List<HoCliente> findByClNombreContaining(String name); 


}
