package com.library.bookrental.controller;


import com.library.bookrental.model.Review;
import com.library.bookrental.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Review> getReviews() {
        return reviewService.getAllReviews();
    }

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }
}
