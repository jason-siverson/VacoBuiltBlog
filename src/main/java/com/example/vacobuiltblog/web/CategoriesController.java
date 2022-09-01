package com.example.vacobuiltblog.web;

import com.example.vacobuiltblog.database.CategoryRepository;
import com.example.vacobuiltblog.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriesController {

    private final CategoryRepository repository;

    CategoriesController(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/categories")
    List<Category> all() {
        return repository.findAll();
    }

}
