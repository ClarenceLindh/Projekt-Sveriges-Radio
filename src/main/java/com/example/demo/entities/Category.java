package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name="categories")
public class Category {
    @Id // Berättar att det är en primary key
    private Long id;
    private String name;


    public Category() {}

    public Category(Long id, String name){
        this.id = id;
        this.name = name;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'';
    }
}