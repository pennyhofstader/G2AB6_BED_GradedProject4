package com.greatlearning.employeerestapi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.greatlearning.employeerestapi.entity.User;
import com.greatlearning.employeerestapi.repo.RoleRepo;
import com.greatlearning.employeerestapi.repo.UserRepo;
import com.greatlearning.employeerestapi.service.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RoleRepo roleRepo;
	@Autowired
	PasswordEncoder passwordEncoder;

	public UserService(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
		super();
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
		this.passwordEncoder = passwordEncoder;
	}

	// adding a user
	@Override
	public User addUser(User user) {

		String encodedPassword = this.passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return userRepo.save(user);

	}

}
