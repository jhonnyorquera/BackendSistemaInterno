package com.homie.backend.sisInterno;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.homie.backend.sisInterno.entity.HoHomie;
import com.homie.backend.sisInterno.repositories.HoHomieRepository;

@SpringBootTest
class SisInternoApplicationTests {
	
	@Autowired
	HoHomieRepository hoHomieRepository;

	@Test
	void crearUsuario() {

		int cantidad =10;
		for (int i = 0; i < cantidad; i++) {
			HoHomie homie = new HoHomie();
			homie.setHoCedula("00000" + i);
			homie.setHoNombre("HOMIE " + i + " HOMIE " + i + " HOMIE " + i + " HOMIE");
			homie.setHoFechaIngreso(new Date());
			homie.setHoModalidad("FREE LANCE");
			
			hoHomieRepository.save(homie);

		}

	}

}
