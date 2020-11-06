package com.homie.backend.sisInterno.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homie.backed.sisInterno.enums.StatusHomie;
import com.homie.backend.sisInterno.entity.HoCatalogo;
import com.homie.backend.sisInterno.entity.HoCliente;
import com.homie.backend.sisInterno.entity.HoHomie;
import com.homie.backend.sisInterno.repositories.HoCatalogoRepository;
import com.homie.backend.sisInterno.repositories.HoClienteRepository;
import com.homie.backend.sisInterno.repositories.HoHomieRepository;

@Service
public class crearEsquemas {

	@Autowired
	HoHomieRepository hoHomieRepository;
	@Autowired
	HoClienteRepository clienteRepository;
	@Autowired
	HoCatalogoRepository hoCatalogoRepository;

	public int crearEsquema() {

		int valorIteracion = 10;

		crearHomies(valorIteracion);
		crearClientes(valorIteracion);
		crearCatalogo();
		return valorIteracion;
	}

	private List<HoHomie> crearHomies(int cantidad) {
		System.out.println("entra a crear homies");
		List<HoHomie> homies = new ArrayList<>();
		for (int i = 0; i < cantidad; i++) {
			HoHomie homie = new HoHomie();
			homie.setHoCedula("172026886" + i);
			homie.setHoNombre("HOMIE " + i + " HOMIE " + i + " HOMIE " + i + " HOMIE");
			homie.setHoFechaIngreso(new Date());
			homie.setHoModalidad("FREE LANCE");
			homie.setHoStatus(StatusHomie.HABILITADO.getKey());
			homies.add(hoHomieRepository.save(homie));
		}
		return homies;

	}

	private List<HoCliente> crearClientes(int clientes) {

		List<HoCliente> clientesCrear = new ArrayList<>();

		Random random = new Random();
		for (int a = 0; a < clientes; a++) {

			HoCliente cli = new HoCliente();
			cli.setClCedulaRuc("172026886" + a);
			cli.setClCorreo(a + "corre@hotmail.com");
			cli.setClNombre(a+"Nombre"+a+" Apellido"+a+" LAST NAME");
			cli.setClDireccion(random.ints(10, 1, 7).toString() + "interseccion" + random.ints(10, 1, 7).toString());
			cli.setClFechaRegistro(new Date());
			cli.setClSector(random.ints(10, 11, 12).toString());
			clienteRepository.save(cli);

		}

		return clientesCrear;

	}

	private List<HoCatalogo> crearCatalogo() {
		List<HoCatalogo> catalogo = new ArrayList<>();

		HoCatalogo catalogoVar = new HoCatalogo();
		catalogoVar.setSeNombre("LIMPIEZA HOGAR");
		catalogoVar.setSeNombreDetalle("LIMIPIEZA HOGAR 8 HORAS");
		catalogoVar.setSeValor(35.00);
		catalogoVar.setSeCantidad(8);
		catalogo.add(hoCatalogoRepository.save(catalogoVar));

		catalogoVar = new HoCatalogo();
		catalogoVar.setSeNombre("LIMPIEZA HOGAR");
		catalogoVar.setSeNombreDetalle("LIMIPIEZA HOGAR 2 HORAS");
		catalogoVar.setSeValor(14.00);
		catalogoVar.setSeCantidad(2);
		catalogo.add(hoCatalogoRepository.save(catalogoVar));

		catalogoVar = new HoCatalogo();
		catalogoVar.setSeNombre("LIMPIEZA HOGAR");
		catalogoVar.setSeNombreDetalle("LIMIPIEZA HOGAR 4 HORAS");
		catalogoVar.setSeValor(23.00);
		catalogoVar.setSeCantidad(4);
		catalogo.add(hoCatalogoRepository.save(catalogoVar));

		catalogoVar = new HoCatalogo();
		catalogoVar.setSeNombre("LIMPIEZA OFICINA");
		catalogoVar.setSeNombreDetalle("LIMIPIEZA OFICINA 2 HORAS");
		catalogoVar.setSeValor(15.00);
		catalogoVar.setSeCantidad(2);
		catalogo.add(hoCatalogoRepository.save(catalogoVar));

		catalogoVar = new HoCatalogo();
		catalogoVar.setSeNombre("LIMPIEZA OFICINA");
		catalogoVar.setSeNombreDetalle("LIMIPIEZA OFICINA 4 HORAS");
		catalogoVar.setSeValor(24.00);
		catalogoVar.setSeCantidad(4);
		catalogo.add(hoCatalogoRepository.save(catalogoVar));

		catalogoVar = new HoCatalogo();
		catalogoVar.setSeNombre("LIMPIEZA OFICINA");
		catalogoVar.setSeNombreDetalle("LIMIPIEZA OFICINA 8 HORAS");
		catalogoVar.setSeValor(36.00);
		catalogoVar.setSeCantidad(8);
		catalogo.add(hoCatalogoRepository.save(catalogoVar));

		return catalogo;

	}

}
