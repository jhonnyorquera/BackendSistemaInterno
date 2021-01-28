package com.homie.backend.sisInterno.entity;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.envers.RevisionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;



public class CustomRevisionListener implements RevisionListener {
	
	 @Autowired 
	 private HttpServletRequest httpServletRequest;
	 
	 
 
	public void newRevision(Object revisionEntity) {
		final Revision revision = (Revision) revisionEntity;
		revision.setUserName(getThreadAccountUserName());
		revision.setDate(new Date());
		
		
		getIpAdress();
    }
 
	private String getThreadAccountUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
        if (!authentication.isAuthenticated()) {
            return null;
        }
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
 
        return (authentication.getPrincipal()).toString();
        
	}
 
	
	private String getIpAdress() {
		
		System.out.println(httpServletRequest.getRemoteHost());
		
		System.out.println(httpServletRequest.getRequestURI());
		System.out.println(httpServletRequest.getRemoteAddr());

		return "asdf";
		
	}
}