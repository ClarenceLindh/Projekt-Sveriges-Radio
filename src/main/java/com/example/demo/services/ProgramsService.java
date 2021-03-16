package com.example.demo.services;

import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Service
@Table (name="programs")
public class ProgramsService {
    @Id // Berättar att det är en primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Aktiverar autoincrement
    private long id;
    private long channel_id;
    private String programcategoryid;
    private String title;
    private String description;
    private String publishdateutc;

    public ProgramsService() {
    }

    public ProgramsService(long id, long channel_id, String programcategoryid, String title, String description, String publishdateutc) {
        this.id = id;
        this.channel_id = channel_id;
        this.programcategoryid = programcategoryid;
        this.title = title;
        this.description = description;
        this.publishdateutc = publishdateutc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(long channel_id) {
        this.channel_id = channel_id;
    }

    public String getProgramcategoryid() {
        return programcategoryid;
    }

    public void setProgramcategoryid(String programcategoryid) {
        this.programcategoryid = programcategoryid;
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

    public String getPublishdateutc() {
        return publishdateutc;
    }

    public void setPublishdateutc(String publishdateutc) {
        this.publishdateutc = publishdateutc;
    }


    @Override
    public String toString() {
        return "ProgramsService{" +
                "id=" + id +
                ", channel_id=" + channel_id +
                ", programcategoryid='" + programcategoryid + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", publishdateutc='" + publishdateutc + '\'' +
                '}';
    }
}
