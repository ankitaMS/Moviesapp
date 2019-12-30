package com.training.moviecatalogservice.model;

import java.util.List;


public class Rating {

	private int movieId;
	private int rating;
	/*
	 * private String movieTitle; private int releaseYear; private String category;
	 * private List<String> cast;
	 */
	public Rating(int movieId, int rating) {
		super();
		this.movieId = movieId;
		this.rating = rating;
	}
	public Rating() {
		super();
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}

}
