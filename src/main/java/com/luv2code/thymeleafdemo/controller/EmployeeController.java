package com.luv2code.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.thymeleafdemo.entity.Employee;
import com.luv2code.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	 public EmployeeController(EmployeeService theEmployeeService) {
		employeeService=theEmployeeService;
	}
	
	@GetMapping("listEmployees")
	public String getEmployees(Model theModel) {
		//get employee from db
		List<Employee> theEmployees=employeeService.findAll();
		
		//add to the spring model 
		theModel.addAttribute("employees", theEmployees);
		 
		return "employees/listEmployees";
	}
	
	@GetMapping("showFormForAdd")
	public String showForm(Model theModel) {
		
		//create Model attribute to bind form data
		Employee employee=new Employee();
		//add to the spring model 
		theModel.addAttribute("employee", employee);
		 
		return "employees/employee-form";
	}
	@PostMapping("save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		//create Model attribute to bind form data
		employeeService.save(employee);
		 
		return "redirect:/employees/listEmployees";
	}
	@GetMapping("showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel) {
		
		//get employee from the service
		Employee employee=employeeService.findById(theId);
		//set employee as model attriute to pre-populate the form 
		theModel.addAttribute("employee", employee);
		 
		return "employees/employee-form";
	}
	@GetMapping("delete")
	public String delete(@RequestParam("employeeId") int theId,Model theModel) {
		
		//delete employee 
		employeeService.deleteById(theId);
	
		return "redirect:/employees/listEmployees";
	}
	
	
}
