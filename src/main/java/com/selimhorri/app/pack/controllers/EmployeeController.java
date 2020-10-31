package com.selimhorri.app.pack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
	
	@GetMapping(value = {"/"})
	public String displayIndex() {
		return "home";
	}
	
	
	
}









