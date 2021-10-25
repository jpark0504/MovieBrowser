package com.example.demo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FilmMaker;
import com.example.demo.repo.FilmMakerRepository;

@Service
public class FilmMakerServiceImpl implements FilmMakerService {

	@Autowired
	private FilmMakerRepository filmRepo;
	
	@Override
	@Transactional
	public FilmMaker addFilmMaker(FilmMaker fMaker) {
		return filmRepo.save(fMaker);
	}

	@Override
	public FilmMaker getFilmMaker(Integer id) {
		Optional<FilmMaker> result = filmRepo.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	@Override
	public FilmMaker updateFilmMaker(FilmMaker fMaker) {
		Optional<FilmMaker> result = filmRepo.findById(fMaker.getId());
		if (result.isPresent()) {
			return filmRepo.save(fMaker);
		} else {
			return null;
		}
	}

	@Override
	public void deleteFilmMaker(Integer id) {
		Optional<FilmMaker> result = filmRepo.findById(id);
		if (result.isPresent()) {
			filmRepo.deleteById(id);
		}
	}

}
