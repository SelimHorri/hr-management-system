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

import com.selimhorri.app.pack.models.entities.Department;
import com.selimhorri.app.pack.services.DepartmentService;

/**
 * @author Selim Horri
 */
@Controller
@RequestMapping(value = {"/app/departments"})
public class DepartmentController {
	
	private final DepartmentService service;
	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	static {
		logger.info("************ entering " + DepartmentController.class.getName() + " ************");
	}
	
	/**
	 * Inject main Service
	 * @param service
	 */
	@Autowired
	public DepartmentController(final DepartmentService service) {
		this.service = service;
	}
	
	/**
	 * Display departments-list view
	 * @param model
	 * @return departments-list view
	 */
	@GetMapping(value = {"/departments-list"})
	public String displayDepartmentsList(final Model model) {
		
		final List<Department> departments = this.service.findAll();
		model.addAttribute("size", departments.size() + " " + this.getClass().getSimpleName().replace("Controller", "") + "s");
		model.addAttribute("departments", departments);
		return "departments/departments-list";
	}
	
	/**
	 * Display departments-add view
	 * @return departments-add view
	 */
	@GetMapping(value = {"/departments-add"})
	public String displayDepartmentAdd(final Model model) {
		model.addAttribute("department", new Department());
		return "departments/departments-add";
	}
	
	/**
	 * Save department
	 * @param department
	 * @param model
	 * @param error
	 * @return departments-add view
	 */
	@PostMapping(value = {"/departments-add"})
	public String handleDepartmentAdd(@ModelAttribute("department") final Department department, final BindingResult error, final Model model) {
		
		if (error.hasErrors()) {
			System.err.println(error);
			return "redirect:/app/departments/departments-list";
		}
		
		final Department dept = this.service.save(department);
		System.err.println(dept);
		model.addAttribute("msgColour", "success");
		model.addAttribute("msg", "Department saved successfully");
		return "departments/departments-add";
	}
	
	/**
	 * Display departments-edit view
	 * @param id
	 * @param model
	 * @return departments-edit view
	 */
	@GetMapping(value = {"/departments-edit"})
	public String displayDepartmentsEdit(@RequestParam("id") final String id, final Model model) {
		
		final Department department = this.service.findById(Integer.parseInt(id));
		model.addAttribute("department", department);
		return "departments/departments-edit";
	}
	
	/**
	 * Update department
	 * @param department
	 * @param model
	 * @param error
	 * @return departments-list view
	 */
	@PostMapping(value = {"/departments-edit"})
	public String handleDepartmentsEdit(@ModelAttribute("department") final Department department, final BindingResult error, final Model model) {
		
		if (error.hasErrors()) {
			System.err.println(error);
			return "redirect:/app/departments/departments-list";
		}
		
		final Department dept = this.service.update(department);
		System.err.println(dept);
		model.addAttribute("msgColour", "success");
		model.addAttribute("msg", "Department updated successfully!");
		return "departments/departments-edit";
	}
	
	/**
	 * Delete an existing department by its id
	 * @return departments-list view
	 */
	@GetMapping(value = {"/departments-delete"})
	public String handleDepartmentDelete(@RequestParam("id") final String id) {
		this.service.delete(Integer.parseInt(id));
		return "redirect:/app/departments/departments-list";
	}
	
	
	
}









