package com.aaditya.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RedisHash("Author")
public class Author implements Serializable {

    @Id
    private Long id;

    @Indexed  // Optional: Allows searching by name
    private String name;

    // Store book IDs instead of Book objects (since Redis doesn't support relationships)
    private List<Long> bookIds = new ArrayList<>();

    public Author(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Author() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getBookIds() {
        return bookIds;
    }

    public void setBookIds(List<Long> bookIds) {
        this.bookIds = bookIds;
    }
}
