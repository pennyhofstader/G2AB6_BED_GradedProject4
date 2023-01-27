package com.greatlearning.employeerestapi.util;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.employeerestapi.entity.Role;
import com.greatlearning.employeerestapi.entity.User;
import com.greatlearning.employeerestapi.repo.EmployeeRepo;
import com.greatlearning.employeerestapi.repo.UserRepo;

@Configuration
public class BootstrapAppData {
	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private UserRepo userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public BootstrapAppData(EmployeeRepo employeeRepo, UserRepo userRepository, PasswordEncoder passwordEncoder) {
		this.employeeRepo = employeeRepo;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void onReady(ApplicationReadyEvent event) {
		User user = new User();

		user.setUsername("admin");

		user.setPassword(this.passwordEncoder.encode("admin"));

		User user2 = new User();
		user2.setUsername("user2");
		user2.setPassword(this.passwordEncoder.encode("users"));
		
		Role admin = new Role();
		admin.setName("ROLE_ADMIN");

		Role customer = new Role();
		customer.setName("ROLE_USER");

		user.getRoles().add(admin);
		user2.getRoles().add(customer);

		userRepository.save(user);
		userRepository.save(user2);

	}

}
