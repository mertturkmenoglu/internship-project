package io.github.mertturkmenoglu.actorinfo.repositories;

import io.github.mertturkmenoglu.actorinfo.model.Actor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends MongoRepository<Actor, String> {

}
