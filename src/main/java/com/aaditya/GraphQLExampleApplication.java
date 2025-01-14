package com.aaditya;

import com.aaditya.model.Author;
import com.aaditya.model.Book;
import com.aaditya.repository.AuthorRepository;
import com.aaditya.repository.BookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class GraphQLExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(GraphQLExampleApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(AuthorRepository authorRepository, BookRepository bookRepository){
        return args -> {
//            Author josh = authorRepository.save(new Author(null, "Josh Long"));
//            Author mark = authorRepository.save(new Author(null, "Mark Short"));
//            bookRepository.saveAll(List.of(
//                    new Book("Long", "LongPub", josh.getId()),
//                    new Book("Short", "ShortPub", mark.getId()),
//                    new Book("Spring boot", "JavaPub", josh.getId())
//            ));
        };
    }
}
