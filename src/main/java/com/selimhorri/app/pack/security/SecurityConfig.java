package com.selimhorri.app.pack.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private DataSource dataSource;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Autowired
	public SecurityConfig(final DataSource dataSource, final BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.dataSource = dataSource;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE LOWER(username) = ?")
			.authoritiesByUsernameQuery("SELECT username, role FROM users WHERE LOWER(username) = ?")
			.dataSource(dataSource)
		.passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/api/**").hasRole("ADMIN_ROLE")
			.antMatchers("/app/departments/**").hasRole("ADMIN_ROLE")
			.antMatchers("/app/employees/**").hasAnyRole("EMP_ROLE", "ADMIN_ROLE")
			// .antMatchers("/app/employees/managers").hasRole("MGR_ROLE")
			.antMatchers("/", "/app").permitAll()
		.and().formLogin();
		
		http.csrf().disable();
	}
	
	/*
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(this.bCryptPasswordEncoder);
	}
	*/
	
	
	
}











