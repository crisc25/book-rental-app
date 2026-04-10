package com.library.bookrental.service;


import com.library.bookrental.model.Rental;
import com.library.bookrental.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental saveRental(Rental rental) {
        return rentalRepository.save(rental);
    }
}
