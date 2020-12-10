package com.homie.backend.sisInterno.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.homie.backend.sisInterno.entity.HoUsuario;
import com.homie.backend.sisInterno.repositories.HoUsuarioRepository;

@Service 	 	
public class HoSecurityService  implements UserDetailsService{
	
	@Autowired
	private HoUsuarioRepository hoUsuarioRepository;
	
	
	public HoUsuario findUsuarioByCedula(String cedula){
		return hoUsuarioRepository.findByUsCedula(cedula);
	}
	
	public HoUsuario crearUsuario(HoUsuario hoUsuario) {
		return hoUsuarioRepository.save(hoUsuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		HoUsuario us=findUsuarioByCedula(username);
		UserDetails use= new User(us.getUsCedula(), us.getUsPassword(), null);
		
		return use;
	}

}
