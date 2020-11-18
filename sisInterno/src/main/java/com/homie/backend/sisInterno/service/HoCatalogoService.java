package com.homie.backend.sisInterno.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.homie.backend.sisInterno.entity.HoCatalogo;
import com.homie.backend.sisInterno.repositories.HoCatalogoRepository;

@Service
public class HoCatalogoService {
	private HoCatalogoRepository hoCatalogoRepository;

	
	public HoCatalogoService(HoCatalogoRepository hoCatalogoRepository) {
		this.hoCatalogoRepository = hoCatalogoRepository;
	}
	
	
	public HoCatalogo registrarCatalogo(HoCatalogo hoCatalogo) {
		return hoCatalogoRepository.save(hoCatalogo);
	}
	
	
	public HoCatalogo editarCatalogo(HoCatalogo hoCatalogo) {
		hoCatalogo.setSeNombre(hoCatalogo.getSeNombre().toUpperCase());
		return hoCatalogoRepository.save(hoCatalogo);
	}
	
	
	public List<HoCatalogo> listarCatalogo() {
		
		return (List<HoCatalogo>) hoCatalogoRepository.findAll();
		
	}
	
}
