package com.homie.backend.sisInterno.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.homie.backend.sisInterno.dto.PedidoListDto;
import com.homie.backend.sisInterno.dto.PedidoListDtoResponse;
import com.homie.backend.sisInterno.entity.HoPedidoHomie;

public interface HoPedidoHomieRepository extends CrudRepository<HoPedidoHomie, String> {

	//@Query("SELECT new com.homie.backend.sisInterno.dto.PedidoListDto(h.hoCedula, h.hoNombre, h.hoModalidad, h.hoTelefono, p.peFechaPedido, p.peCantidadHoras, p.hoCliente.clNombre, p.peEstado) FROM HoPedido p JOIN p.hoHomieList hp Left join hp.hoHomie h where p.peFechaPedido >= ?1 order by h.hoCedula")
	@Query("SELECT new com.homie.backend.sisInterno.dto.PedidoListDto(h.hoCedula, h.hoNombre, h.hoModalidad, h.hoTelefono, p.peFechaPedido, p.peCantidadHoras, p.hoCliente.clNombre, p.peEstado) FROM HoHomie h left OUTER JOIN h.hoPedidoList hp left OUTER join hp.hoPedido p where p.peFechaPedido >= ?1 order by h.hoCedula ")
	public List<PedidoListDto> getPedidosPorClienteFecha(Date fecha);

	
	@Query("SELECT new com.homie.backend.sisInterno.dto.PedidoListDtoResponse(h.hoCedula, h.hoNombre, h.hoModalidad, h.hoTelefono) FROM HoHomie h")
	public List<PedidoListDtoResponse> getHomiesLibres();

	
	
	}
