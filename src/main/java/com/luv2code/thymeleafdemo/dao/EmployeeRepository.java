  package com.luv2code.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//not needed to write additional
	public List<Employee> findAllByOrderByLastNameAsc();
}
 