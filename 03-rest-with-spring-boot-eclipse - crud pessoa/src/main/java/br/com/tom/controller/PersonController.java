package br.com.tom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tom.model.Person;
import br.com.tom.services.PersonServices;


@RestController
@RequestMapping("/person")

public class PersonController {
	
	@Autowired
	private PersonServices services;
	
	@GetMapping("/{Id}")
	public Person findById(@PathVariable("Id") Long Id) {

	return services.findById(Id);
	}
	
	@GetMapping
	public List<Person> findAll() {

	return services.findAll();
	}
	
	@PostMapping
	public Person create(@RequestBody Person person) {

	return services.create(person);
	}
		
	@PutMapping("/{Id}")
	public Person update(@RequestBody Person person) {

	return services.update(person);
	}
	
	@DeleteMapping("/{Id}")
	public ResponseEntity<?> delete(@PathVariable("Id") Long Id) {
		
		services.delete(Id);
		return ResponseEntity.ok().build();
	}
}
