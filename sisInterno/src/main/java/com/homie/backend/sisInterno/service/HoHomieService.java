package com.homie.backend.sisInterno.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.homie.backend.sisInterno.dto.HoPedidosDto;
import com.homie.backend.sisInterno.dto.HomieDisponibleDto;
import com.homie.backend.sisInterno.entity.HoHomie;
import com.homie.backend.sisInterno.entity.HoPedidoHomie;
import com.homie.backend.sisInterno.entity.HoPedidoServicio;
import com.homie.backend.sisInterno.repositories.HoHomieRepository;

@Service
public class HoHomieService {
	private HoHomieRepository hoHomieRepository;

	private HoPedidoHomieService hoPedidoHomieService;
	
	public HoHomieService(HoHomieRepository hoHomieRepository) {
		this.hoHomieRepository = hoHomieRepository;
	}
	
	
	public HoHomie registrarHomie(HoHomie hoHomie) {
		hoHomie.setHoFechaRegistro(new Date());
		if (hoHomieRepository.findByHoCedula(hoHomie.getHoCedula()) != null) {
			return null;
		}
		return hoHomieRepository.save(hoHomie);
	}
	
	
	public HoHomie editarHomie(HoHomie hoHomie) {
		return hoHomieRepository.save(hoHomie);
	}
	
	
	public List<HoHomie> listarHomies() {
		return (List<HoHomie>) hoHomieRepository.findAll();	
	}
	
	public List<HomieDisponibleDto> listarHomiesDisponibles() {
		
		//consulta pedidos en la fecha
		System.out.println("1");
		List <HoPedidoHomie> pedidosHomie=new ArrayList<>();
		System.out.println("2");
		pedidosHomie=hoPedidoHomieService.listarPedidos();
		System.out.println("3");
		//Crea lista para llenar DTO
		
		List <HomieDisponibleDto> homiesDisponibles= new  ArrayList<>();
		 System.out.println("entra a metodo");
		
		return homiesDisponibles;
	}
	
}
