package com.training.moviecatalogservice.model;

import java.util.List;


public class Movie {

	private int movieId;
	private String movieTitle;
	private int releaseYear;
	private String category;
	private List<String> cast;

	public Movie(int movieId, String movieTitle, int releaseYear, String category, List<String> cast) {
		super();
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.releaseYear = releaseYear;
		this.cast = cast;
		this.category = category;
	}

	public Movie() {
		super();
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public List<String> getCast() {
		return cast;
	}

	public void setCast(List<String> cast) {
		this.cast = cast;
	}

}
