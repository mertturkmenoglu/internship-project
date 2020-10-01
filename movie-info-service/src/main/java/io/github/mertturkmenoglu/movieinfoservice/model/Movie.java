package io.github.mertturkmenoglu.movieinfoservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Movies")
public class Movie {
    @Id
    private String id;
    private String name;
    private String year;
    private List<String> cast;
    private String directorId;
    private String description;
    private String image;
    private String genre;

    public Movie() {

    }

    public Movie(String name, String year, List<String> cast, String directorId, String description, String image, String genre) {
        this.name = name;
        this.year = year;
        this.cast = cast;
        this.directorId = directorId;
        this.description = description;
        this.image = image;
        this.genre = genre;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public String getDirectorId() {
        return directorId;
    }

    public void setDirectorId(String directorId) {
        this.directorId = directorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
