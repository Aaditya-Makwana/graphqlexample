package com.aaditya.service;

import com.aaditya.model.Book;
import com.aaditya.repository.BookRepository;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@GraphQLApi
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @GraphQLQuery(name = "books")
    public Iterable<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
