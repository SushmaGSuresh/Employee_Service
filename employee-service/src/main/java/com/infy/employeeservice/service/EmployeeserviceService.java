package com.infy.employeeservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.employeeservice.model.Employee;
import com.infy.employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeserviceService {
	
	@Autowired
	EmployeeRepository repository;
	
	public List<Employee> getAllEmployees(){
		List<Employee> employee=new ArrayList<Employee>();
		repository.findAll().forEach(employee1->employee.add(employee1));
		return employee;
		
	} 
	
	
	public Employee getEmployeeById(int empId)   
	{  
	return repository.findById(empId).get() ;
	}  
	
	public void createEmployee(Employee employee)   
	{  
	repository.save(employee);  
	}  
	
	public void deleteEmployee(int empId)   
	{  
	repository.deleteById(empId);  
	}  
	
	public void updateEmployee(Employee employee, int empId)   
	{  
	repository.save(employee);  
	}  


}
