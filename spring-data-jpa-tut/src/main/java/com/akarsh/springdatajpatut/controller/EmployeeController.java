package com.akarsh.springdatajpatut.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akarsh.springdatajpatut.EmployeeInput;
import com.akarsh.springdatajpatut.entity.Employee;
import com.akarsh.springdatajpatut.service.EmployeeService;

@RestController
@RequestMapping("api/v1/employee")	
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping(path = "/add")
	public Employee addEmployee(@RequestBody EmployeeInput employee) {
		return employeeService.addEmployeee(employee);
	}
	
	@GetMapping(path = "{id}")
	public Employee getEmployee(@PathVariable Long id) {
		Optional<Employee> employeeOptional =  employeeService.fetchEmployee(id);
		if(!employeeOptional.isPresent()) {
			throw new IllegalStateException("User with userId "+ id  +" dose not exists");
		}
		return employeeOptional.get();
	}
	
	@GetMapping(path = "/all")
	public List<Employee> getAllEmployees(){
		return employeeService.fetchEmployees();
	}
	
}
