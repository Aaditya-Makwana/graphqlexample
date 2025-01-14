package com.aaditya.service;

import com.aaditya.model.Author;
import com.aaditya.repository.AuthorRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@GraphQLApi
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @GraphQLQuery(name = "authors")
    public Iterable<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    @GraphQLQuery(name = "authorById")
    public Author getAuthorById(@GraphQLArgument Long id){
        return authorRepository.findById(id).orElse(null);
    }

    @GraphQLMutation(name = "createAuthor")
    public Author createAuthor(@GraphQLArgument(name = "name") String name) {
        Author author = new Author();
        author.setName(name);
        return authorRepository.save(author);
    }

    @GraphQLQuery(name = "findByName")
    public Author findAuthorByName(@GraphQLArgument(name = "name") String name){
        return authorRepository.findByName(name);
    }

    @GraphQLMutation(name = "deleteByName")
    public Author deleteAuthorByName(@GraphQLArgument(name = "name") String name){
        Author author = authorRepository.findByName(name);
        authorRepository.deleteById(author.getId());
        return author;
    }
}