package com.homie.backend.sisInterno.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {
	
	
	@RequestMapping("/holaMundo")
	public String saludar() {
		return "Hola mundo desde la gato " ;
			
		
	}

}
