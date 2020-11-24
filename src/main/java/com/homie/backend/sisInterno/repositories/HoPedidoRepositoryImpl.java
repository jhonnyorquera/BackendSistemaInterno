package com.homie.backend.sisInterno.repositories;


import java.util.Date;

import java.util.List;
import javax.persistence.criteria.Predicate;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.homie.backend.sisInterno.entity.HoHomie;
import com.homie.backend.sisInterno.entity.HoPedido;
import com.homie.backend.sisInterno.entity.HoPedidoHomie;

public class HoPedidoRepositoryImpl {
	
	@PersistenceContext
	private EntityManager entityManager;
	

	
	public List<HoPedido> getPedidos(String condition1, Date condition2){
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<HoPedido> criteriaQuery = criteriaBuilder.createQuery(HoPedido.class);
		
		Root<HoPedido> pedido = criteriaQuery.from(HoPedido.class);
		Root<HoHomie> homie = criteriaQuery.from(HoHomie.class);
		Root<HoPedidoHomie> pedidoHomie = criteriaQuery.from(HoPedidoHomie.class);
			

		Predicate joinHomiePe =criteriaBuilder.equal(pedidoHomie.get("hoHomie"), homie.get("hoCedula")); 
		Predicate joinPedidoPe =criteriaBuilder.equal(pedidoHomie.get("hoPedido"), pedido.get("peCodigo"));
		Predicate predicateJoin= criteriaBuilder.and(joinHomiePe, joinPedidoPe);
			
		Predicate predicateForHomie = criteriaBuilder.equal(homie.get("hoCedula"), condition1);
		Predicate predicateForPedido= criteriaBuilder.greaterThanOrEqualTo(pedido.get("peFechaPedido"), condition2);
		Predicate predicateCondicion= criteriaBuilder.and(predicateForHomie, predicateForPedido);
		
		Predicate predicateFinal= criteriaBuilder.and(predicateJoin, predicateCondicion);

		criteriaQuery.multiselect(pedido.get("peCodigo"), pedido.get("peFechaPedido"), pedido.get("peCantidadHoras"), pedido.get("peEstado")).where(predicateFinal).distinct(true);
		
		return  entityManager.createQuery(criteriaQuery).getResultList();
		
		
		
	}
	
	
	
	
}
