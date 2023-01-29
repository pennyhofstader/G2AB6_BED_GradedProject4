package com.greatlearning.employeerestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeerestapi.entity.Role;
import com.greatlearning.employeerestapi.repo.RoleRepo;
import com.greatlearning.employeerestapi.service.RoleServiceInterface;

@RestController
public class RoleController {

	@Autowired
	private RoleServiceInterface roleService;

	@Autowired
	private RoleRepo roleRepo;

	// all args constructor
	public RoleController(RoleServiceInterface roleService, RoleRepo roleRepo) {
		super();
		this.roleService = roleService;
		this.roleRepo = roleRepo;
	}

	// adding a role
	@PostMapping("/addRole")
	public Role addRole(@RequestBody Role role) {
		return roleService.addRole(role);
	}

}
