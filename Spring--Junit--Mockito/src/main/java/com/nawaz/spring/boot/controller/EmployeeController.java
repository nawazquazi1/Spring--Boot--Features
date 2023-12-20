package com.nawaz.spring.boot.controller;

import com.javatechie.spring.mockito.api.dao.EmployeeRepository;
import com.javatechie.spring.mockito.api.model.Employee;
import com.javatechie.spring.mockito.api.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EmployeeService")
public class EmployeeController {
	@Autowired
	private EmployeeRepository repository;

	@PostMapping("/addEmployee")
	public Response addEmployee(@RequestBody Employee employee) {
		repository.save(employee);
		return new Response(employee.getId() + " inserted", Boolean.TRUE);
	}

	@GetMapping("/getEmployees")
	public Response getAllEmployees() {
		List<Employee> employees = repository.findAll();
		return new Response("record counts : " + employees.size(), Boolean.TRUE);
	}
}
