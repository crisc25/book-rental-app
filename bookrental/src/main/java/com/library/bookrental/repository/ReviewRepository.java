package com.library.bookrental.repository;

import com.library.bookrental.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long>{
}
