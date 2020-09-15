package com.infy.employeeservice.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.infy.employeeservice.model.Employee;



public interface EmployeeRepository extends CrudRepository<Employee,Integer>{


	//List<Employee> getAllEmployees();

	//List<Employee> getEmployeeById(int emp_id);

	List<Employee> getEmployeeByempId(int empId);






}
