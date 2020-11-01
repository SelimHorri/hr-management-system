package com.selimhorri.app.pack.controllers.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selimhorri.app.pack.models.entities.Department;
import com.selimhorri.app.pack.services.DepartmentService;

/**
 * @author Selim Horri
 */
@RestController
@CrossOrigin
@RequestMapping("api/departments")
public class DepartmentRESTController {
	
	private final DepartmentService service;
	
	private static final Logger logger = LoggerFactory.getLogger(DepartmentRESTController.class);
	
	static {
		logger.info("************ entering " + DepartmentRESTController.class.getName() + " ************");
	}
	
	/**
	 * Inject main Service
	 * @param service
	 */
	@Autowired
	public DepartmentRESTController(final DepartmentService service) {
		this.service = service;
	}
	
	/**
	 * @return all departments
	 */
	@GetMapping(value = {"", "/"})
	public ResponseEntity<List<Department>> findAll() {
		return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
	}
	
	/**
	 * @param id
	 * @return department by id
	 */
	@GetMapping(value = {"/{id}", "/get/{id}"})
	public ResponseEntity<Department> findById(@PathVariable("id") final String id) {
		return new ResponseEntity<>(this.service.findById(Integer.parseInt(id)), HttpStatus.OK);
	}
	
	/**
	 * @param department
	 * @return saved department
	 */
	@PostMapping(value = {"", "/", "/save"})
	public ResponseEntity<Department> save(@RequestBody final Department department) {
		return new ResponseEntity<>(this.service.save(department), HttpStatus.OK);
	}
	
	/**
	 * @param department
	 * @return updated department
	 */
	@PutMapping(value = {"", "/", "/update"})
	public ResponseEntity<Department> update(@RequestBody final Department department) {
		return new ResponseEntity<>(this.service.update(department), HttpStatus.OK);
	}
	
	/**
	 * Delete department by id
	 * @param id
	 */
	@DeleteMapping(value = {"/{id}", "/delete/{id}"})
	public void delete(@PathVariable("id") final String id) {
		this.service.delete(Integer.parseInt(id));
	}
	
	
	
}










