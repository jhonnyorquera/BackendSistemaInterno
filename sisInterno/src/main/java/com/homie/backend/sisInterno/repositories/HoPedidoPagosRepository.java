package com.homie.backend.sisInterno.repositories;

import org.springframework.data.repository.CrudRepository;


import com.homie.backend.sisInterno.entity.HoPedidoPagos;


public interface HoPedidoPagosRepository extends CrudRepository<HoPedidoPagos, String>{
	
	public HoPedidoPagos findByPpPagoId(Integer id);
	
	


}
