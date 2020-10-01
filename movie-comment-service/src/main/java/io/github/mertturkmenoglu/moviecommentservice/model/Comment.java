package io.github.mertturkmenoglu.moviecommentservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Comments")
public class Comment {
    @Id
    private String id;
    private String movieId;
    private String username;
    private String content;
    private String point;
    private String date;

    public Comment() {

    }

    public Comment(String movieId, String username, String content, String point, String date) {
        this.movieId = movieId;
        this.username = username;
        this.content = content;
        this.point = point;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
