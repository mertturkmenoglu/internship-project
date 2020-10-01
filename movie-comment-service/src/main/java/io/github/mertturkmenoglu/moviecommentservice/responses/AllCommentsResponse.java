package io.github.mertturkmenoglu.moviecommentservice.responses;

import io.github.mertturkmenoglu.moviecommentservice.model.Comment;

import java.util.List;

public class AllCommentsResponse {
    private List<Comment> comments;

    public AllCommentsResponse() {

    }

    public AllCommentsResponse(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
