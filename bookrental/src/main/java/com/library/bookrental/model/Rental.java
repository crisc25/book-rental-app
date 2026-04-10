package com.library.bookrental.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate rentalDate;
    private LocalDate returnDate;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;

    public Rental() {}

    public Rental(LocalDate rentalDate, LocalDate returnDate, User user, Book book) {
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.user = user;
        this.book = book;
    }

    // getters & setters
    public Long getId() { return id; }

    public LocalDate getRentalDate() { return rentalDate; }
    public void setRentalDate(LocalDate rentalDate) { this.rentalDate = rentalDate; }

    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
}