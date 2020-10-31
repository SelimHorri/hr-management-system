package com.selimhorri.app.pack.services.impls;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
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
	
	@Autowired
	public EmployeeServiceImpl(final EmployeeRepository rep, final ModelMapper modelMapper) {
		this.rep = rep;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public List<Employee> findAll() {
		return this.rep.findAll();
	}
	
	@Override
	public Employee findById(final Integer id) {
		return this.rep.findById(id).orElseThrow(() -> new NoSuchElementException("\n------------ NO ELEMENT FOUND !!!!! ------------\n"));
	}
	
	@Override
	public Employee save(final Employee employee) {
		return this.rep.save(employee);
	}
	
	@Override
	public Employee update(final Employee employee) {
		return this.rep.save(employee);
	}
	
	@Override
	public void delete(final Integer id) {
		this.rep.delete(this.findById(id));
	}
	
	@Override
	public BossEmployeeDTO getBoss() {
		return this.modelMapper.map(this.rep.getBoss(), BossEmployeeDTO.class);
	}
	
	
	
}









