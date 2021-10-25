package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Director;

public interface DirectorService {
	public Director addDirector(Director value);
	public Director getDirector(Integer id);
	public List<Director> getDirector(String lastName);
	public void deleteDirector(Integer id);
	public Director updateDirector(Director value);
	public List<Director> getAllDirectors();
}
