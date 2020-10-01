package io.github.mertturkmenoglu.directorinfoservice.responses;

import io.github.mertturkmenoglu.directorinfoservice.model.Director;

import java.util.List;

public class AllDirectorsResponse {
    private List<Director> directors;

    public AllDirectorsResponse() {

    }

    public AllDirectorsResponse(List<Director> directors) {
        this.directors = directors;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }
}
