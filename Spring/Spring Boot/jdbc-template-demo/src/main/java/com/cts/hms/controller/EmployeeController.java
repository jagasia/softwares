package com.cts.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.hms.entity.Employee;
import com.cts.hms.entity.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService es;
	
	@GetMapping("/")
	public String home()
	{
		return "Hello world";
	}
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployees()
	{
		return es.read();
	}
	
	@GetMapping("/employee/{id}")
	public Employee findEmployeeById(@PathVariable Long id)
	{
		Employee employee=null;
		try
		{
			employee=es.read(id);
		}catch(EmptyResultDataAccessException erde)
		{
			employee=new Employee();
		}
		return employee;
	}
	
	@PostMapping("/employee")
	public int addEmployee(@RequestBody Employee employee)
	{
		return es.create(employee);
	}
	
	@PutMapping("/employee")
	public int modifyEmployee(@RequestBody Employee employee)
	{
		return es.update(employee);
	}
	
	@DeleteMapping("/employee/{id}")
	public int removeEmployee(@PathVariable Long id)
	{
		return es.delete(id);
	}
}
