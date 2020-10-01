package io.github.mertturkmenoglu.movieinfoservice.repositories;

import io.github.mertturkmenoglu.movieinfoservice.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

}
