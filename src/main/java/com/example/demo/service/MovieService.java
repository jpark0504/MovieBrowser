package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Movie;

public interface MovieService {

	public Movie addMovie(Movie movie);
	public Movie getMovie(Integer id);
	public Movie updateMovie(Movie movie);
	public void deleteMovie(Integer id);
	public List<Movie> searchByDirector(String director_name);
	public List<Movie> searchByFilmMaker(String filmmaker_name);
	public List<Movie> searchByTitle(String title);
	public List<Movie> searchMovie(String text);
	public List<Movie> getAllMovies();
}
