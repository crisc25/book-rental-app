package com.library.bookrental.controller;

import com.library.bookrental.model.Rental;
import com.library.bookrental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;


    @GetMapping
    public ResponseEntity<List<Rental>> getRentals() {
        return ResponseEntity.ok(rentalService.getAllRentals());
    }


    @PostMapping
    public ResponseEntity<Rental> addRental(@RequestBody Rental rental) {
        return ResponseEntity.status(201).body(rentalService.saveRental(rental));
    }


    @PostMapping("/rent")
    public ResponseEntity<Rental> rentBook(@RequestParam Long bookId,
                                           @RequestParam Long userId) {
        return ResponseEntity.status(201).body(rentalService.rentBook(bookId, userId));
    }


    @PostMapping("/return")
    public ResponseEntity<Rental> returnBook(@RequestParam Long rentalId) {
        return ResponseEntity.ok(rentalService.returnBook(rentalId));
    }
}