package io.github.anantharajuc.sbmwa.api.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.domain.model.Person;
import io.github.anantharajuc.sbmwa.repository.PersonRepository;
import io.github.anantharajuc.sbmwa.service.impl.PersonServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="PersonQueryController", description = "Set of public APIs, for querying Person.")
@RestController
@RequestMapping("/api/person")
public class PersonQueryController 
{
	@Autowired
	PersonServiceImpl personServiceImpl;
	
	@Autowired
	PersonRepository personRepository;
	
	/**
     * Retrieve all persons
     * 
     * @return List<Person> with all persons
     */
	@GetMapping(produces = "application/json")
    public ResponseEntity<List<Person>> getAllPersons() 
	{
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>(); 
		
		return new ResponseEntity<>(personServiceImpl.getAllPersons(), headers, HttpStatus.OK);
    }

	/**
     * Get a Person by id.
     * 
     * @param id. The persons id         
     * @return the person
     */
	@GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long id) 
	{
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>(); 

        return new ResponseEntity<>(personServiceImpl.getPersonById(id), headers, HttpStatus.OK);
    }
}