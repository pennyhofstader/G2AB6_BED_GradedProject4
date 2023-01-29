package com.greatlearning.employeerestapi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.employeerestapi.entity.User;
import com.greatlearning.employeerestapi.repo.UserRepo;

@Service
@Primary
public class DomainUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepo userRepo;

	// find by username method
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.userRepo.findByUsername(username)
				.map(com.greatlearning.employeerestapi.entity.DomainUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("bad credentials"));

	}

}
