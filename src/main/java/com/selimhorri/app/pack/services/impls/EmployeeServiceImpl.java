package com.selimhorri.app.pack.services.impls;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selimhorri.app.pack.models.dto.BossEmployeeDTO;
import com.selimhorri.app.pack.models.entities.Employee;
import com.selimhorri.app.pack.repositories.EmployeeRepository;
import com.selimhorri.app.pack.services.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepository rep;
	private final ModelMapper modelMapper;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	static {
		logger.info("************ entering " + EmployeeServiceImpl.class.getName() + " ************");
	}
	
	/**
	 * Inject main Service
	 * @param rep
	 * @param modelMapper
	 */
	@Autowired
	public EmployeeServiceImpl(final EmployeeRepository rep, final ModelMapper modelMapper) {
		this.rep = rep;
		this.modelMapper = modelMapper;
	}
	
	/**
	 * @return unmodifiable list of employees
	 */
	@Override
	public List<Employee> findAll() {
		return Collections.unmodifiableList(this.rep.findAll());
	}
	
	/**
	 * @param id
	 * @return an employee by id
	 */
	@Override
	public Employee findById(final Integer id) {
		return this.rep.findById(id).orElseThrow(() -> new NoSuchElementException("\n------------ NO ELEMENT FOUND !!!!! ------------\n"));
	}
	
	/**
	 * save an employee
	 * @param employee
	 * @return an employee
	 */
	@Override
	public Employee save(final Employee employee) {
		return this.rep.save(employee);
	}
	
	/**
	 * update an employee
	 * @param employee
	 * @return an employee
	 */
	@Override
	public Employee update(final Employee employee) {
		return this.rep.save(employee);
	}
	
	/**
	 * delete an employee by id
	 * @param id
	 */
	@Override
	public void delete(final Integer id) {
		this.rep.delete(this.findById(id));
	}
	
	/**
	 * get the big BOSS
	 * @return BossEmployeeDTO
	 */
	@Override
	public BossEmployeeDTO getBoss() {
		return this.modelMapper.map(this.rep.getBoss(), BossEmployeeDTO.class);
	}
	
	
	
}









