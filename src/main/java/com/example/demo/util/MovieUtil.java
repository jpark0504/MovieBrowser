package com.example.demo.util;

import java.util.Base64;
import java.util.List;

import com.example.demo.model.Movie;

public class MovieUtil {

	public static void decodePoster(Movie movie) {
		if (movie.getPoster_encoded() != null) {
			movie.setPoster(Base64.getDecoder().decode(movie.getPoster_encoded()));
		}
	}
	
	public static Movie encodePoster(Movie movie) {
		if (movie.getPoster() != null) {
			movie.setPoster_encoded(Base64.getEncoder().encodeToString(movie.getPoster()));
		}
		return movie;
	}
	
	public static List<Movie> encodePoster(List<Movie> movies) {
		for (Movie m: movies) {
			encodePoster(m);
		}
		return movies;
	}
}
