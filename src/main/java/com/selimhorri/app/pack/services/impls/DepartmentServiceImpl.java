package com.selimhorri.app.pack.services.impls;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selimhorri.app.pack.models.entities.Department;
import com.selimhorri.app.pack.repositories.DepartmentRepository;
import com.selimhorri.app.pack.services.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	
	private final DepartmentRepository rep;
	
	@Autowired
	public DepartmentServiceImpl(final DepartmentRepository rep) {
		this.rep = rep;
	}
	
	@Override
	public List<Department> findAll() {
		return this.rep.findAll();
	}
	
	@Override
	public Department findById(final Integer id) {
		return this.rep.findById(id).orElseThrow(() -> new NoSuchElementException("\n------------ NO ELEMENT FOUND !!!!! ------------\n"));
	}
	
	@Override
	public Department save(final Department Department) {
		return this.rep.save(Department);
	}
	
	@Override
	public Department update(final Integer id) {
		return this.rep.save(this.findById(id));
	}
	
	@Override
	public void delete(final Integer id) {
		this.rep.delete(this.findById(id));
	}
	
	
	
}









