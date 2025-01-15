package com.aaditya.service;

import com.aaditya.model.Author;
import com.aaditya.model.Book;
import com.aaditya.repository.AuthorRepository;
import com.aaditya.repository.BookRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@GraphQLApi
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @GraphQLQuery(name = "books")
    public Iterable<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @GraphQLMutation(name = "addBook")
    public Book addBook(@GraphQLArgument(name = "id") @GraphQLNonNull Long id,
                        @GraphQLArgument(name = "title") @GraphQLNonNull String title,
                        @GraphQLArgument(name = "publisher") String publisher,
                        @GraphQLArgument(name = "authorId") @GraphQLNonNull Long authorId){
        Optional<Author> author = authorRepository.findById(authorId);
        if(author.isEmpty()){
            return null;
        }

        Book book = new Book(id, title, publisher, authorId);
        author.get().addBookId(id);
        authorRepository.save(author.get());
        return bookRepository.save(book);
    }
}
