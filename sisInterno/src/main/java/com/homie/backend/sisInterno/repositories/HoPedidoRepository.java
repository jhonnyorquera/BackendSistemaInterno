package com.homie.backend.sisInterno.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.homie.backend.sisInterno.entity.HoPedido;

public interface HoPedidoRepository extends CrudRepository<HoPedido, String> {

	@Query("SELECT COUNT(u) FROM HoPedido u WHERE u.peFechaCreacion BETWEEN ?1 AND ?2 ")
	public Long findCantidad(Date time, Date time2);

}
