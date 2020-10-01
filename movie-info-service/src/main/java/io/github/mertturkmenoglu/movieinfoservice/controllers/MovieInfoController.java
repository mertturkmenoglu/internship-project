package io.github.mertturkmenoglu.movieinfoservice.controllers;

import io.github.mertturkmenoglu.movieinfoservice.exceptions.MovieNotFoundException;
import io.github.mertturkmenoglu.movieinfoservice.model.Movie;
import io.github.mertturkmenoglu.movieinfoservice.repositories.MovieRepository;
import io.github.mertturkmenoglu.movieinfoservice.requests.UpdateCastRequest;
import io.github.mertturkmenoglu.movieinfoservice.responses.AllMoviesResponse;
import io.github.mertturkmenoglu.movieinfoservice.responses.MovieSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/movie")
public class MovieInfoController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/all")
    public AllMoviesResponse getAllMovies() {
        return new AllMoviesResponse(movieRepository.findAll());
    }

    @GetMapping("/")
    public MovieSearchResponse searchMovies(@RequestParam String search) {
        return new MovieSearchResponse(movieRepository.findAll().stream()
                .filter(movie -> movie.getName().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable("id") String id) {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
    }

    @PostMapping("/")
    public void newMovie(@RequestBody Movie movie) {
        movieRepository.save(movie);
    }

    @PutMapping("/{id}/cast")
    public Movie updateCast(@RequestBody UpdateCastRequest castRequest, @PathVariable("id") String id) {
        return movieRepository.findById(id)
                .map(d -> {
                    d.setCast(castRequest.getCast());
                    return movieRepository.save(d);
                })
                .orElseGet(() -> movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id)));
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@RequestBody Movie movie, @PathVariable("id") String id) {
        return movieRepository.findById(id)
                .map(m -> {
                    m.setName(movie.getName());
                    m.setYear(movie.getYear());
                    m.setCast(movie.getCast());
                    m.setDirectorId(movie.getDirectorId());
                    m.setDescription(movie.getDescription());
                    m.setImage(movie.getImage());
                    m.setGenre(movie.getGenre());
                    return movieRepository.save(m);
                })
                .orElseGet(() -> {
                    movie.setId(id);
                    return movieRepository.save(movie);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable("id") String id) {
        movieRepository.deleteById(id);
    }
}
