package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	@Query("select m from Movie m where lower(m.director.firstName) like %:name% or lower(m.director.lastName) like %:name%")
	List<Movie> searchByDirector(@Param("name") String name);
	
	@Query("select m from Movie m where lower(m.filmMaker.name) like %:name%")
	List<Movie> searchByFilmMaker(@Param("name") String name);
	
	@Query("select m from Movie m where lower(m.title) like %:title%")
	List<Movie> searchByTitle(@Param("title") String title);

	@Query("select m from Movie m where lower(m.title) like %:text% or lower(m.director.firstName) like %:text% or lower(m.director.lastName) like %:text% or lower(m.filmMaker.name) like %:text%")
	List<Movie> searchMovie(@Param("text") String text);
}
