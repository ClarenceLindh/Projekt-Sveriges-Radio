package com.example.demo.entities;

import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Table(name="programs")
public class Program{
    @Id // Berättar att det är en primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // enable auto increment
    private long id;
    private long channelid;
    private String programcategoryid;
    private String title;
    private String description;
    private String broadcastinfo;

    public Program() { }

    public Program(long id, long channelid, String programcategoryid, String title, String description, String broadcastinfo) {
        this.id = id;
        this.channelid = channelid;
        this.programcategoryid = programcategoryid;
        this.title = title;
        this.description = description;
        this.broadcastinfo = broadcastinfo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getChannelId() {
        return channelid;
    }

    public void setChannelId(long channelId) {
        this.channelid = channelId;
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

    public String getBroadcastinfo() {
        return broadcastinfo;
    }

    public void setBroadcastinfo(String broacastinfo) {
        this.broadcastinfo = broadcastinfo;
    }


    @Override
    public String toString() {
        return "/mProgramsService{" +
                "id=" + id +
                ", channelid=" + channelid +
                ", programcategoryid='" + programcategoryid + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", broadcastinfo='" + broadcastinfo + '\'' +
                '}';
    }
}
