package com.selimhorri.app.pack.services;

import java.util.List;

import com.selimhorri.app.pack.models.entities.Department;

public interface DepartmentService {
	
	public abstract List<Department> findAll();
	public abstract Department findById(final Integer id);
	public abstract Department save(final Department Department);
	public abstract Department update(final Integer id);
	public abstract void delete(final Integer id);
	
}









