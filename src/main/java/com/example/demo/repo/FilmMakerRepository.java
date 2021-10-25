package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.FilmMaker;

public interface FilmMakerRepository extends JpaRepository<FilmMaker,Integer>{

}
