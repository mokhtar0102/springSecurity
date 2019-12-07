package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.EtudiantRepository;
import com.example.demo.entity.Etudiant;

import antlr.collections.List;

@RestController
public class EtudiantService {

	@Autowired
	private EtudiantRepository etudiantRepository ;
	
	
	@Secured(value= {"ROLE_ADMIN","ROLE_SCOLARITE"}) //prefix de spring security ROLE_
	@RequestMapping(value="/save-etudiant", method=RequestMethod.GET)
	public Etudiant saveEtudiant (Etudiant e) {
		return etudiantRepository.save(e);
	}

@RequestMapping(value="/liste-etudiant")
public java.util.List<Etudiant> listEtudiant ()
{
		return etudiantRepository.findAll();
}


//////////////////////////

	@RequestMapping(value="/getuser")
	public Map<String, Object> getLogerUser(HttpServletRequest httpServletRequest){
		HttpSession httpSession=httpServletRequest.getSession();
		SecurityContext securityContext=(SecurityContext)
				httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
		String username=securityContext.getAuthentication().getName();
		java.util.List<String> roles=new ArrayList<>();
		for (GrantedAuthority ga:securityContext.getAuthentication().getAuthorities()) {
			roles.add(ga.getAuthority());
		}
		Map<String, Object> params=new HashMap<>();
		params.put("username", username);
		params.put("roles", roles);
	
		return params ;
		}
}
