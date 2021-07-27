package io.github.anantharajuc.sbmwa.api.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import io.github.anantharajuc.sbmwa.api.hateoas.common.SimpleIdentifiableRepresentationModelAssembler;
import io.github.anantharajuc.sbmwa.api.person.PersonQueryController;
import io.github.anantharajuc.sbmwa.domain.model.Person;

@Component
public class PersonRepresentationModelAssembler extends SimpleIdentifiableRepresentationModelAssembler<Person>
{
	public PersonRepresentationModelAssembler() 
	{
		super(PersonQueryController.class);
	}
	
	@Override
	public void addLinks(EntityModel<Person> resource)
	{
		super.addLinks(resource);
	}
	
	@Override
	public void addLinks(CollectionModel<EntityModel<Person>> resources) 
	{
		super.addLinks(resources);
		
		resources.add(linkTo(methodOn(RootController.class).root()).withRel("root"));
	}
}
