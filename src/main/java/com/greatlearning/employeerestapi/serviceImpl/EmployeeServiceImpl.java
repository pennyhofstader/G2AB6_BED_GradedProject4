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

@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee addEmployees(Employee employee) {
		return employeeRepo.saveAndFlush(employee);
	}

	public List<Employee> listAllEmployees() {
		return employeeRepo.findAll();
	}

	public Employee getEmployeeById(Integer id) {
		Optional<Employee> empolyees = employeeRepo.findById(id);
		return empolyees.get();
	}

	public Object deleteEmployeeById(Integer id) {
		employeeRepo.deleteById(id);
		return "employee deleted";
	}

	public List<Employee> getEmployeesSortedByName(Direction direction) {

		return employeeRepo.findAll(Sort.by(direction, "firstName"));
	}

	public List<Employee> findByFirstName(@RequestParam("firstName") String firstName) {
		if (firstName == null) {
			return employeeRepo.findAll();
		} else {
			return employeeRepo.findByFirstName(firstName);
		}

	}

	
	
	 public Employee Update(Employee params, int id) {

		 Employee employee =  employeeRepo.findById(id).get();
		 employee.setFirstName(params.getFirstName());
		 employee.setLastName(params.getLastName());
		 employee.setEmail(params.getEmail());

	       return employeeRepo.save(employee);

	    }
}
