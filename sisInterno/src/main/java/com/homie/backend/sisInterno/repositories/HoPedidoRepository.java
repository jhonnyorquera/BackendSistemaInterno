package com.homie.backend.sisInterno.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.homie.backend.sisInterno.entity.HoPedido;


public interface HoPedidoRepository extends CrudRepository<HoPedido, String>{

	List<HoPedido> getPedidos(String condition1, Date condition2);

	
}
