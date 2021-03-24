package com.example.demo.controllers;


import com.example.demo.entities.Category;
import com.example.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class CategoriesController {
    @Autowired
    private CategoryService categoryService;

//______________________________Get all categories_______________________________
    @GetMapping("/categories")
    public List<Category> getAll() {
        return categoryService.getAll();
    }

//_________________________Get a specific category by id_________________________
    @GetMapping("/categories/{id}")
    public List<Category> getById(@PathVariable long id){ return categoryService.getById(id); }
}
