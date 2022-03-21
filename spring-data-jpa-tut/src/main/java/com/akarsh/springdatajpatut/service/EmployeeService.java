package com.akarsh.springdatajpatut.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akarsh.springdatajpatut.EmployeeInput;
import com.akarsh.springdatajpatut.entity.Department;
import com.akarsh.springdatajpatut.entity.Employee;
import com.akarsh.springdatajpatut.repository.DepartmentRepository;
import com.akarsh.springdatajpatut.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Employee addEmployeee(EmployeeInput employee) {
		Optional<Department> departmentOptional = departmentRepository.findByDepartmentName(employee.getDepartment());
		if(!departmentOptional.isPresent()) {
			throw new IllegalStateException("Department "+employee.getDepartment()+" dose not exists");
		}
		Employee newEmployee = new Employee(employee.getName(),employee.getEmail(),departmentOptional.get());
		return employeeRepository.save(newEmployee);
	}
	
	
	public List<Employee> fetchEmployees() {
		return employeeRepository.findAll();
	}


	public Optional<Employee> fetchEmployee(Long id) {
		return employeeRepository.findById(id);
	}
	
}
