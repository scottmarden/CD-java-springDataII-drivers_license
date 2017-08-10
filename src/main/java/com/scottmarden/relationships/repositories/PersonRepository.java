package com.scottmarden.relationships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scottmarden.relationships.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	
}
