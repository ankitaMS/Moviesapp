package com.training.movieratingservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.movieratingservice.model.UserRating;
import com.training.movieratingservice.repository.UserRatingRepository;

@RestController
@RequestMapping("/api")
public class UserRatingController {

	@Autowired
	private UserRatingRepository userRatingRepository;
	
	@GetMapping("/ratings/{userId}")
	public ResponseEntity<UserRating> getAllUserRaings(@PathVariable String userId)
	{
		Optional<UserRating> findById = userRatingRepository.findById(userId);
		ResponseEntity<UserRating> responseEntity= null;
		if(findById.isPresent())
			responseEntity = new ResponseEntity<UserRating>(findById.get(), HttpStatus.OK);
		else
			responseEntity=new ResponseEntity<UserRating>(HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
}
