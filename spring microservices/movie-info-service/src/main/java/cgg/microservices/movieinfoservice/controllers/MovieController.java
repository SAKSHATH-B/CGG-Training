package cgg.microservices.movieinfoservice.controllers;

import cgg.microservices.movieinfoservice.entities.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

  @RequestMapping("/{movieId}")
  public Movie getMovieInfo(@PathVariable String movieId) {
    return new Movie(movieId, "Test name");
  }
}
