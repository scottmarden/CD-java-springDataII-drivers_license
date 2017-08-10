package com.scottmarden.relationships.controllers;

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
public class PersonCtrl {

	private final PersonService personService;
	private final LicenseService licenseService;
	
	public PersonCtrl(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	@RequestMapping(value="/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/persons/new")
	public String addPerson(@ModelAttribute("person") Person person) {
		return "addPerson.jsp";
	}
	
	@PostMapping(value="/persons/new")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "addPerson.jsp";
		}else {
			personService.addPerson(person);
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="delete/{id}")
	public String removePerson(@PathVariable("id")Long id) {
		personService.destroyPerson(id);
		return "redirect:/";
	}
	
	@RequestMapping(value="/persons/{id}")
	public String personDetails(@PathVariable("id")Long id, Model model) {
		Person foundPerson = personService.findPerson(id);
		License foundLicense = licenseService.findLicense(foundPerson.getId());
		model.addAttribute("foundPerson", foundPerson);
		model.addAttribute("foundLicense", foundLicense);
		System.out.println("Person first name: " + foundPerson.getFirstName());
		System.out.println("Person license: " + foundLicense.getState());
		return "person.jsp";
	}
}
