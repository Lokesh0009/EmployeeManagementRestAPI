package com.gl.springboot.cruddemo.service;

import java.util.List;

import com.gl.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	
	public Employee findbyFirstName(String firstName);
	
}
