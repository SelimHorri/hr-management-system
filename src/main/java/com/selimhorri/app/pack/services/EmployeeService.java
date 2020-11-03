package com.selimhorri.app.pack.services;

import java.util.List;

import com.selimhorri.app.pack.models.dto.BossEmployeeDTO;
import com.selimhorri.app.pack.models.entities.Employee;

/**
 * @author Selim Horri
 */
public interface EmployeeService {
	
	public abstract List<Employee> findAll();
	public abstract Employee findById(final Integer id);
	public abstract Employee save(final Employee employee);
	public abstract Employee update(final Employee employee);
	public abstract void delete(final Integer id);
	public abstract BossEmployeeDTO getBoss();
	
}









