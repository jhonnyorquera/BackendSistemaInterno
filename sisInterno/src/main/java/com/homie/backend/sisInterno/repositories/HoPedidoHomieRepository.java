package com.homie.backend.sisInterno.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.homie.backend.sisInterno.dto.PedidoListDto;
import com.homie.backend.sisInterno.entity.HoPedidoHomie;

public interface HoPedidoHomieRepository extends CrudRepository<HoPedidoHomie, String> {

	@Query("SELECT new com.homie.backend.sisInterno.dto.PedidoListDto(p.peFechaPedido, p.peCantidadHoras, p.hoCliente.clNombre, p.peEstado) FROM HoPedido p JOIN p.hoHomieList hp join hp.hoHomie h where p.peFechaPedido >= ?1 and h.hoCedula = ?2")
	public List<PedidoListDto> getPedidosPorClienteFecha(Date fecha, String cedula);

}
