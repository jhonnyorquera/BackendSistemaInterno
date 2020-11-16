package com.homie.backend.sisInterno.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.homie.backend.sisInterno.dto.BusquedaResponseDto;
import com.homie.backend.sisInterno.entity.HoPedido;

public interface HoPedidoRepository extends CrudRepository<HoPedido, String> {

	@Query("SELECT COUNT(u) FROM HoPedido u WHERE u.peFechaCreacion BETWEEN ?1 AND ?2 ")
	public Long findCantidad(Date time, Date time2);

	HoPedido findByPeCodigo(String codigo);

	@Query("SELECT new com.homie.backend.sisInterno.dto.BusquedaResponseDto(p.peCodigo, cl.clNombre, p.peFechaPedido, p.peEstado, p.peCantidadHoras, p.peTipo, p.hoPedidoPadre.peCodigo ) from HoPedido p left OUTER JOIN p.hoCliente cl where p.peCodigo = ?1 ")
	public List<BusquedaResponseDto> buscarPedidosXCodigo(String codigo);
	
	@Query("SELECT new com.homie.backend.sisInterno.dto.BusquedaResponseDto(p.peCodigo, cl.clNombre, p.peFechaPedido, p.peEstado, p.peCantidadHoras, p.peTipo, p.hoPedidoPadre.peCodigo ) "
			+ "from HoPedido p left OUTER JOIN p.hoCliente cl where cl.clId = CAST(?1 AS integer) and p.peFechaPedido >= ?2  ")
	public List<BusquedaResponseDto> buscarPedidosXCampos(String cliente, Date fechInicio, Date fecFin, String estado);
	
}
