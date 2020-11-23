package com.selimhorri.app.pack.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.selimhorri.app.pack.models.entities.Employee;
import com.selimhorri.app.pack.services.EmployeeService;

/**
 * @author Selim Horri
 */
@Controller
@RequestMapping(value = {"/app/employees"})
public class EmployeeController {
	
	private final EmployeeService service;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	static {
		logger.info("************ entering " + EmployeeController.class.getName() + " ************");
	}
	
	/**
	 * Inject main Service
	 * @param service
	 */
	@Autowired
	public EmployeeController(final EmployeeService service) {
		this.service = service;
	}
	
	/**
	 * Display employees-list view
	 * @param model
	 * @return employees-list view
	 */
	@GetMapping(value = {"/employees-list"})
	public String displayEmployeesList(final Model model) {
		
		final List<Employee> employees = this.service.findAll();
		model.addAttribute("size", employees.size() + " " + this.getClass().getSimpleName().replace("Controller", "") + "s");
		model.addAttribute("employees", employees);
		return "employees/employees-list";
	}
	
	/**
	 * Display employees-add view
	 * @return employees-add view
	 */
	@GetMapping(value = {"/employees-add"})
	public String displayEmployeeAdd(final Model model) {
		model.addAttribute("employee", new Employee());
		return "employees/employees-add";
	}
	
	/**
	 * Save employee
	 * @param employee
	 * @param model
	 * @param error
	 * @return employees-add view
	 */
	@PostMapping(value = {"/employees-add"})
	public String handleEmployeeAdd(@ModelAttribute("employee") final Employee employee, final BindingResult error, final Model model) {
		
		if (error.hasErrors()) {
			System.err.println(error);
			return "redirect:/app/employees/employees-list";
		}
		
		final Employee emp = this.service.save(employee);
		 System.err.println(emp);
		model.addAttribute("msgColour", "success");
		model.addAttribute("msg", "Employee saved successfully");
		return "employees/employees-add";
	}
	
	/**
	 * Display employees-edit view
	 * @param id
	 * @param model
	 * @return employees-edit view
	 */
	@GetMapping(value = {"/employees-edit"})
	public String displayEmployeesEdit(@RequestParam("id") final String id, final Model model) {
		
		final Employee employee = this.service.findById(Integer.parseInt(id));
		model.addAttribute("employee", employee);
		return "employees/employees-edit";
	}
	
	/**
	 * Update department
	 * @param employee
	 * @param model
	 * @param error
	 * @return employees-list view
	 */
	@PostMapping(value = {"/employees-edit"})
	public String handleEmployeesEdit(@ModelAttribute("employee") final Employee employee, final BindingResult error, final Model model) {
		
		if (error.hasErrors()) {
			System.err.println(error);
			return "redirect:/app/employees/employees-list";
		}
		
		final Employee emp = this.service.update(employee);
		 System.err.println(emp);
		model.addAttribute("msgColour", "success");
		model.addAttribute("msg", "Employee updated successfully!");
		return "employees/employees-edit";
	}
	
	/**
	 * Delete an existing department by its id
	 * @return employees-list view
	 */
	@GetMapping(value = {"/employees-delete"})
	public String handleEmployeeDelete(@RequestParam("id") final String id) {
		this.service.delete(Integer.parseInt(id));
		return "redirect:/app/employees/employees-list";
	}
	
	
	
}









