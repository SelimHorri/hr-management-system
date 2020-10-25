package com.selimhorri.app.pack.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selimhorri.app.pack.models.dto.BossEmployeeDTO;
import com.selimhorri.app.pack.models.entities.Employee;
import com.selimhorri.app.pack.services.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeRESTController {
	
	private final EmployeeService service;
	
	@Autowired
	public EmployeeRESTController(final EmployeeService service) {
		this.service = service;
	}
	
	@GetMapping(value = {"/"})
	public List<Employee> findAll() {
		return this.service.findAll();
	}
	
	@GetMapping(value = {"/boss"})
	public BossEmployeeDTO getBoss() {
		return this.service.getBoss();
	}
	
	
	
}










