package com.selimhorri.app.pack.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selimhorri.app.pack.models.entities.UserCredential;
import com.selimhorri.app.pack.services.UserCredentialService;

@RestController
@RequestMapping("/api/user-credentials")
public class UserCredentialRESTController {
	
	private final UserCredentialService service;
	
	@Autowired
	public UserCredentialRESTController(UserCredentialService service) {
		this.service = service;
	}
	
	@GetMapping(value = {"/{id}"})
	public ResponseEntity<UserCredential> findById(@PathVariable("id") final Integer id) {
		return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
	}
	
	
	
}








