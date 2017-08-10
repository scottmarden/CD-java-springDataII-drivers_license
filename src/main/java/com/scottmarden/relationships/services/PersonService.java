package com.scottmarden.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scottmarden.relationships.models.Person;
import com.scottmarden.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public void addPerson(Person person) {
		personRepository.save(person);
	}
	
	public List<Person> findAll(){
		return (List<Person>) personRepository.findAll();
	}
	
	public void destroyPerson(Long id) {
		personRepository.delete(id);
	}
	
	public Person findPerson(Long id) {
		return personRepository.findOne(id);
	}
}
