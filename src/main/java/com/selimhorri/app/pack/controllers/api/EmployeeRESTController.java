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

import com.selimhorri.app.pack.models.dto.BossEmployeeDTO;
import com.selimhorri.app.pack.models.entities.Employee;
import com.selimhorri.app.pack.services.EmployeeService;

/**
 * @author Selim Horri
 */
@RestController
@CrossOrigin
@RequestMapping("api/employees")
public class EmployeeRESTController {
	
	private final EmployeeService service;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeRESTController.class);
	
	static {
		logger.info("************ entering " + EmployeeRESTController.class.getName() + " ************");
	}
	
	/**
	 * Inject main Service
	 * @param service
	 */
	@Autowired
	public EmployeeRESTController(final EmployeeService service) {
		this.service = service;
	}
	
	/**
	 * @return all employees
	 */
	@GetMapping(value = {"", "/"})
	public ResponseEntity<List<Employee>> findAll() {
		return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
	}
	
	/**
	 * @param id
	 * @return employee by id
	 */
	@GetMapping(value = {"/{id}", "/get/{id}"})
	public ResponseEntity<Employee> findById(@PathVariable("id") final String id) {
		return new ResponseEntity<>(this.service.findById(Integer.parseInt(id)), HttpStatus.OK);
	}
	
	/**
	 * @param employee
	 * @return saved employee
	 */
	@PostMapping(value = {"", "/", "/save"})
	public ResponseEntity<Employee> save(@RequestBody final Employee employee) {
		return new ResponseEntity<>(this.service.save(employee), HttpStatus.OK);
	}
	
	/**
	 * @param employee
	 * @return updated employee
	 */
	@PutMapping(value = {"", "/", "/update"})
	public ResponseEntity<Employee> update(@RequestBody final Employee employee) {
		return new ResponseEntity<>(this.service.update(employee), HttpStatus.OK);
	}
	
	/**
	 * Delete employee by id
	 * @param id
	 */
	@DeleteMapping(value = {"/{id}", "/delete/{id}"})
	public void delete(@PathVariable("id") final String id) {
		this.service.delete(Integer.parseInt(id));
	}
	
	/**
	 * @return big boss 'KING' of employees
	 */
	@GetMapping(value = {"/boss"})
	public ResponseEntity<BossEmployeeDTO> getBoss() {
		return new ResponseEntity<>(this.service.getBoss(), HttpStatus.OK);
	}
	
	
	
}










