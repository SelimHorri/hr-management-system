package com.selimhorri.app.pack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.selimhorri.app.pack.models.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(name = "User.findByUsername", nativeQuery = true)
	public abstract User findByUsername(@Param("username") final String username);
	
}








