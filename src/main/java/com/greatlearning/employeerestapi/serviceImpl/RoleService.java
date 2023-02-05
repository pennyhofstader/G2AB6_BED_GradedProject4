package com.greatlearning.employeerestapi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employeerestapi.entity.Role;
import com.greatlearning.employeerestapi.repo.RoleRepo;
import com.greatlearning.employeerestapi.service.RoleServiceInterface;

@Service
public class RoleService implements RoleServiceInterface {

	@Autowired
	private RoleRepo roleRepository;

	@Override
	public Role addRole(Role role) {
		return roleRepository.saveAndFlush(role);
	}

	@Override
	public String[] getAllRoles() {
		return (String[]) roleRepository.findAll().toArray();
	}
}
