package com.library.bookrental.service;

import com.library.bookrental.model.Book;
import com.library.bookrental.model.User;
import com.library.bookrental.model.Rental;

import com.library.bookrental.repository.BookRepository;
import com.library.bookrental.repository.UserRepository;
import com.library.bookrental.repository.RentalRepository;

import com.library.bookrental.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental saveRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    public Rental rentBook(Long bookId, Long userId) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        if (!book.isAvailable()) {
            throw new RuntimeException("Book is not available");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        book.setAvailable(false);

        Rental rental = new Rental();
        rental.setBook(book);
        rental.setUser(user);
        rental.setRentalDate(LocalDate.now());

        return rentalRepository.save(rental);
    }

    public Rental returnBook(Long rentalId) {

        Rental rental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new ResourceNotFoundException("Rental not found"));

        rental.setReturnDate(LocalDate.now());

        Book book = rental.getBook();
        book.setAvailable(true);

        return rentalRepository.save(rental);
    }
}