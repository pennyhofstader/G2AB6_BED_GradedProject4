package com.greatlearning.employeerestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeerestapi.entity.User;
import com.greatlearning.employeerestapi.repo.UserRepo;
import com.greatlearning.employeerestapi.service.UserServiceInterface;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserServiceInterface userService;

	@Autowired
	private UserRepo userRepo;

	// all args constructor
	public UserController(UserServiceInterface userService, UserRepo userRepo) {
		super();
		this.userService = userService;
		this.userRepo = userRepo;
	}

	// adding a user
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {

		return userService.addUser(user);

	}
}
