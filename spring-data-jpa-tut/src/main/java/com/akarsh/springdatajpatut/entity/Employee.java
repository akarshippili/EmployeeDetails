package com.akarsh.springdatajpatut.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "emailid_unique", columnNames = "email_address"))
public class Employee {
	
	@Id
	@SequenceGenerator(
			name = "employee_sequence",
			sequenceName = "employee_sequence",
			allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "employee_sequence")
	private Long employeeId;
	
	private String name;
	
	@Column(name = "email_address", nullable = false)
	private String emailId;	
	
	@ManyToOne
	@JoinColumn(
			name = "department_id",
			referencedColumnName = "departmentId"
			)
	private Department department;
	
	
	
	
	public Employee() {
	}
	
	public Employee(String name, String emailId, Department department) {
		this.name = name;
		this.emailId = emailId;
		this.department = department;
	}
	
	public Employee(Long employeeId, String name, String emailId, Department department) {
		this.employeeId = employeeId;
		this.name = name;
		this.emailId = emailId;
		this.department = department;
	}
	
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", emailId=" + emailId + ", department="
				+ department + "]";
	}
	
	
}
