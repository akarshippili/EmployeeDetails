package com.akarsh.springdatajpatut.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akarsh.springdatajpatut.entity.Department;
import com.akarsh.springdatajpatut.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public List<Department> fetchDepartments() {
		return departmentRepository.findAll();
	}
	
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
}
