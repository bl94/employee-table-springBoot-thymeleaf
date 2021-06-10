package com.luv2code.thymeleafdemo.service;

import java.util.List;

import com.luv2code.thymeleafdemo.entity.Employee;


public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
}
