package com.selimhorri.app.pack.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private UserDetailsService userDetailsService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/**
	 * Inject params
	 * @param userDetailsService
	 * @param bCryptPasswordEncoder
	 */
	@Autowired
	public SecurityConfig(final UserDetailsService userDetailsService, final BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	/**
	 * @param AuthenticationManagerBuilder auth
	 */
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(this.bCryptPasswordEncoder);
	}
	
	
	
	/**
	 * @param HttpSecurity http
	 */
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			// .antMatchers("/api/**").hasRole("ADMIN_ROLE")
			// .antMatchers("/app/**/departments/**").hasRole("ADMIN_ROLE")
			// .antMatchers("/app/**/employees/**").hasAnyRole("EMP_ROLE", "ADMIN_ROLE")
			// .antMatchers("**/managers/**").hasAnyRole("MGR_ROLE", "EMP_ROLE", "ADMIN_ROLE")
			// .antMatchers("/app/employees/managers").hasRole("MGR_ROLE")
			.antMatchers("/", "/app").permitAll()
		.and().formLogin();
	}
	
	
	/*
	private DataSource dataSource;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	*/
	
	/**
	 * 
	 * @param dataSource
	 * @param bCryptPasswordEncoder
	 */
	/*
	@Autowired
	public SecurityConfig(final DataSource dataSource, final BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.dataSource = dataSource;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	*/
	
	/**
	 * 
	 */
	/*
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.usersByUsernameQuery("SELECT username, password, enabled FROM users_credentials WHERE LOWER(username) = ?")
			.authoritiesByUsernameQuery("SELECT username, role FROM users_credentials WHERE LOWER(username) = ?")
			.dataSource(dataSource)
		.passwordEncoder(bCryptPasswordEncoder);
	}
	*/
	
	
	
}











