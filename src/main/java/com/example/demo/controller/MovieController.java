package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value = "/movie", method = RequestMethod.POST)
	public Movie addMovie(@RequestBody Movie movie) {
		return movieService.addMovie(movie);
	}
	
	@RequestMapping(value = "/movie", method = RequestMethod.GET)
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}
	
	@RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
	public Movie getMovie(@PathVariable Integer id) {
		return movieService.getMovie(id);
	}
	
	@RequestMapping(value = "/movie/{id}", method = RequestMethod.PUT)
	public Movie updateMovie(@RequestBody Movie movie, @PathVariable Integer id) {
		return movieService.updateMovie(movie);
	}
	
	@RequestMapping(value = "/movie/{id}", method = RequestMethod.DELETE)
	public void deleteMovie(@PathVariable Integer id) {
		movieService.deleteMovie(id);
	}
	
	@RequestMapping(value="/movie/search", method = RequestMethod.GET)
	public List<Movie> searchMovie(@RequestParam("text") String text) {
		return movieService.searchMovie(text);
	}
}
