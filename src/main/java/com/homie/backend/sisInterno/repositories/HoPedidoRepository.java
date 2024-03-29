package com.homie.backend.sisInterno.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.homie.backend.sisInterno.dto.BusquedaDtoIn;
import com.homie.backend.sisInterno.dto.BusquedaResponseDto;
import com.homie.backend.sisInterno.dto.SaldosPagoDtoIn;
import com.homie.backend.sisInterno.entity.HoPedido;

public interface HoPedidoRepository extends CrudRepository<HoPedido, String> {

	@Query("SELECT COUNT(u) FROM HoPedido u WHERE u.peFechaPedido >= ?1 AND u.peFechaPedido <= ?2 ")
	public Long findCantidad(Date time, Date time2);

	HoPedido findByPeCodigo(String codigo);

	@Query("SELECT new com.homie.backend.sisInterno.dto.BusquedaResponseDto(p.peCodigo, cl.clNombre, p.peFechaPedido, p.peEstado, p.peCantidadHoras, p.peTipo, p.hoPedidoPadre.peCodigo ) from HoPedido p left OUTER JOIN p.hoCliente cl where p.peCodigo = ?1 ")
	public List<BusquedaResponseDto> buscarPedidosXCodigo(String codigo);

	@Query(value = " select pe.pe_codigo as PeCodigo, " + "cl.cl_nombre as ClCliente, "
			+ "CAST (pe.pe_fecha_pedido AS date) as PeFecha, " + " pe.pe_estado as PeEstado , "
			+ "pe.pe_cantidad_horas as PeCantidadHoras, " + "pe.pe_tipo as PeTipo, " + " pe.ho_pedido_padre as PePadre "
			+ " from ho_pedido pe left outer join ho_cliente cl on pe.ho_cliente = cl.cl_id"
			+ " where pe.pe_estado like :status and cl.cl_nombre like :cliente" + " and pe.pe_fecha_pedido > :inicio"
			+ " and pe.pe_fecha_pedido < :fin", nativeQuery = true)
	public List<BusquedaDtoIn> buscarPedidosXCamposInter(@Param("status") String status,
			@Param("cliente") String cliente, @Param("inicio") Date fechaInicio, @Param("fin") Date fin);

	@Query(value = "select ped.pe_codigo as PeCodigo, ped.pe_valor as peValor, "
			+ "COALESCE((select sum(pa.pp_valor) from ho_pedido_pagos where ped.pe_codigo=ho_pedido_pagos.ho_pedido and ho_pedido_pagos.pp_estado = true group by ped.pe_codigo),0) as peValorPagado, "
			+ "cl.cl_nombre as peCliente, ped.pe_status_pago as peStatusPago"
			+ "			from  ho_cliente cl join ho_pedido ped on ped.ho_cliente = cl.cl_id left JOIN "
			+ "			ho_pedido_pagos pa on ped.pe_codigo=pa.ho_pedido  where ped.pe_tipo ='PRINCIPAL' "
			+ "			and ped.pe_fecha_pedido >=:fechaInicial "
			+ "			and ped.pe_fecha_pedido<=:fechaFinal and ped.pe_status_pago like %:stado%"
			+ "			GROUP BY cl.cl_nombre, ped.pe_codigo ", nativeQuery = true)
	public List<SaldosPagoDtoIn> saldosPago(@Param("fechaInicial") Date fechaInicial,
			@Param("fechaFinal") Date fechaFinal, @Param("stado") String stado);

	@Query("select count(p.peCodigo) from HoPedido p where p.peFechaPedido BETWEEN ?1 AND ?2 and p.peEstado  not in ('CANCELADO')  ")
	public int cantidadPedidos(Date inicio, Date fin);

}
