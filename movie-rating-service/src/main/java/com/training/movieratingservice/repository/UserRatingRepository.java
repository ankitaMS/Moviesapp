package com.training.movieratingservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.training.movieratingservice.model.UserRating;

public interface UserRatingRepository extends MongoRepository<UserRating, String> {

}
