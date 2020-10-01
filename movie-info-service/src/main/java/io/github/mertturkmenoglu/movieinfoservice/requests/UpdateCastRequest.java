package io.github.mertturkmenoglu.movieinfoservice.requests;

import java.util.List;

public class UpdateCastRequest {
    private List<String> cast;

    public UpdateCastRequest() {

    }

    public UpdateCastRequest(List<String> cast) {
        this.cast = cast;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }
}
