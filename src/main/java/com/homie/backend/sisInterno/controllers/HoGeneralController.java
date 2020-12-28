package com.homie.backend.sisInterno.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homie.backend.sisInterno.dto.DashboardDto;
import com.homie.backend.sisInterno.service.HoDashboardService;

@RestController
@RequestMapping("/api/HoDash")
public class HoGeneralController {

	@Autowired
	private HoDashboardService hoDasboardService;

	@GetMapping
	public ResponseEntity<DashboardDto> getDash() {
		DashboardDto dash = hoDasboardService.getInfoDashboard();
		return new ResponseEntity<DashboardDto>(dash, HttpStatus.OK);
	}

}