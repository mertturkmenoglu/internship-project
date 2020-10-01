package io.github.mertturkmenoglu.actorinfo.responses;

import io.github.mertturkmenoglu.actorinfo.model.Actor;

import java.util.List;

public class AllActorsResponse {
    private List<Actor> actors;

    public AllActorsResponse() {

    }

    public AllActorsResponse(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
