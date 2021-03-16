package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name="categories")
public class Category {
    @Id // Berättar att det är en primary key
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