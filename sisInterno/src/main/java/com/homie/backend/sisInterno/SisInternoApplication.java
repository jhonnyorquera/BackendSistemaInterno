package com.homie.backend.sisInterno;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SisInternoApplication {

		public static void main(String[] args) {
		SpringApplication.run(SisInternoApplication.class, args);
		System.out.println("----------Backend Levantado-----");
	}


}
