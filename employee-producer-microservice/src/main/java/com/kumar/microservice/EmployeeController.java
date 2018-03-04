package com.kumar.microservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController
{
	@RequestMapping("/home")
	public String showHomePage()
	{
		return "<html><head></head><body bgcolor=\'#a2ab58\'><h1>Welcome to Employee Producer!</h1></body></html>";
	}

	@RequestMapping("/employees")
	public List<Employee> getEmployees()
	{
		return Arrays.asList(new Employee(101, "Steve Racker", 10000), new Employee(101, "John Winn", 20000));
	}
}