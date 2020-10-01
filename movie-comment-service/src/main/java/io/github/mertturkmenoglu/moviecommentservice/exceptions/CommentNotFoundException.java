package io.github.mertturkmenoglu.moviecommentservice.exceptions;

public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException(String id) {
        super("Comment not found. Id: " + id);
    }
}
