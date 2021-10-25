package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Actor;

public interface ActorService {

	public Actor addActor(Actor actor);
	public Actor getActor(Integer id);
	public List<Actor> getActors(String lastName);
	public void deleteActor(Integer id);
	public Actor updateActor(Actor actor);
	public List<Actor> getAllActors();
}
