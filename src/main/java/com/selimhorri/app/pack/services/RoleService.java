package com.selimhorri.app.pack.services;

import java.util.List;

import com.selimhorri.app.pack.models.entities.Role;

public interface RoleService {
	
	public abstract List<Role> findAll();
	public abstract Role findById(final Integer id);
	
}








