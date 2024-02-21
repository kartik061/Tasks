package com.kartik.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.kartik.demo.entity.Employee;
import com.kartik.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
		
	}
	@PostMapping("/createEmployee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public Optional<Employee> getById(@PathVariable Integer id) { // findbyid accepts optonal type
		return employeeService.getEmployeeById(id);
	}
	
	@DeleteMapping("/deleteEmployeeById/{id}")
	public void deleteEmployeeById(@PathVariable Integer id) {
		employeeService.deleteEmployeeById(id);
	}
	@PutMapping("/updateEmployeeById/{id}")
	public Employee updateEmployeeById(@RequestBody Employee employee, @PathVariable Integer id)
	{
		return employeeService.updateEmployeeById(employee,id);
	}
	
}
