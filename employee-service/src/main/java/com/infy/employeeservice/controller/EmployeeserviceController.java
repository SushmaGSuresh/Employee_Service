package com.infy.employeeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.employeeservice.model.Employee;
import com.infy.employeeservice.repository.EmployeeRepository;


@RestController
public class EmployeeserviceController {
	@Autowired
	EmployeeRepository repository;
	
	@PostMapping("/createEmployee")
	private Employee createEmployee(@RequestBody Employee employee) {
		repository.save(employee);
	return employee;}
	
	//@GetMapping("/getEmployees")
	//private List<Employee> getAllEmployees(){
		//return repository.getAllEmployees();
	//}
	
	
	@GetMapping("/getEmployee/{empId}")
	private List<Employee> getEmployeeByempId(@PathVariable int empId)
	{
		return repository.getEmployeeByempId(empId);
	}
	
	@DeleteMapping("/deleteEmployee/{empId}")
	private void deleteEmployee(@PathVariable("empId") int empId) {
		repository.deleteById(empId);
	}
	
	@PutMapping("/updateEmployee")
	private Employee updateEmployee(@RequestBody Employee employee) {
		repository.save(employee);
		return employee;
		}
}
