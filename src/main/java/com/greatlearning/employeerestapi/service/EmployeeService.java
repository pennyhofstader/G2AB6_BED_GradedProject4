package com.greatlearning.employeerestapi.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.employeerestapi.entity.Employee;

public interface EmployeeService {

	Employee addEmployees(Employee employee);

	List<Employee> listAllEmployees();

	Employee getEmployeeById(Integer id);

	Object deleteEmployeeById(Integer id);

	List<Employee> getEmployeesSortedByName(Direction direction);

	List<Employee> findByFirstName(String firstName);

	Employee Update(Employee params, int id);

}