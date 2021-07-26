package io.github.anantharajuc.sbmwa.service;

import java.util.List;

import io.github.anantharajuc.sbmwa.domain.dto.request.MovieCreateRequest;
import io.github.anantharajuc.sbmwa.domain.model.Movie;

public interface MovieService 
{
	List<Movie> getMoviesByPersonId(Long id);
	
	List<Movie> findAllMovies();
	
	Movie createMovieForPerson(Long id, MovieCreateRequest movie);
}
