package com.greatlearning.employeerestapi.util;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.employeerestapi.entity.Employee;
import com.greatlearning.employeerestapi.entity.Role;
import com.greatlearning.employeerestapi.entity.User;
import com.greatlearning.employeerestapi.repo.EmployeeRepo;
import com.greatlearning.employeerestapi.repo.RoleRepo;
import com.greatlearning.employeerestapi.repo.UserRepo;

@Configuration
public class BootstrapAppData {
	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private UserRepo userRepository;

	@Autowired
	private RoleRepo roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public BootstrapAppData(EmployeeRepo employeeRepo, UserRepo userRepository, PasswordEncoder passwordEncoder) {
		this.employeeRepo = employeeRepo;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	// adding employees
	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void usersData(ApplicationReadyEvent readyEvent) {

		Employee e1 = new Employee("anu", "bedi", "anu@gmail.com");
		Employee e2 = new Employee("khushi", "bedi", "khushi@gmail.com");
		Employee e3 = new Employee("rahul", "singh", "rahul@gmail.com");
		Employee e4 = new Employee("dipneet", "kaur", "dip@gmail.com");
		Employee e5 = new Employee("rohan", "mehra", "rohan@gmail.com");

		this.employeeRepo.save(e1);
		this.employeeRepo.save(e2);
		this.employeeRepo.save(e3);
		this.employeeRepo.save(e4);
		this.employeeRepo.save(e5);
	}

	// adding demo users

	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void insertAllData(ApplicationReadyEvent event) {
		User test1 = new User("admin", passwordEncoder.encode("admin"));
		User test2 = new User("test2", passwordEncoder.encode("test2"));

		Role userRole = new Role("ROLE_USER");
		Role adminRole = new Role("ROLE_ADMIN");

		roleRepository.saveAndFlush(userRole);
		roleRepository.saveAndFlush(adminRole);

		test1.addRole(adminRole);
		test1.addRole(userRole);
		test2.addRole(userRole);

		userRepository.saveAndFlush(test1);
		userRepository.saveAndFlush(test2);

	}

}
