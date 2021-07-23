package io.github.anantharajuc.sbmwa.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.domain.model.Movie;
import io.github.anantharajuc.sbmwa.repository.PersonRepository;
import io.github.anantharajuc.sbmwa.service.impl.MovieServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="MovieQueryController", description = "Set of public APIs, for querying Movies.")
@RestController
@RequestMapping(value="/api/person")
public class MovieQueryController 
{
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	MovieServiceImpl movieServiceImpl;
	
	@GetMapping(value = "/{id}/movies", produces = "application/json")
    public List<Movie> getAllMovies(@PathVariable("id") Long id) 
    {		
		return movieServiceImpl.getMoviesByPersonId(id);
    }
}
