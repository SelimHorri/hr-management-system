package com.selimhorri.app.pack.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.selimhorri.app.pack.models.entities.Employee;
import com.selimhorri.app.pack.services.EmployeeService;

@Controller
@RequestMapping(value = {"/app/employees"})
public class EmployeeController {
	
	private final EmployeeService service;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	static {
		logger.info("************ entering " + EmployeeController.class.getName() + " ************");
	}
	
	@Autowired
	public EmployeeController(final EmployeeService service) {
		this.service = service;
	}
	
	@GetMapping(value = {"/employees-list"})
	public String displayEmployeesList(final Model model) {
		
		final List<Employee> employees = this.service.findAll();
		model.addAttribute("size", employees.size());
		model.addAttribute("employees", employees);
		return "employees/employees-list";
	}
	
	@GetMapping(value = {"/employees-add"})
	public String displayEmployeeAdd() {
		return "employees/employees-add";
	}
	
	@PostMapping(value = {"/employees-add"})
	public String handleEmployeeAdd(@ModelAttribute("employee") final Employee employee, final Model model) {
		
		final Employee emp = this.service.save(employee);
		System.err.println(emp);
		model.addAttribute("msg", "Employee saved successfully");
		return "employees/employees-add";
	}
	
	@GetMapping(value = {"/employees-edit/{id}"})
	public String displayEmployeesEdit(@PathVariable("id") final String id, final Model model) {
		
		final Employee employee = this.service.findById(Integer.parseInt(id));
		model.addAttribute("employee", employee);
		return "employees/employees-edit";
	}
	
	@PutMapping(value = {"/employees-edit"})
	public String handleEmployeesEdit(@ModelAttribute("employee") final Employee employee, final Model model) {
		
		final Employee emp = this.service.update(employee);
		System.err.println(emp);
		return "employees/employees-list";
	}
	
	@DeleteMapping(value = {"/employees-delete"})
	public String handleEmployeeDelete() {
		return "redirect:/employees-list";
	}
	
	
	
}









