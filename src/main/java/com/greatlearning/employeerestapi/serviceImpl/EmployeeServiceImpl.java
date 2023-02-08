package com.greatlearning.employeerestapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.employeerestapi.entity.Employee;
import com.greatlearning.employeerestapi.repo.EmployeeRepo;
import com.greatlearning.employeerestapi.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	// adding new employee
	@Override
	public Employee addEmployees(Employee employee) {
		return employeeRepo.saveAndFlush(employee);
	}

	// getting all employees
	@Override
	public List<Employee> listAllEmployees() {
		return employeeRepo.findAll();
	}

	// get an employee by id
	@Override
	public Employee getEmployeeById(Integer id) {
		Optional<Employee> empolyees = employeeRepo.findById(id);
		return empolyees.get();
	}

	// delete employee
	@Override
	public Object deleteEmployeeById(Integer id) {
		employeeRepo.deleteById(id);
		return "successfully deleted";
	}

	// sorting by name
	@Override
	public List<Employee> getEmployeesSortedByName(Direction direction) {

		return employeeRepo.findAll(Sort.by(direction, "firstName"));
	}

	// search by first name
	@Override
	public List<Employee> findByFirstName(@RequestParam("firstName") String firstName) {
		if (firstName == null) {
			return employeeRepo.findAll();
		} else {
			return employeeRepo.findByFirstName(firstName);
		}

	}

}
