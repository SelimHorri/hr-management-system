package com.selimhorri.app.pack.services;

import java.util.List;

import com.selimhorri.app.pack.models.entities.UserCredential;

public interface UserCredentialService {
	
	public abstract List<UserCredential> findAll();
	public abstract UserCredential findById(final Integer id);
	public abstract UserCredential findByUsername(final String username);
	
}







