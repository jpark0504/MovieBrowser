package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Actor;
import com.example.demo.repo.ActorRepository;

@Service
public class ActorServiceImpl implements ActorService {

	@Autowired
	private ActorRepository actRepo;
	
	@Override
	@Transactional
	public Actor addActor(Actor actor) {
		Actor result = null;
		try {
			result = actRepo.save(actor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;		
	}

	@Override
	public Actor getActor(Integer id) {
		Optional<Actor> result = actRepo.findById(id);
		return result.isEmpty() ? null: result.get();
	}

	@Override
	public List<Actor> getActors(String lastName) {
		return actRepo.findByLastName(lastName);
	}

	@Override
	public void deleteActor(Integer id) {
		actRepo.deleteById(id);
	}

	@Override
	public Actor updateActor(Actor actor) {
		Optional<Actor> result = actRepo.findById(actor.getId());
		if (result.isPresent()) {
			return actRepo.save(actor);
		} else {
			return null;
		}
	}

	@Override
	public List<Actor> getAllActors() {
		return actRepo.findAll();
	}

}
