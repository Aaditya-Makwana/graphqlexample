package com.aaditya.controller;

import com.aaditya.model.Author;
import com.aaditya.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @QueryMapping
    Iterable<Author> authors(){
        return authorRepository.findAll();
    }

    @QueryMapping
    Optional<Author> authorById(@Argument Long id){
        return authorRepository.findById(id);
    }
}
