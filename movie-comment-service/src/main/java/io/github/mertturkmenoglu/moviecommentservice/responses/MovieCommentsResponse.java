package io.github.mertturkmenoglu.moviecommentservice.responses;

import io.github.mertturkmenoglu.moviecommentservice.model.Comment;

import java.util.List;

public class MovieCommentsResponse {
    private String movieId;
    private List<Comment> comments;

    public MovieCommentsResponse() {

    }

    public MovieCommentsResponse(String movieId, List<Comment> comments) {
        this.movieId = movieId;
        this.comments = comments;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
