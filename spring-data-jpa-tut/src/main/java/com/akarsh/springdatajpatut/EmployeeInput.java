package com.akarsh.springdatajpatut;

public class EmployeeInput {
	
	private String name;
	private String email;
	private String department;
	
	public EmployeeInput() {
	}
	
	public EmployeeInput(String name, String email, String department) {
		this.name = name;
		this.email = email;
		this.department = department;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "EmployeeInput [name=" + name + ", email=" + email + ", department=" + department + "]";
	}
	
	
}
