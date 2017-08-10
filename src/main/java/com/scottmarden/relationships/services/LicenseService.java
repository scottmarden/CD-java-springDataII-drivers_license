package com.scottmarden.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scottmarden.relationships.models.License;
import com.scottmarden.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	
	private LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public License getLicense(Long id) {
		return licenseRepository.findOne(id);
	}
	
	public License findLicense(Long person_id) {
		return licenseRepository.findOneByPersonId(person_id);
	}
	
	public List<License> allLicenses(){
		return (List<License>) licenseRepository.findAll();
	}
	
	public void createLicense(License license) {
		licenseRepository.save(license);
	}
	
}
