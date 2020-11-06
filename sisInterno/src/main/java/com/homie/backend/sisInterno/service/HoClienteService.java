package com.homie.backend.sisInterno.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.homie.backend.sisInterno.entity.HoCliente;
import com.homie.backend.sisInterno.repositories.HoClienteRepository;

@Service
public class HoClienteService {
	private HoClienteRepository hoClienteRepository;

	public HoClienteService(HoClienteRepository hoClienteRepository) {
		this.hoClienteRepository = hoClienteRepository;
	}

	public HoCliente registrarCliente(HoCliente hoCliente) {
		hoCliente.setClFechaRegistro(new Date());
		if (hoClienteRepository.findByClCedulaRuc(hoCliente.getClCedulaRuc()) != null) {
			return null;
		}
		return hoClienteRepository.save(hoCliente);
	}

	public HoCliente editarCliente(HoCliente hoCliente) {
		return hoClienteRepository.save(hoCliente);
	}

	public List<HoCliente> listarClientes() {

		return (List<HoCliente>) hoClienteRepository.findAll();

	}

	public List<HoCliente> findByNombre(String name) {
		System.out.println("name_ "+name);
		return hoClienteRepository.findByClNombreContaining(name);
	}

}
