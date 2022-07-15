package com.informatorio.moviesfest.controller;

import com.informatorio.moviesfest.domain.Category;
import com.informatorio.moviesfest.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("/category")
    public Category createCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }
}
