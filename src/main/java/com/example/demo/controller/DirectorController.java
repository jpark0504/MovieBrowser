package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Director;
import com.example.demo.service.DirectorService;

@RestController
public class DirectorController {
	@Autowired
	private DirectorService dirService;
	
	@RequestMapping(path = "/director", method = RequestMethod.POST)
	public Director addDirector(@RequestBody Director value) {
		return dirService.addDirector(value);
	}
	
	@RequestMapping(path = "/director/{id}", method = RequestMethod.GET)
	public Director getDirector(@PathVariable Integer id) {
		return dirService.getDirector(id);
	}
	
	@RequestMapping(path = "/director/byname/{lastName}", method = RequestMethod.GET)
	public List<Director> getDirector(@PathVariable String lastName) {
		return dirService.getDirector(lastName);
	}
	
	@RequestMapping(path = "/director/{id}", method = RequestMethod.DELETE)
	public void deleteDirector(@PathVariable Integer id) {
		dirService.deleteDirector(id);
	}
	
	@RequestMapping(path = "/director/{id}", method = RequestMethod.PUT)
	public Director updateDirector(@PathVariable Integer id, @RequestBody Director value) {
		return dirService.updateDirector(value);
	}
	
	@RequestMapping(path = "/director", method = RequestMethod.GET)
	public List<Director> getAllDirectors() {
		return dirService.getAllDirectors();
	}
}
