package com.selimhorri.app.pack.services.impls;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.selimhorri.app.pack.models.entities.UserCredential;
import com.selimhorri.app.pack.repositories.UserCredentialRepository;
import com.selimhorri.app.pack.services.UserCredentialService;

@Service
@Transactional
public class UserCredentialServiceImpl implements UserCredentialService {
	
	private final UserCredentialRepository rep;
	
	@Autowired
	public UserCredentialServiceImpl(final UserCredentialRepository rep) {
		this.rep = rep;
	}
	
	@Override
	public List<UserCredential> findAll() {
		return Collections.unmodifiableList(this.rep.findAll());
	}
	
	@Override
	public UserCredential findById(final Integer id) throws NoSuchElementException {
		return this.rep.findById(id).orElseThrow(() -> new NoSuchElementException("-------------- NO SUCH ELEMENT id = " + id + " --------------"));
	}
	
	@Override
	public UserCredential findByUsername(final String username) throws UsernameNotFoundException {
		return this.rep.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("-------------- NO SUCH ELEMENT by username: " + username + " --------------"));
	}
	
	
	
}







