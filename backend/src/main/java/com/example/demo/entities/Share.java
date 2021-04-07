package com.example.demo.entities;

import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Table(name="shares")
public class Share {
    @Id // Berättar att det är en primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Aktiverar autoincrement
    private long id;
    private long userid;
    private long program_id;
    private long episode_id;
    private String time_added;

    public Share() {
    }

    public Share(long user_id, long program_id, long episode_id) {
        this.userid = user_id;
        this.program_id = program_id;
        this.episode_id = episode_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return userid;
    }

    public void setUser_id(long user_id) {
        this.userid = user_id;
    }

    public long getProgram_id() {
        return program_id;
    }

    public void setProgram_id(long program_id) {
        this.program_id = program_id;
    }

    public long getEpisode_id() {
        return episode_id;
    }

    public void setEpisode_id(long episode_id) {
        this.episode_id = episode_id;
    }

    public String getTime_added() {
        return time_added;
    }

    public void setTime_added(String time_added) {
        this.time_added = time_added;
    }

    @Override
    public String toString() {
        return "\nFavoriteService{" +
                "id=" + id +
                ", user_id=" + userid +
                ", program_id=" + program_id +
                ", episode_id=" + episode_id +
                ", time_added=" + time_added +
                '}';
    }
}
