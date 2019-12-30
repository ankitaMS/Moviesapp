package com.training.movieinfoservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.training.movieinfoservice.model.Movie;

public interface MovieRepository extends MongoRepository<Movie, Integer> {

	public List<Movie> findByCategory(String category);
}
