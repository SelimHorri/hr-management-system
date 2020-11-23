package com.selimhorri.app.pack.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selimhorri.app.pack.models.entities.UserCredentials;
import com.selimhorri.app.pack.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserRESTController {
	
	private final UserService service;
	
	@Autowired
	public UserRESTController(UserService service) {
		this.service = service;
	}
	
	@GetMapping(value = {"/{id}"})
	public UserCredentials findById(@PathVariable("id") final Integer id) {
		return this.service.findById(id);
	}
	
	
	
}








