package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Director;

public interface DirectorRepository extends JpaRepository<Director,Integer>{

	public List<Director> findByLastName(String lastName);
}
