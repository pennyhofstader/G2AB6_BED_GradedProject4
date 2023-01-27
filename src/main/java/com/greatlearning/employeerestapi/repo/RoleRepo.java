package com.greatlearning.employeerestapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.employeerestapi.entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

}
