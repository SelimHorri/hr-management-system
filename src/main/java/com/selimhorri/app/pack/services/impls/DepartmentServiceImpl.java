package com.selimhorri.app.pack.services.impls;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selimhorri.app.pack.models.entities.Department;
import com.selimhorri.app.pack.repositories.DepartmentRepository;
import com.selimhorri.app.pack.services.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	
	private final DepartmentRepository rep;
	private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
	
	static {
		logger.info("************ entering " + DepartmentServiceImpl.class.getName() + " ************");
	}
	
	@Autowired
	public DepartmentServiceImpl(final DepartmentRepository rep) {
		this.rep = rep;
	}
	
	@Override
	public List<Department> findAll() {
		return Collections.unmodifiableList(this.rep.findAll());
	}
	
	@Override
	public Department findById(final Integer id) {
		return this.rep.findById(id).orElseThrow(() -> new NoSuchElementException("\n------------ NO ELEMENT FOUND !!!!! ------------\n"));
	}
	
	@Override
	public Department save(final Department department) {
		return this.rep.save(department);
	}
	
	@Override
	public Department update(final Department department) {
		return this.rep.save(department);
	}
	
	@Override
	public void delete(final Integer id) {
		this.rep.delete(this.findById(id));
	}
	
	
	
}









