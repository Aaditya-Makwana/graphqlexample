package com.aaditya.service;

import com.aaditya.model.Author;
import com.aaditya.model.Book;
import com.aaditya.repository.AuthorRepository;
import com.aaditya.repository.BookRepository;
import io.leangen.graphql.annotations.*;
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

    @Autowired
    private BookRepository bookRepository;

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

    @GraphQLMutation(name = "addAuthor")
    public Author createAuthor(@GraphQLArgument(name = "id") @GraphQLNonNull Long id,
                               @GraphQLArgument(name = "name") @GraphQLNonNull String name) {
        Author author = new Author(id, name);
        return authorRepository.save(author);
    }

    @GraphQLQuery(name = "authorBooks")
    public List<Book> getBooksByAuthor(@GraphQLContext Author author){
        return bookRepository.findAllById(author.getBookIds());
    }

//    @GraphQLMutation(name = "deleteByName")
//    public Author deleteAuthorByName(@GraphQLArgument(name = "name") String name){
//        Author author = authorRepository.findByName(name);
//        authorRepository.deleteById(author.getId());
//        return author;
//    }
}
