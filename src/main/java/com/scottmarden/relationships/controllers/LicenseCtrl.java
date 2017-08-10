package com.scottmarden.relationships.controllers;

import java.text.DecimalFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scottmarden.relationships.models.License;
import com.scottmarden.relationships.models.Person;
import com.scottmarden.relationships.services.LicenseService;
import com.scottmarden.relationships.services.PersonService;

@Controller
public class LicenseCtrl {
	
	private final LicenseService licenseService;
	private final PersonService personService;
	
	
	
	public LicenseCtrl(LicenseService licenseService, PersonService personService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}
	
	public String licenseNumber() {
        int numPeople = licenseService.allLicenses().size();
        DecimalFormat df = new DecimalFormat("000000");
        String licenseNum = df.format(numPeople);
        return licenseNum;
    }
	
	@RequestMapping("/licenses/new")
	public String addLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> people = personService.findAll();
		model.addAttribute("people", people);
		return "addLicense.jsp";
	}
	
	@PostMapping("/licenses/new")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "addLicense.jsp";
		}else {
			license.setNumber(licenseNumber());
			licenseService.createLicense(license);
			return "redirect:/persons/" + license.getPerson().getId();
		}
		
	}
	
	@RequestMapping("/licenses/{id}")
	public String findLicense(@PathVariable("id") Long id, Model model) {
		License foundLicense = licenseService.getLicense(id);
		System.out.println("License: " + foundLicense);
		model.addAttribute("foundLicense", foundLicense);
		return "person.jsp";
	}
	
	@RequestMapping("/licenses")
	public void findAllLicenses() {
		List<License> licenses = licenseService.allLicenses();
		System.out.println("License List Size: " + licenses.size());
	}
}
