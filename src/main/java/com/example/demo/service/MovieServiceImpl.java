package com.example.demo.service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Director;
import com.example.demo.model.FilmMaker;
import com.example.demo.model.Movie;
import com.example.demo.repo.DirectorRepository;
import com.example.demo.repo.FilmMakerRepository;
import com.example.demo.repo.MovieRepository;
import com.example.demo.util.MovieUtil;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepo;
	
	@Autowired
	private DirectorRepository dirRepo;
	
	@Autowired
	private FilmMakerRepository filmRepo;
	
	@Override
	@Transactional
	public Movie addMovie(Movie movie) {
		if (movie.getDirector() != null) {
			Optional<Director> d = dirRepo.findById(movie.getDirector().getId());
			if (d.isPresent()) {
				movie.setDirector(d.get());
			} else {
				movie.setDirector(dirRepo.save(movie.getDirector()));
			}
		}
		if (movie.getFilmMaker() != null) {
			Optional<FilmMaker> f = filmRepo.findById(movie.getFilmMaker().getId());
			if (f.isPresent()) {
				movie.setFilmMaker(f.get());
			} else {
				movie.setFilmMaker(filmRepo.save(movie.getFilmMaker()));
			}
		}
		MovieUtil.decodePoster(movie);
		return movieRepo.save(movie);
	}

	@Override
	public Movie getMovie(Integer id) {
		Optional<Movie> result = movieRepo.findById(id);
		return result.isPresent() ? MovieUtil.encodePoster(result.get()): null;
	}

	@Override
	public Movie updateMovie(Movie movie) {
		Optional<Movie> result = movieRepo.findById(movie.getId());
		if (result.isPresent()) {
			if (movie.getDirector() != null) {
				Optional<Director> d = dirRepo.findById(movie.getDirector().getId());
				if (d.isPresent()) {
					movie.setDirector(d.get());
				} else {
					movie.setDirector(dirRepo.save(movie.getDirector()));
				}
			}
			if (movie.getFilmMaker() != null) {
				Optional<FilmMaker> f = filmRepo.findById(movie.getFilmMaker().getId());
				if (f.isPresent()) {
					movie.setFilmMaker(f.get());
				} else {
					movie.setFilmMaker(filmRepo.save(movie.getFilmMaker()));
				}
			}
			if (movie.getPoster_encoded() != null) {
				movie.setPoster(Base64.getDecoder().decode(movie.getPoster_encoded()));
			}
			return movieRepo.save(movie);
		} else {
			return null;
		}
	}

	@Override
	public void deleteMovie(Integer id) {
		Optional<Movie> result = movieRepo.findById(id);
		if (result.isPresent()) {
			movieRepo.deleteById(id);
		}
	}

	@Override
	public List<Movie> searchByDirector(String director_name) {
		return MovieUtil.encodePoster(movieRepo.searchByDirector(director_name.toLowerCase()));
	}

	@Override
	public List<Movie> searchByFilmMaker(String filmmaker_name) {
		return MovieUtil.encodePoster(movieRepo.searchByFilmMaker(filmmaker_name.toLowerCase()));
	}

	@Override
	public List<Movie> searchByTitle(String title) {
		return MovieUtil.encodePoster(movieRepo.searchByTitle(title.toLowerCase()));
	}
	
	@Override
	public List<Movie> searchMovie(String text) {
		return MovieUtil.encodePoster(movieRepo.searchMovie(text.toLowerCase()));
	}

	@Override
	public List<Movie> getAllMovies() {
		return MovieUtil.encodePoster(movieRepo.findAll());
	}
}
