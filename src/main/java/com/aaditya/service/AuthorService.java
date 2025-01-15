package com.aaditya.service;

import com.aaditya.model.Author;
import com.aaditya.repository.AuthorRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@GraphQLApi
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @GraphQLQuery(name = "authors")
    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    @GraphQLQuery(name = "authorById")
    public Author getAuthorById(@GraphQLArgument Long id){
        return authorRepository.findById(id).orElse(null);
    }

//    @GraphQLQuery(name = "findByName")
//    public Author findAuthorByName(@GraphQLArgument(name = "name") String name){
//        return authorRepository.findByName(name);
//    }

    @GraphQLMutation(name = "createAuthor")
    public Author createAuthor(@GraphQLArgument(name = "id") @GraphQLNonNull Long id,
                               @GraphQLArgument(name = "name") @GraphQLNonNull String name) {
        Author author = new Author(id, name);
        return authorRepository.save(author);
    }

//    @GraphQLMutation(name = "deleteByName")
//    public Author deleteAuthorByName(@GraphQLArgument(name = "name") String name){
//        Author author = authorRepository.findByName(name);
//        authorRepository.deleteById(author.getId());
//        return author;
//    }
}
