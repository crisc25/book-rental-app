package com.library.bookrental.model;

import jakarta.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rating;
    private String comment;

    @ManyToOne
    private Book book;

    public Review() {}

    public Review(int rating, String comment, Book book) {
        this.rating = rating;
        this.comment = comment;
        this.book = book;
    }
    // getters & setters
    public Long getId() { return id; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
}