package com.greatlearning.employeerestapi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.greatlearning.employeerestapi.entity.User;
import com.greatlearning.employeerestapi.repo.RoleRepo;
import com.greatlearning.employeerestapi.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	private RoleRepo roleRepo;

	public UserService(UserRepo userRepo, RoleRepo roleRepo) {
		super();
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
	}

	public User addUser(User user) {

		return userRepo.save(user);

	}

}
