package io.github.anantharajuc.sbmwa.api.controller.address;

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

import io.github.anantharajuc.sbmwa.api.hateoas.AddressRepresentationModelAssembler;
import io.github.anantharajuc.sbmwa.api.hateoas.PersonRepresentationModelAssembler;
import io.github.anantharajuc.sbmwa.domain.model.Address;
import io.github.anantharajuc.sbmwa.domain.model.Person;
import io.github.anantharajuc.sbmwa.service.impl.AddressServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="AddressQueryController", description = "Set of public APIs, for querying Address.")
@RestController
@RequestMapping(value="/api")
public class AddressQueryController 
{
	@Autowired
	AddressServiceImpl addressServiceImpl;
	
	@Autowired
	private PersonRepresentationModelAssembler personRepresentationModelAssembler;
	
	@Autowired
	private AddressRepresentationModelAssembler addressRepresentationModelAssembler;

	@GetMapping(value = "/addresses", produces = "application/json")
	public ResponseEntity<CollectionModel<EntityModel<Address>>> getAllAddress()
	{
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>(); 
		
		return new ResponseEntity<>(addressRepresentationModelAssembler.toCollectionModel(addressServiceImpl.findAllAddress()), headers, HttpStatus.OK); 
	}
	
	@GetMapping(value = "/addresses/{id}", produces = "application/json")
	public ResponseEntity<EntityModel<Address>> getAddressById(@PathVariable("id") Long id)
	{
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>(); 
		
		return new ResponseEntity<>(addressRepresentationModelAssembler.toModel(addressServiceImpl.findAddressById(id)), headers, HttpStatus.OK); 
	}
	
	@GetMapping(value = "/addresses/{id}/person", produces = "application/json")
	public ResponseEntity<EntityModel<Person>> getPersonByAddressId(@PathVariable("id") Long id)
	{
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>(); 
		
		return new ResponseEntity<>(personRepresentationModelAssembler.toModel(addressServiceImpl.findPersonByAddressId(id)), headers, HttpStatus.OK); 
	}
}
