package io.github.mertturkmenoglu.actorinfo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Actors")
public class Actor {
    @Id
    private String id;
    private String name;
    private String image;
    private String bdate;
    private List<String> movies;
    private String description;

    public Actor() {
    }

    public Actor(String name, String image, String bdate, List<String> movies, String description) {
        this.name = name;
        this.image = image;
        this.bdate = bdate;
        this.movies = movies;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public List<String> getMovies() {
        return movies;
    }

    public void setMovies(List<String> movies) {
        this.movies = movies;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
