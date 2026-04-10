package com.library.bookrental.controller;

import com.library.bookrental.model.Category;
import com.library.bookrental.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")

public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }
}
