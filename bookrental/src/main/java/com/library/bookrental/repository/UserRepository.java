package com.library.bookrental.repository;
import com.library.bookrental.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
