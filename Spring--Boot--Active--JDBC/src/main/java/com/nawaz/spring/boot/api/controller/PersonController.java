package com.nawaz.spring.boot.api.controller;

import com.javatechie.spring.activejdbc.api.service.PersonService;
import com.javatechie.spring.activejdbc.model.InputRequest;
import com.javatechie.spring.activejdbc.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

	@Autowired
	private PersonService service;

	@PostMapping("/savePerson")
	public String savePerson(@RequestBody InputRequest request) {
		return service.insert(request);
	}

	@GetMapping("/getPerson/{lastName}")
	public List<Person> getPerson(@PathVariable String lastName) {
		return service.getPerson(lastName);
	}

	@GetMapping("/getPersons")
	public List<Person> getPersons() {
		return service.getPersons();
	}

	@DeleteMapping("/deletePerson/{firstName}")
	public String deleteOne(@PathVariable String firstName) {
		return service.delete(firstName);
	}

	@DeleteMapping("/deleteAll")
	public String deleteAll() {
		return service.deleteAll();
	}

}
