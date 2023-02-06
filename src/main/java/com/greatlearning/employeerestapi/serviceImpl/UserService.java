package com.greatlearning.employeerestapi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatlearning.employeerestapi.entity.User;

import com.greatlearning.employeerestapi.repo.UserRepo;
import com.greatlearning.employeerestapi.service.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface {

	@Autowired
	private UserRepo userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public User addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.saveAndFlush(user);
	}

}
