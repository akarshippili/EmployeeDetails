package com.akarsh.springdatajpatut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akarsh.springdatajpatut.entity.Department;
import com.akarsh.springdatajpatut.service.DepartmentService;

@RestController
@RequestMapping(path = "api/v1/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	
	@PostMapping(path = "/add")
	public Department addDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping(path = "/all")
	public List<Department> getAllDepartments(){
		return departmentService.fetchDepartments();
	}
	
}
