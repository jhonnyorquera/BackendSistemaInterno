package com.homie.backend.sisInterno.repositories;

import java.util.List;

import java.util.HashMap;
import org.springframework.data.repository.CrudRepository;

import com.homie.backend.sisInterno.entity.HoPedidoHomie;


public interface HoPedidoHomieRepository extends CrudRepository<HoPedidoHomie, String>{
	
	List<HoPedidoHomie> getData(HashMap<String, Object> conditions);	


}
