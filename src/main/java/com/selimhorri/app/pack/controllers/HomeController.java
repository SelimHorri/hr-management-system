package com.selimhorri.app.pack.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/", "/app"})
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	static {
		logger.info("************ entering " + HomeController.class.getName() + " ************");
	}
	
	@GetMapping(value = {""})
	public String displayIndex(final Model model) {
		model.addAttribute("name", "selim");
		return "home/home";
	}
	
	/*
	public String displayIndex2() {
		return "redirect:/app";
	}
	*/
	
	
	
}










