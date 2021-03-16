package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name="category")
public class Category {
    @Id // Berättar att det är en primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // enables auto increment
    private long id;


    public Category() {
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