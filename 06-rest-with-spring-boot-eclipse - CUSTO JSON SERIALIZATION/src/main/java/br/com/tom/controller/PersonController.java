package br.com.tom.controller;

// https://github.com/leandrocgsi/SpringBootPlayground

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

import br.com.tom.data.vo.v2.PersonVOv2;
import br.com.tom.data.vo1.PersonVO;
import br.com.tom.services.PersonServices;


@RestController
@RequestMapping("/api/person/v1")

public class PersonController {
	
	@Autowired
	private PersonServices services;
	
	@GetMapping(value = "/{Id}", produces = {"application/json", "application/xml"})
	public PersonVO findById(@PathVariable("Id") Long Id) {

	return services.findById(Id);
	}
	
	@GetMapping(produces = {"application/json", "application/xml"})
	public List<PersonVO> findAll() {

	return services.findAll();
	}
	
	
	@PostMapping(produces = {"application/json", "application/xml"},
				consumes = {"application/json", "application/xml"})
	public PersonVO create(@RequestBody PersonVO person){
	    return services.create(person);
	}
   
	@PostMapping(value = "/v2", produces = {"application/json", "application/xml"},
			consumes = {"application/json", "application/xml"})
	public PersonVOv2 createv2(@RequestBody PersonVOv2 person){
	    return services.createv2(person);
	}
     
		
	@PutMapping(value = "/{Id}",produces = {"application/json", "application/xml"},
			consumes = {"application/json", "application/xml"})
	public PersonVO update(@RequestBody PersonVO person) {

	return services.update(person);
	}
	
	@DeleteMapping("/{Id}")
	public ResponseEntity<?> delete(@PathVariable("Id") Long Id) {
		
		services.delete(Id);
		return ResponseEntity.ok().build();
	}
}
