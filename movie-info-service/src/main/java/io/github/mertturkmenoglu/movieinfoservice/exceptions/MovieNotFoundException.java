package io.github.mertturkmenoglu.movieinfoservice.exceptions;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(String id) {
        super("Movie not found. Id: " + id);
    }
}
