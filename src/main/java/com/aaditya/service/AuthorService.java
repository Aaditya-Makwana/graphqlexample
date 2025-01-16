package com.aaditya.service;

import com.aaditya.model.Author;
import com.aaditya.model.Book;
import com.aaditya.repository.AuthorRepository;
import com.aaditya.repository.BookRepository;
import io.leangen.graphql.annotations.*;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import jakarta.transaction.Transactional;
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

    @GraphQLQuery(name = "getAuthorById")
    public Author getAuthorById(@GraphQLArgument Long id){
        return authorRepository.findById(id).orElse(null);
    }

    @GraphQLQuery(name = "authorBooks")
    public List<Book> getBooksByAuthor(@GraphQLContext Author author){
        return bookRepository.findAllById(author.getBookIds());
    }

    @GraphQLMutation(name = "addAuthor")
    public Author addAuthor(@GraphQLArgument(name = "id") @GraphQLNonNull Long id,
                               @GraphQLArgument(name = "name") @GraphQLNonNull String name) {
        return authorRepository.save(new Author(id, name));
    }

    @GraphQLMutation(name = "deleteAuthorById")
    @Transactional
    public void deleteAuthorById(@GraphQLArgument(name = "id") @GraphQLNonNull Long id){
        Optional<Author> author = authorRepository.findById(id);
        author.ifPresent(value -> value
                .getBookIds()
                .forEach(bookId -> bookRepository.deleteById(bookId)));
        authorRepository.deleteById(id);
    }
}
