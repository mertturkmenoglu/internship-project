package io.github.mertturkmenoglu.actorinfo.requests;

import java.util.List;

public class UpdateMoviesRequest {
    private List<String> movies;

    public UpdateMoviesRequest() {
    }

    public UpdateMoviesRequest(List<String> movies) {
        this.movies = movies;
    }

    public List<String> getMovies() {
        return movies;
    }

    public void setMovies(List<String> movies) {
        this.movies = movies;
    }
}
