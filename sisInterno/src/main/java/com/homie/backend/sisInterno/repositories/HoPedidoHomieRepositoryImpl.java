package com.homie.backend.sisInterno.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

public class HoPedidoHomieRepositoryImpl {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<HoPedidoHomie> getData(HashMap<String, Object> conditions){
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<HoPedidoHomie> query= cb.createQuery(HoPedidoHomie.class);
		Root<HoPedidoHomie> root = query.from(HoPedidoHomie.class);
		Root<HoHomie> homieCon= query.from(HoHomie.class);
		Root<HoPedido> hoPedido= query.from(HoPedido.class);
		
		conditions.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));
		
		
		
		List<Predicate> predicates = new ArrayList<>();
		conditions.forEach((field,value) ->
		{
			if(field=="hoCedula") {
				
				predicates.add(cb.equal(homieCon.get(field), (String)value));
			}
			
			if(field=="peFechaPedido") {
				System.out.println("field:"+field+" value:"+value);
				predicates.add(cb.equal(hoPedido.<Date>get(field),(Date)value));
			}
			
			
				
		});
		
		query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
		return entityManager.createQuery(query).getResultList(); 	
		
		
	}

	
	
}
