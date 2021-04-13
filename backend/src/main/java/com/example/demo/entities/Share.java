package com.example.demo.entities;

import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Table(name="shares")
@SecondaryTable(name = "friend_relationships")
@SecondaryTable(name = "users")
public class Share {
    @Id // Berättar att det är en primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Aktiverar autoincrement
    private long id;
    private long userid;
    private long program_id;
    private String programname;
    private long episode_id;
    private String episodename;
    private String time_added;
    @Embedded
    private Username username;

    public Share() {
    }

    public Share(long user_id, long program_id, long episode_id) {
        this.userid = user_id;
        this.program_id = program_id;
        this.episode_id = episode_id;
    }

    public Share(long userid, long program_id, String programname, long episode_id, String episodename) {
        this.userid = userid;
        this.program_id = program_id;
        this.programname = programname;
        this.episode_id = episode_id;
        this.episodename = episodename;
    }

    public Share(long id, long userid, long program_id, String programname, long episode_id, String episodename, String time_added, Username username) {
        this.id = id;
        this.userid = userid;
        this.program_id = program_id;
        this.programname = programname;
        this.episode_id = episode_id;
        this.episodename = episodename;
        this.time_added = time_added;
        this.username = username;
    }

//region getset
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getProgram_id() {
        return program_id;
    }

    public void setProgram_id(long program_id) {
        this.program_id = program_id;
    }

    public String getProgramname() {
        return programname;
    }

    public void setProgramname(String programname) {
        this.programname = programname;
    }

    public long getEpisode_id() {
        return episode_id;
    }

    public void setEpisode_id(long episode_id) {
        this.episode_id = episode_id;
    }

    public String getEpisodename() {
        return episodename;
    }

    public void setEpisodename(String episodename) {
        this.episodename = episodename;
    }

    public String getTime_added() {
        return time_added;
    }

    public void setTime_added(String time_added) {
        this.time_added = time_added;
    }

    public Username getUsername() {
        return username;
    }

    public void setUsername(Username username) {
        this.username = username;
    }
//endregion


    @Override
    public String toString() {
        return "Share{" +
                "id=" + id +
                ", userid=" + userid +
                ", program_id=" + program_id +
                ", programname='" + programname + '\'' +
                ", episode_id=" + episode_id +
                ", episodename='" + episodename + '\'' +
                ", time_added='" + time_added + '\'' +
                ", username=" + username +
                '}';
    }
}

@Embeddable
class Username{
    @Column(name = "username", table = "users")
    String username;

    public Username(){}

    public Username(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Username{" +
                "username='" + username + '\'' +
                '}';
    }
}