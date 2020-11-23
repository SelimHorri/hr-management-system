package com.selimhorri.app.pack.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selimhorri.app.pack.models.entities.UserCredential;
import com.selimhorri.app.pack.services.UserCredentialService;

@RestController
@RequestMapping("/api/users")
public class UserCredentialRESTController {
	
	private final UserCredentialService service;
	
	@Autowired
	public UserCredentialRESTController(UserCredentialService service) {
		this.service = service;
	}
	
	@GetMapping(value = {"/{id}"})
	public UserCredential findById(@PathVariable("id") final Integer id) {
		return this.service.findById(id);
	}
	
	
	
}








