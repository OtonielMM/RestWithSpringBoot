package br.com.tom.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.tom.model.Person;

@Service // Responsável por realizar a injecão de dependencia

public class PersonServices {

	private final AtomicLong counter = new AtomicLong(); // simular um id no BD - gerar um id novo
	
	
	public Person create(Person person){
		
		return person;
	}
	
	public Person update(Person person){
		
		return person;
	}
	
	public void delete(String id) {
	
	}
	
	
//Metodo para retornar uma lista de Person	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<Person>();
		
		for(int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
		
	}

	private Person mockPerson(int i) {
		// 
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name "+ i);
		person.setLastName("da Silva");
		person.setAddress("Rua " + i);
		person.setGender("Male");
		return person;
	}
//Metodo para encontrar por id
	public Person findById(String id) {
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Paulo");
		person.setLastName("da Silva");
		person.setAddress("Rua Pedro de Toledo, 45");
		person.setGender("Male");
		
		return person;
	}
	
}
