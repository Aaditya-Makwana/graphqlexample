package com.aaditya.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "book")
public class Book{

    @Id
    private Long id;
    private String title;
    private String publisher;
    private Long authorId;

    // Constructor
    public Book(String title, String publisher, Long authorId) {
        this.title = title;
        this.publisher = publisher;
        this.authorId = authorId;
    }

    public Book() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
