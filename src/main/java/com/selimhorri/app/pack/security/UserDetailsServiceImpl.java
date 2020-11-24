package com.selimhorri.app.pack.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.selimhorri.app.pack.services.UserCredentialService;

@Service
@Lazy
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private final UserCredentialService service;
	
	/**
	 * @Inject service
	 * @param rep
	 */
	@Autowired
	public UserDetailsServiceImpl(UserCredentialService service) {
		this.service = service;
	}
	
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		return new UserDetailsImpl(this.service.findByUsername(username.toLowerCase().trim())); // gets the username from login view
	}
	
	
	
}










