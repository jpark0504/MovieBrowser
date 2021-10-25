package com.example.demo.service;

import com.example.demo.model.FilmMaker;

public interface FilmMakerService {
	
	public FilmMaker addFilmMaker(FilmMaker fMaker);
	public FilmMaker getFilmMaker(Integer id);
	public FilmMaker updateFilmMaker(FilmMaker fMaker);
	public void deleteFilmMaker(Integer id);

}
