package io.github.anantharajuc.sbmwa.api.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.api.hateoas.PersonRepresentationModelAssembler;
import io.github.anantharajuc.sbmwa.domain.model.Person;
import io.github.anantharajuc.sbmwa.repository.PersonRepository;
import io.github.anantharajuc.sbmwa.service.impl.PersonServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="PersonQueryController", description = "Set of public APIs, for querying Person.")
@RestController
@RequestMapping("/api")
public class PersonQueryController 
{
	@Autowired
	PersonServiceImpl personServiceImpl;
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	private PersonRepresentationModelAssembler personRepresentationModelAssembler;
	
	/**
     * Retrieve all persons
     * 
     * @return List<Person> with all persons
     */	
	@GetMapping(value = "/persons", produces = "application/json")
    public ResponseEntity<CollectionModel<EntityModel<Person>>> getAllPersons() 
	{
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>(); 
		
		return new ResponseEntity<>(personRepresentationModelAssembler.toCollectionModel(personServiceImpl.getAllPersons()), headers, HttpStatus.OK); 
    }

	/**
     * Get a Person by id.
     * 
     * @param id. The persons id         
     * @return the person
     */
	@GetMapping(value = "/persons/{id}", produces = "application/json")
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long id) 
	{
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>(); 

        return new ResponseEntity<>(personServiceImpl.getPersonById(id), headers, HttpStatus.OK);
    }
}