package com.example.demo.services;


import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Service
@Table(name="favorites")
public class FavoriteService {
    @Id // Berättar att det är en primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Aktiverar autoincrement
    private long id;
    private long user_id;
    private long channel_id;
    private long program_id;
    private long episode_id;

    public FavoriteService() {
    }

    public FavoriteService(long id, long user_id, long channel_id, long program_id, long episode_id) {
        this.id = id;
        this.user_id = user_id;
        this.channel_id = channel_id;
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
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(long channel_id) {
        this.channel_id = channel_id;
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

    @Override
    public String toString() {
        return "FavoriteService{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", channel_id=" + channel_id +
                ", program_id=" + program_id +
                ", episode_id=" + episode_id +
                '}';
    }
}
