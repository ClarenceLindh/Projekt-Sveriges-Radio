package com.example.demo.entities;

import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Table(name="episodes")
public class Episode {
    @Id // Berättar att det är en primary key
    private long id;
    private long program_id;
    String title;
    String description;
    String datetime;

    public Episode() {
    }

    public Episode(long id, long program_id, String title, String description, String datetime) {
        this.id = id;
        this.program_id = program_id;
        this.title = title;
        this.description = description;
        this.datetime = datetime;
    }

    public Episode(long id, long program_id, String title, String description) {
        this.id = id;
        this.program_id = program_id;
        this.title = title;
        this.description = description;
    }

    public Episode(long id,  String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProgram_id() {
        return program_id;
    }

    public void setProgram_id(long program_id) {
        this.program_id = program_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "EpisodesService{" +
                "id=" + id +
                ", program_id=" + program_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", datetime='" + datetime + '\'' +
                '}';
    }
}
