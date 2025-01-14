package com.aaditya.repository;

import com.aaditya.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends MongoRepository<Author, Long> {
    Author findByName(String name);
}
