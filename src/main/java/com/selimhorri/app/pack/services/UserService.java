package com.selimhorri.app.pack.services;

import java.util.List;

import com.selimhorri.app.pack.models.entities.UserCredentials;

public interface UserService {
	
	public abstract List<UserCredentials> findAll();
	public abstract UserCredentials findById(final Integer id);
	public abstract UserCredentials findByUsername(final String username);
	
}







