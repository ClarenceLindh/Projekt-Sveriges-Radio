package com.example.demo.controllers;


import com.example.demo.entities.Category;
import com.example.demo.entities.User;
import com.example.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChannelsController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/rest/categories")
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/rest/categories/{id}")
    public List<Category> getById(@PathVariable long id){ return categoryService.getById(id); }
}
