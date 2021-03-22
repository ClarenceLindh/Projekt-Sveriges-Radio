package com.example.demo.entities;

import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Table(name="programs")
public class Program{
    @Id // Berättar att det är en primary key
    private long id;
    private String name;
    private String description;
    private long categoryId;



    public Program() { }

    public Program(long id, String name, String description, long categoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "\nProgram{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }

}
