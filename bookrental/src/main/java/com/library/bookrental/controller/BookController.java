package com.library.bookrental.controller;

import com.library.bookrental.model.Book;
import com.library.bookrental.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")

public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }
}
