package com.selimhorri.app.pack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selimhorri.app.pack.models.entities.Department;

/**
 * @author Selim Horri
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
	
	
}








