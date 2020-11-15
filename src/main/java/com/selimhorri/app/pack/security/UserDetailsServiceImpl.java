package com.selimhorri.app.pack.security;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		return new UserDetailsImpl(username.trim()); // gets the username from login view
	}
	
	
	
}










