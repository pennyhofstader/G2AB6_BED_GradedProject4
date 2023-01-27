package com.greatlearning.employeerestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeerestapi.entity.Role;
import com.greatlearning.employeerestapi.repo.RoleRepo;
import com.greatlearning.employeerestapi.serviceImpl.RoleService;

@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private RoleRepo roleRepo;

	public RoleController(RoleService roleService, RoleRepo roleRepo) {
		super();
		this.roleService = roleService;
		this.roleRepo = roleRepo;
	}

	@PostMapping("/addRole")
	public Role addRole(@RequestBody Role role) {
		return roleService.addRole(role);
	}

}
