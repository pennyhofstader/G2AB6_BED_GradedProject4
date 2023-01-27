package com.greatlearning.employeerestapi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.greatlearning.employeerestapi.entity.Role;
import com.greatlearning.employeerestapi.repo.RoleRepo;

@Service
public class RoleService {

	@Autowired
	private RoleRepo roleRepo;

	public RoleService(RoleRepo roleRepo) {
		super();
		this.roleRepo = roleRepo;
	}

	public Role addRole(Role role) {
		return roleRepo.save(role);
	}

}
