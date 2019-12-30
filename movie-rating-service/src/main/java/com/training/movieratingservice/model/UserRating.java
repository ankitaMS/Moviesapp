package com.training.movieratingservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userratings")
public class UserRating {

	@Id
	private String userId;
	private List<Rating> ratings;

	public UserRating(String userId, List<Rating> ratings) {
		super();
		this.userId = userId;
		this.ratings = ratings;
	}

	public UserRating() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

}
