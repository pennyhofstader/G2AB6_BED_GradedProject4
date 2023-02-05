package com.greatlearning.employeerestapi.service;

import com.greatlearning.employeerestapi.entity.Role;

public interface RoleServiceInterface {

	Role addRole(Role role);

	String[] getAllRoles();

}