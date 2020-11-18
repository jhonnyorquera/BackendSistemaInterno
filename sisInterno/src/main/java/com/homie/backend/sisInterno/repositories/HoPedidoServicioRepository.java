package com.homie.backend.sisInterno.repositories;

import org.springframework.data.repository.CrudRepository;


import com.homie.backend.sisInterno.entity.HoPedidoServicio;


public interface HoPedidoServicioRepository extends CrudRepository<HoPedidoServicio, String>{
	
	public HoPedidoServicio findByPsCodigo(Integer psCodigo);
 


}
