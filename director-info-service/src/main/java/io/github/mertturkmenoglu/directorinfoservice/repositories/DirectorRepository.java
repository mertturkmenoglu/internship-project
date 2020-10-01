package io.github.mertturkmenoglu.directorinfoservice.repositories;

import io.github.mertturkmenoglu.directorinfoservice.model.Director;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends MongoRepository<Director, String> {

}
