package com.greatlearning.employeerestapi.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	private UserDetailsService userDetailsService;

	// authorization and authentication setup

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(this.userDetailsService);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().disable();
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/addNewEmployee").hasAnyRole("ADMIN")
				.antMatchers(HttpMethod.GET, "/api/listAllEmployees").hasAnyRole("ADMIN", "USER")
				.antMatchers(HttpMethod.GET, "/api/getEmployeeById/{id}").hasAnyRole("ADMIN", "USER")
				.antMatchers(HttpMethod.GET, "/api/getEmployeesSortedByName").hasAnyRole("ADMIN", "USER")
				.antMatchers(HttpMethod.GET, "/api/searchByFirstName").hasAnyRole("ADMIN", "USER")
				.antMatchers(HttpMethod.DELETE, "/api/deleteEmployeeById/{id}").hasAnyRole("ADMIN", "USER")
				.antMatchers(HttpMethod.PUT, "api/update/{id}").hasAnyRole("ADMIN", "USER")
				.antMatchers(HttpMethod.PUT, "/addRole").hasAnyRole("ADMIN", "USER")
				.antMatchers(HttpMethod.PUT, "/addUser").hasAnyRole("ADMIN", "USER").anyRequest().fullyAuthenticated()
				.and().httpBasic();

	}

}
