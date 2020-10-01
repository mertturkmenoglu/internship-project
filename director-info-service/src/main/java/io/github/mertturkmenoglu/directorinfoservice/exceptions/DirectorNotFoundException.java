package io.github.mertturkmenoglu.directorinfoservice.exceptions;

public class DirectorNotFoundException extends RuntimeException {
    public DirectorNotFoundException(String id) {
        super("Director not found. Id: " + id);
    }
}
