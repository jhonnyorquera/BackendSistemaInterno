package com.homie.backend.sisInterno.service;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.homie.backed.sisInterno.enums.StatusHomie;
import com.homie.backend.sisInterno.entity.HoHomie;
import com.homie.backend.sisInterno.repositories.HoHomieRepository;

@Service
public class HoHomieService {
	private HoHomieRepository hoHomieRepository;

	
	public HoHomieService(HoHomieRepository hoHomieRepository) {
		this.hoHomieRepository = hoHomieRepository;
	}
	
	
	public HoHomie registrarHomie(HoHomie hoHomie) {
		hoHomie.setHoFechaRegistro(new Date());
		hoHomie.setHoStatus(StatusHomie.HABILITADO.getKey());
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
	

	
}
