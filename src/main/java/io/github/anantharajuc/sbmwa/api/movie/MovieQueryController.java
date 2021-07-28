package io.github.anantharajuc.sbmwa.api.movie;

import java.util.List;

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

import io.github.anantharajuc.sbmwa.api.hateoas.MovieRepresentationModelAssembler;
import io.github.anantharajuc.sbmwa.domain.model.Movie;
import io.github.anantharajuc.sbmwa.repository.PersonRepository;
import io.github.anantharajuc.sbmwa.service.impl.MovieServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="MovieQueryController", description = "Set of public APIs, for querying Movies.")
@RestController
@RequestMapping(value="/api")
public class MovieQueryController 
{
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	MovieServiceImpl movieServiceImpl;
	
	@Autowired
	private MovieRepresentationModelAssembler movieRepresentationModelAssembler;
	
	@GetMapping(value = "/movies", produces = "application/json")
	public ResponseEntity<CollectionModel<EntityModel<Movie>>> findAllMovies()
	{
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>(); 
		
		return new ResponseEntity<>(movieRepresentationModelAssembler.toCollectionModel(movieServiceImpl.findAllMovies()), headers, HttpStatus.OK); 
	}

	@GetMapping(value = "/movies/{id}", produces = "application/json")
	public ResponseEntity<EntityModel<Movie>> getMovieById(@PathVariable("id") Long id)
	{
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>(); 
		
		return new ResponseEntity<>(movieRepresentationModelAssembler.toModel(movieServiceImpl.getMovieById(id)), headers, HttpStatus.OK);
	}
	 
	@GetMapping(value = "/movies/{id}/person", produces = "application/json")
    public List<Movie> getAllMoviesByPersonId(@PathVariable("id") Long id) 
    {		
		return movieServiceImpl.getMoviesByPersonId(id);
    }
}
