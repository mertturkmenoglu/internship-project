package io.github.mertturkmenoglu.directorinfoservice.controllers;

import io.github.mertturkmenoglu.directorinfoservice.exceptions.DirectorNotFoundException;
import io.github.mertturkmenoglu.directorinfoservice.model.Director;
import io.github.mertturkmenoglu.directorinfoservice.repositories.DirectorRepository;
import io.github.mertturkmenoglu.directorinfoservice.requests.UpdateMoviesRequest;
import io.github.mertturkmenoglu.directorinfoservice.responses.AllDirectorsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/director")
public class DirectorInfoController {
    @Autowired
    private DirectorRepository directorRepository;

    @GetMapping("/all")
    public AllDirectorsResponse getAllDirectors() {
        return new AllDirectorsResponse(directorRepository.findAll());
    }

    @GetMapping("/{id}")
    public Director getDirectorById(@PathVariable("id") String id) {
        return directorRepository.findById(id).orElseThrow(() -> new DirectorNotFoundException(id));
    }

    @PostMapping("/")
    public void newDirector(@RequestBody Director director) {
        directorRepository.save(director);
    }

    @PutMapping("/{id}/movies")
    public Director updateMovies(@RequestBody UpdateMoviesRequest moviesRequest, @PathVariable("id") String id) {
        return directorRepository.findById(id)
                .map(d -> {
                    d.setMovies(moviesRequest.getMovies());
                    return directorRepository.save(d);
                })
                .orElseGet(() -> directorRepository.findById(id).orElseThrow(() -> new DirectorNotFoundException(id)));
    }

    @PutMapping("/{id}")
    public Director updateDirector(@RequestBody Director director, @PathVariable("id") String id) {
        return directorRepository.findById(id)
                .map(d -> {
                    d.setName(director.getName());
                    d.setBdate(director.getBdate());
                    d.setDescription(director.getDescription());
                    d.setImage(director.getImage());
                    d.setMovies(director.getMovies());
                    return directorRepository.save(d);
                })
                .orElseGet(() -> {
                    director.setId(id);
                    return directorRepository.save(director);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteDirector(@PathVariable("id") String id) {
        directorRepository.deleteById(id);
    }
}
