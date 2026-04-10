package com.library.bookrental.controller;

import com.library.bookrental.model.Rental;
import com.library.bookrental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @GetMapping
    public List<Rental> getRentals() {
        return rentalService.getAllRentals();
    }

    @PostMapping
    public Rental addRental(@RequestBody Rental rental) {
        return rentalService.saveRental(rental);
    }
}