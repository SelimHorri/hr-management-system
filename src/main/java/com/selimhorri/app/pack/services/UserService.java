package com.selimhorri.app.pack.services;

import java.util.List;

import com.selimhorri.app.pack.models.entities.User;

public interface UserService {
	
	public abstract List<User> findAll();
	public abstract User findById(final Integer id);
	public abstract User findByUsername(final String username);
	
}







