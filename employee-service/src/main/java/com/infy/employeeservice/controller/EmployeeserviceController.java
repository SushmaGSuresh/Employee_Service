package com.infy.employeeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.employeeservice.model.Employee;
import com.infy.employeeservice.repository.EmployeeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@CrossOrigin(origins = "*", allowedHeaders ="*")
@Api(value = "EmployeeServiceController, REST API's of Employee")
public class EmployeeserviceController {
	@Autowired
	EmployeeRepository repository;
	
	@PostMapping("/createEmployee")
	@ApiOperation(value= "Create new Employee", tags="createEmployee")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Employee saved successfully"),
							@ApiResponse(code = 404, message = "Error saving Employee")})
	private Employee createEmployee(@RequestBody Employee employee) {
		repository.save(employee);
	return employee;}
	
	/*@GetMapping("/getEmployees")
	@ApiOperation(value= "Fetch all Employees", tags="getAllEmployees")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Employees fetched successfully"),
							@ApiResponse(code = 404, message = "Error fetching Employees")})
	private Iterable<Employee> getAllEmployees(){
		return repository.getAllEmployees();
	}*/
	
	
	@GetMapping("/getEmployee/{empId}")
	@ApiOperation(value= "Get Employee by empId", tags="getEmployeeByempId")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Employee fetched successfully"),
							@ApiResponse(code = 404, message = "Error fetching Employee")})
	private List<Employee> getEmployeeByempId(@PathVariable int empId)
	{
		return repository.getEmployeeByempId(empId);
	}
	
	@DeleteMapping("/deleteEmployee/{empId}")
	@ApiOperation(value= "Delete Employee", tags="deleteEmployee")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Employee deleted successfully"),
							@ApiResponse(code = 404, message = "Error deleting Employee")})
	private void deleteEmployee(@PathVariable("empId") int empId) {
		repository.deleteById(empId);
	}
	
	@PutMapping("/updateEmployee")
	private Employee updateEmployee(@RequestBody Employee employee) {
		repository.save(employee);
		return employee;
		}
}
