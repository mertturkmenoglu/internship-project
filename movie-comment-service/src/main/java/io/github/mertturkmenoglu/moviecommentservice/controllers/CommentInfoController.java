package io.github.mertturkmenoglu.moviecommentservice.controllers;

import io.github.mertturkmenoglu.moviecommentservice.exceptions.CommentNotFoundException;
import io.github.mertturkmenoglu.moviecommentservice.model.Comment;
import io.github.mertturkmenoglu.moviecommentservice.repositories.CommentRepository;
import io.github.mertturkmenoglu.moviecommentservice.responses.AllCommentsResponse;
import io.github.mertturkmenoglu.moviecommentservice.responses.MovieCommentsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentInfoController {
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/")
    public AllCommentsResponse getAllComments() {
        return new AllCommentsResponse(commentRepository.findAll());
    }

    @GetMapping("/movie/{movieId}")
    public MovieCommentsResponse getMovieComments(@PathVariable("movieId") String movieId) {
        return new MovieCommentsResponse(
                movieId,
                commentRepository.findAll().stream()
                        .filter(comment -> comment.getMovieId().equals(movieId))
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/{id}")
    public Comment getComment(@PathVariable("id") String id) {
        return commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException(id));
    }

    @PostMapping("/")
    public void newComment(@RequestBody Comment comment) {
        commentRepository.save(comment);
    }

    @PutMapping("/{id}")
    public Comment updateComment(@RequestBody Comment comment, @PathVariable("id") String id) {
        return commentRepository.findById(id)
                .map(c -> {
                    c.setContent(comment.getContent());
                    c.setDate(comment.getDate());
                    c.setMovieId(comment.getMovieId());
                    c.setPoint(comment.getPoint());
                    c.setUsername(comment.getUsername());
                    return commentRepository.save(c);
                }).orElseGet(() -> {
                    comment.setId(id);
                    return commentRepository.save(comment);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable("id") String id) {
        commentRepository.deleteById(id);
    }
}
