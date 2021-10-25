package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Actor;
import com.example.demo.service.ActorService;

@RestController
public class ActorController {

	@Autowired
	private ActorService actorService;
	
	@RequestMapping(value="/actor", method = RequestMethod.POST)
	public Actor addActor(@RequestBody Actor actor) {
		return actorService.addActor(actor);
	}
	
	@RequestMapping(value="/actor/{id}", method = RequestMethod.GET)
	public Actor getActor(@PathVariable Integer id) {
		return actorService.getActor(id);
	}
	
	@RequestMapping(value="/actor/byname/{lastName}", method = RequestMethod.GET)
	public List<Actor> getActors(@PathVariable String lastName) {
		return actorService.getActors(lastName);
	}
	
	@RequestMapping(value="/actor/{id}", method = RequestMethod.DELETE)
	public void deleteActor(@PathVariable Integer id) {
		actorService.deleteActor(id);
	}
	
	@RequestMapping(value="/actor/{id}", method = RequestMethod.PUT)
	public Actor updateActor(@RequestBody Actor actor, @PathVariable Integer id) {
		return actorService.updateActor(actor);
	}
	
	@RequestMapping(value="/actor", method = RequestMethod.GET)
	public List<Actor> getAllActors() {
		return actorService.getAllActors();
	}
}
