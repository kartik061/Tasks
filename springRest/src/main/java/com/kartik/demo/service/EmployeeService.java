package com.kartik.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kartik.demo.entity.Employee;
import com.kartik.demo.repository.EmployeeRepository;

@Service
public class EmployeeService
{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees()
	{
		return employeeRepository.findAll();
	}
	
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Optional<Employee> getEmployeeById(Integer id) {
		return employeeRepository.findById(id);
	}

	public void deleteEmployeeById(Integer id) {
		employeeRepository.deleteById(id);
	}

	public Employee updateEmployeeById(Employee employee, Integer id) {
		
		employee.setId(id);
		return employeeRepository.save(employee);
	}
}
