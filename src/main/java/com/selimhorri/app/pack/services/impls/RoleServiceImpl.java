package com.selimhorri.app.pack.services.impls;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selimhorri.app.pack.models.entities.Role;
import com.selimhorri.app.pack.repositories.RoleRepository;
import com.selimhorri.app.pack.services.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	
	private final RoleRepository rep;
	
	@Autowired
	public RoleServiceImpl(RoleRepository rep) {
		this.rep = rep;
	}
	
	@Override
	public List<Role> findAll() {
		return Collections.unmodifiableList(this.rep.findAll());
	}

	@Override
	public Role findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}










