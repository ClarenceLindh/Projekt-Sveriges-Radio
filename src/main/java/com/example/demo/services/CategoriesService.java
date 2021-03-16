package com.example.demo.services;


import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Service
@Table(name="category")
public class CategoriesService {
    @Id // Berättar att det är en primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // enables auto increment
    private long id;


    public CategoriesService() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "CategoriesService{" +
                "id=" + id +
                '}';
    }
}
