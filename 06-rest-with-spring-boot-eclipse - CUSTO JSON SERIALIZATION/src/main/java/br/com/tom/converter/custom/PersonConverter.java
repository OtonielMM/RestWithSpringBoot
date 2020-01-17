package br.com.tom.converter.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.tom.data.model.Person;
import br.com.tom.data.vo.v2.PersonVOv2;

@Service

public class PersonConverter {

	public PersonVOv2 converterEntityToVo(Person person){
		
		PersonVOv2 vo = new PersonVOv2();
		
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		vo.setBirthDay(new Date());
		return vo;
	}
	
	public Person converterVoToEntity(PersonVOv2 person){
		
		Person entity = new Person();
		
		entity.setId(person.getId());
		entity.setAddress(person.getAddress());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		return entity;
	}
}
