package com.aaditya.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@RedisHash("Book")  // Stores this entity in Redis under the "Book" keyspace
public class Book implements Serializable {

    @Id
    private Long id;

    @Indexed  // Enables searching by title
    private String title;

    private String publisher;

    @Indexed  // Enables searching by authorId
    private Long authorId;  // Reference to the Author's ID instead of using @ManyToOne

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
