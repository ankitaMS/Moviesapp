package com.training.moviecatalogservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.training.moviecatalogservice.model.CatalogItem;
import com.training.moviecatalogservice.model.Movie;
import com.training.moviecatalogservice.model.MovieCatalog;
import com.training.moviecatalogservice.model.Rating;
import com.training.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/api")
public class MovieCatalogController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/catalog/{userId}")
	public ResponseEntity<MovieCatalog> getMovieCatalog(@PathVariable String userId)
	{
	
		//get the movie ratings for the specified user
		UserRating userRating = restTemplate.getForObject("http://MOVIE-RATING-SERVICE/api/ratings/"+userId, UserRating.class);
		List<Rating> ratings=userRating.getRatings();
		
		//get the movie details from the movie info service
		
		List<CatalogItem> catalogItems=new ArrayList<CatalogItem>();
		for(Rating rating: ratings) {
			Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/api/movie/"+rating.getMovieId(), Movie.class);
		//	CatalogItem catalogItem=new CatalogItem(movie,rating.getRating());
			catalogItems.add(new CatalogItem(movie,rating.getRating()));
		}
		
		MovieCatalog movieCatalog=new MovieCatalog(catalogItems);
		System.out.println("end");
		return new ResponseEntity<MovieCatalog>(movieCatalog,HttpStatus.OK);
		

	}
	
	
}
