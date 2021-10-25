package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Actor;

public interface ActorRepository extends JpaRepository<Actor,Integer> {

	public List<Actor> findByLastName(String lastName);
}
