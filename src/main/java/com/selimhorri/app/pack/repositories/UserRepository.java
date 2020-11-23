package com.selimhorri.app.pack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.selimhorri.app.pack.models.entities.UserCredentials;

@Repository
public interface UserRepository extends JpaRepository<UserCredentials, Integer> {
	
	@Query(name = "UserCredentials.findByUsername", nativeQuery = true)
	public abstract UserCredentials findByUsername(@Param("username") final String username);
	
}








