package com.homie.backend.sisInterno.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homie.backend.sisInterno.dto.TokenDto;
import com.homie.backend.sisInterno.entity.HoUsuario;
import com.homie.backend.sisInterno.repositories.HoUsuarioRepository;
import com.homie.backend.sisInterno.service.HoSecurityService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UserController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private HoUsuarioRepository hoUserRepository;
	
	@Autowired
	private HoSecurityService hoSecurityService;

	@PostMapping("user")
	public ResponseEntity<TokenDto> login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		HoUsuario user = new HoUsuario();
		user = this.hoUserRepository.findByUsCedula(username);
		if (user != null && passwordEncoder.matches( pwd, user.getUsPassword()) && user.getHoRol() != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(getJWTToken(user)) ;
		} else {
			return null;
		}
	}

	@PostMapping("createuser")
	private ResponseEntity<HoUsuario> createUser(@RequestBody HoUsuario entity){
		entity.setUsPassword(passwordEncoder.encode(entity.getUsPassword()));
		HoUsuario us= hoSecurityService.crearUsuario(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(us);
	} 

	private TokenDto getJWTToken(HoUsuario usuario) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(usuario.getHoRol().getRoNombre());

		String token = Jwts.builder().setId("homie").setSubject(usuario.getUsCedula())
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		TokenDto tok = new TokenDto(token);
		return tok;
	}
	
	
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
}
