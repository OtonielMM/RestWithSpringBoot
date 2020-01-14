package br.com.tom.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tom.data.model.Person;
import br.com.tom.exception.ResourceNotFoundException;
import br.com.tom.repository.PersonRepository;

@Service // Responsável por realizar a injecão de dependencia

public class PersonServices {
	
	@Autowired
	PersonRepository repository;
	
	
	public Person create(Person person){
		
		return repository.save(person);
	}
	
	
//Metodo para retornar uma lista de Person	
	public List<Person> findAll() {

		return repository.findAll();
		
	}
	
	public Person findById(Long id) {

		return repository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
	}

//Metodo para encontrar por id
	public Person update(Person person) {
		
		Person entity = repository.findById(person.getId()).
		orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		
		Person entity = repository.findById(id).
		orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		repository.delete(entity);
		
	}
	
}
