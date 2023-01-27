package com.greatlearning.employeerestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeerestapi.entity.Employee;
import com.greatlearning.employeerestapi.serviceImpl.EmployeeServiceImpl;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	// working properly
	@PostMapping("/addNewEmployee")
	public Employee addNewEmployee(@RequestBody Employee employee) {

		return employeeServiceImpl.addEmployees(employee);

	}

	// working properly
	@GetMapping("/listAllEmployees")
	public List<Employee> listAllEmployees() {
		return employeeServiceImpl.listAllEmployees();
	}

	// working properly
	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<Employee> getUserById(@PathVariable("id") Integer id) {
		Employee employee = employeeServiceImpl.getEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	// working properly
	@DeleteMapping("/deleteEmployeeById/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id) {
		employeeServiceImpl.deleteEmployeeById(id);
		return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
	}

	// working properly
	@GetMapping("/getEmployeesSortedByName")
	public List<Employee> getEmployeesSortedByName(Direction direction) {
		return employeeServiceImpl.getEmployeesSortedByName(direction);
	}

	// working properly
	@GetMapping("/searchByFirstName")
	public List<Employee> searchByFirstName(String firstName) {
		return employeeServiceImpl.findByFirstName(firstName);
	}

	@PutMapping(value = "/update/{id}")
	public Employee Update(@PathVariable int id, @RequestBody Employee params) {
		return employeeServiceImpl.Update(params, id);
	}

}
