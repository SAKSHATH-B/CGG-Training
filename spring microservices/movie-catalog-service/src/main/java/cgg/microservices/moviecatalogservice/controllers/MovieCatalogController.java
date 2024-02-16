package cgg.microservices.moviecatalogservice.controllers;

import cgg.microservices.moviecatalogservice.entities.CatalogItem;
import cgg.microservices.moviecatalogservice.entities.Movie;
import cgg.microservices.moviecatalogservice.entities.UserRating;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private RestClient restClient;

  @Autowired
  private RestClient.Builder restClientBuilder;

  @RequestMapping("/{userId}")
  public List<CatalogItem> getCatalog(@PathVariable String userId) {
    // UserRating ratings = restTemplate.getForObject(
    //   "http://ratings-data-service/ratingsdata/users/" + userId,
    //   UserRating.class
    // );

    UserRating ratings = restClientBuilder
      .build()
      .get()
      .uri("http://ratings-data-service/ratingsdata/users/" + userId)
      .retrieve()
      .body(UserRating.class);

    // List<Rating> ratings = Arrays.asList(
    //   new Rating("1234", 4),
    //   new Rating("5678", 3)
    // );

    //using restClient
    return ratings
      .getUserRating()
      .stream()
      .map(rating -> {
        // Movie movie = restTemplate.getForObject(
        //   "http://movie-info-service/movies/" + rating.getMovieId(),
        //   Movie.class
        // );

        Movie movie = restClientBuilder
          .build()
          .get()
          .uri("http://movie-info-service/movies/" + rating.getMovieId())
          .retrieve()
          .body(Movie.class);
        return new CatalogItem(movie.getName(), "Test", rating.getRating());
      })
      .collect(Collectors.toList());
    ///using restTemplate
    // return ratings
    //   .stream()
    //   .map(rating -> {
    //     Movie movie = restTemplate.getForObject(
    //       "http://localhost:8082/movies/" + rating.getMovieId(),
    //       Movie.class
    //     );
    //     return new CatalogItem(movie.getName(), "Test", rating.getRating());
    //   })
    //   .collect(Collectors.toList());
    // return ratings
    //   .stream()
    //   .map(rating -> new CatalogItem("Transformers", "Test", 4))
    //   .collect(Collectors.toList());
    // return Collections.singletonList(
    //   new CatalogItem("Transformers", "Test", 4)
    // );
  }
}
