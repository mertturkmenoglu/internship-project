package io.github.mertturkmenoglu.movieinfoservice.responses;

import io.github.mertturkmenoglu.movieinfoservice.model.Movie;

import java.util.List;

public class MovieSearchResponse {
    private List<Movie> movies;

    public MovieSearchResponse() {

    }

    public MovieSearchResponse(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
