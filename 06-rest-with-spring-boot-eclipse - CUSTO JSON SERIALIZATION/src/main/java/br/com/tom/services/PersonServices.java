package br.com.tom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import br.com.tom.converter.DozerConverter;
import br.com.tom.converter.custom.PersonConverter;
import br.com.tom.data.model.Person;
import br.com.tom.data.vo.v2.PersonVOv2;
import br.com.tom.data.vo1.PersonVO;
import br.com.tom.exception.ResourceNotFoundException;
import br.com.tom.repository.PersonRepository;

@Service // Responsável por realizar a injecão de dependencia

public class PersonServices {
    
    @Autowired
    PersonRepository repository;
    
    public PersonVO create(PersonVO person) {
    	Person entity = DozerConverter.parseObject(person, Person.class);
    	PersonVO vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
    	return vo;
    }
    
    
    @Autowired
    PersonConverter converter;
    public PersonVOv2 createv2(PersonVOv2 person) {
    	Person entity = converter.converterVoToEntity(person);
    	PersonVOv2 vo = converter.converterEntityToVo(repository.save(entity));
    	return vo;
    }
 
    public PersonVO findById(Long id) {
    	Person entity = repository.findById(id)
        		.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DozerConverter.parseObject(entity, PersonVO.class);
    }
 
    public List<PersonVO> findAll() {
    	return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
    }
     
    public PersonVO update(PersonVO person) {
    	Person entity = repository.findById(person.getId())
                 .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		entity.setAddress(person.getAddress());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		PersonVO vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
    	return vo;
    }
 
    public void delete(Long id) {
    	Person person = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		repository.delete(person);
    }
}