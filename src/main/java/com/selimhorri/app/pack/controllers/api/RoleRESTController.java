package com.selimhorri.app.pack.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selimhorri.app.pack.models.entities.Role;
import com.selimhorri.app.pack.services.RoleService;

@RestController
@Lazy
@RequestMapping("/api/roles")
public class RoleRESTController {
	
	private final RoleService service;
	
	@Autowired
	public RoleRESTController(RoleService service) {
		this.service = service;
	}
	
	public ResponseEntity<List<Role>> findAll() {
		return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
	}
	
	
	
}









