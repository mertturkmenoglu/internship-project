package io.github.mertturkmenoglu.actorinfo.exceptions;

public class ActorNotFoundException extends RuntimeException {
    public ActorNotFoundException(String id) {
        super("Actor not found. Id: " + id);
    }
}
