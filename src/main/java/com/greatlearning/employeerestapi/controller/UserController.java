package com.greatlearning.employeerestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeerestapi.entity.User;
import com.greatlearning.employeerestapi.repo.UserRepo;
import com.greatlearning.employeerestapi.serviceImpl.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepo userRepo;

	public UserController(UserService userService, UserRepo userRepo) {
		super();
		this.userService = userService;
		this.userRepo = userRepo;
	}

	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {

		return userService.addUser(user);

	}
}