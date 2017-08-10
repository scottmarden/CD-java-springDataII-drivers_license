package com.scottmarden.relationships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scottmarden.relationships.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {

	public License findOneByPersonId(Long person_id);
	
}
