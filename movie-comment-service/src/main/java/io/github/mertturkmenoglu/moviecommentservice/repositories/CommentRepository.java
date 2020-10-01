package io.github.mertturkmenoglu.moviecommentservice.repositories;

import io.github.mertturkmenoglu.moviecommentservice.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {

}
