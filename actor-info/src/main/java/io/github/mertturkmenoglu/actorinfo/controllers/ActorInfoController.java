package io.github.mertturkmenoglu.actorinfo.controllers;

import io.github.mertturkmenoglu.actorinfo.exceptions.ActorNotFoundException;
import io.github.mertturkmenoglu.actorinfo.model.Actor;
import io.github.mertturkmenoglu.actorinfo.repositories.ActorRepository;
import io.github.mertturkmenoglu.actorinfo.requests.UpdateMoviesRequest;
import io.github.mertturkmenoglu.actorinfo.responses.AllActorsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/actor")
public class ActorInfoController {
    @Autowired
    private ActorRepository actorRepository;

    @GetMapping("/all")
    public AllActorsResponse getAllActors() {
        return new AllActorsResponse(actorRepository.findAll());
    }

    @GetMapping("/{id}")
    public Actor getActorById(@PathVariable("id") String id) {
        return actorRepository.findById(id).orElseThrow(() -> new ActorNotFoundException(id));
    }

    @PostMapping("/")
    public void newActor(@RequestBody Actor actor) {
        actorRepository.save(actor);
    }

    @PutMapping("/{id}/movies")
    public Actor updateMovies(@RequestBody UpdateMoviesRequest moviesRequest, @PathVariable("id") String id) {
        return actorRepository.findById(id)
                .map(d -> {
                    d.setMovies(moviesRequest.getMovies());
                    return actorRepository.save(d);
                })
                .orElseGet(() -> actorRepository.findById(id).orElseThrow(() -> new ActorNotFoundException(id)));
    }

    @PutMapping("/{id}")
    public Actor updateActor(@RequestBody Actor actor, @PathVariable("id") String id) {
        return actorRepository.findById(id)
                .map(a -> {
                    a.setName(actor.getName());
                    a.setBdate(actor.getBdate());
                    a.setDescription(actor.getDescription());
                    a.setImage(actor.getImage());
                    a.setMovies(actor.getMovies());
                    return actorRepository.save(a);
                })
                .orElseGet(() -> {
                    actor.setId(id);
                    return actorRepository.save(actor);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable("id") String id) {
        actorRepository.deleteById(id);
    }
}
