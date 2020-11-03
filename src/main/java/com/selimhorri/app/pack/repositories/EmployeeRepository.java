package com.selimhorri.app.pack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.selimhorri.app.pack.models.entities.Employee;

/**
 * @author Selim Horri
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query(name = "BossEmployeeDTO.getBoss", nativeQuery = true)
	public abstract Employee getBoss();
	
}








