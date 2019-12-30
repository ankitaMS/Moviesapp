package com.training.movieinfoservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.movieinfoservice.model.Movie;
import com.training.movieinfoservice.repository.MovieRepository;

@RestController
@RequestMapping("/api")
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;

	@GetMapping("/movie/{movieId}")
	public ResponseEntity<Movie> getMovieDetails(@PathVariable int movieId) {
		Optional<Movie> result = movieRepository.findById(movieId);
		ResponseEntity<Movie> response = null;
		if (result.isPresent())
			response = new ResponseEntity<Movie>(result.get(), HttpStatus.OK);
		else
		response = new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
		return response;
	}

	@GetMapping("/movies/{category}")
	public HttpEntity<List<Movie>> getMovieDetailsByCategory(@PathVariable String category) {
		List<Movie> findByCategory = movieRepository.findByCategory(category);
		return new HttpEntity<List<Movie>>(findByCategory);
	}
}
