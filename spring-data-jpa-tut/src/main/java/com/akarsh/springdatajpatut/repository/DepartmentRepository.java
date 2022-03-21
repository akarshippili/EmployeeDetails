package com.akarsh.springdatajpatut.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akarsh.springdatajpatut.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	public Optional<Department> findByDepartmentName(String Name);
	
}
