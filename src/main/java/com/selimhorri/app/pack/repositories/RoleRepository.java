package com.selimhorri.app.pack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selimhorri.app.pack.models.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	
	
}







