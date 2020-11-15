package com.selimhorri.app.pack.services.impls;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selimhorri.app.pack.models.entities.User;
import com.selimhorri.app.pack.repositories.UserRepository;
import com.selimhorri.app.pack.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private final UserRepository rep;
	
	@Autowired
	public UserServiceImpl(final UserRepository rep) {
		this.rep = rep;
	}
	
	@Override
	public List<User> findAll() {
		return Collections.unmodifiableList(this.rep.findAll());
	}
	
	@Override
	public User findById(final Integer id) {
		return this.rep.findById(id).orElseThrow(() -> new NoSuchElementException(""));
	}
	
	@Override
	public User findByUsername(String username) {
		return this.rep.findByUsername(username);
	}
	
	
	
}







