package com.homie.backend.sisInterno.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.homie.backend.sisInterno.dto.PedidoListDto;
import com.homie.backend.sisInterno.dto.PedidoListDtoResponse;
import com.homie.backend.sisInterno.entity.HoHomie;
import com.homie.backend.sisInterno.entity.HoPedido;
import com.homie.backend.sisInterno.entity.HoPedidoHomie;

public interface HoPedidoHomieRepository extends CrudRepository<HoPedidoHomie, String> {

	@Query("SELECT new com.homie.backend.sisInterno.dto.PedidoListDto(h.hoCedula, h.hoNombre, h.hoModalidad, h.hoTelefono, p.peFechaPedido, p.peCantidadHoras, p.hoCliente.clNombre, p.peEstado) FROM HoHomie h left OUTER JOIN h.hoPedidoList hp left OUTER join hp.hoPedido p where p.peFechaPedido >= ?1 order by h.hoCedula ")
	public List<PedidoListDto> getPedidosPorClienteFecha(Date fecha);

	@Query("SELECT new com.homie.backend.sisInterno.dto.PedidoListDtoResponse(h.hoCedula, h.hoNombre, h.hoModalidad, h.hoTelefono) FROM HoHomie h where h.hoStatus=?1 order by h.hoCedula")
	public List<PedidoListDtoResponse> getHomiesByStatus(String status);
	
	public HoPedidoHomie findByHoPeHoId(Integer id);
	
	public List<HoPedidoHomie> findByHoPedido(HoPedido hoPedido);
	
	@Query("SELECT hope from HoPedidoHomie hope where hope.hoPedido =?1 and hope.hoHomie =?2")
	public HoPedidoHomie getByPedidoHomie(HoPedido varUno, HoHomie varDos);


	@Query("SELECT new com.homie.backend.sisInterno.dto.PedidoListDto(h.hoCedula, h.hoNombre, p.peFechaPedido, p.peCantidadHoras, p.hoCliente.clNombre, p.peEstado, p.peCodigo) FROM HoHomie h left OUTER JOIN h.hoPedidoList hp left OUTER join hp.hoPedido p where p.peFechaPedido >= ?1 and p.peFechaPedido <=?2 and h.hoCedula =?3 order by h.hoCedula ")
	public List<PedidoListDto> getPedidosPorHomieFecha(Date fechaIni, Date fechaFin, String cedula);

	
	
}
