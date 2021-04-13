package com.example.demo.entities;

import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Table(name="friend_relationships")
@SecondaryTable(name ="users")
public class Friend {
    @Id // Berättar att det är en primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Aktiverar autoincrement
    private long id;
    private long userid;
    private long friendsid;
    @Embedded
    Username username;

    public Friend() {
    }

    public Friend(long user_id, long friends_id) {
        this.userid = user_id;
        this.friendsid = friends_id;
    }

    public Friend(long id, long userid, long friendsid, Username username) {
        this.id = id;
        this.userid = userid;
        this.friendsid = friendsid;
        this.username = username;
    }

    public Username getUsername() {
        return username;
    }

    public void setUsername(Username username) {
        this.username = username;
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

    public long getFriends_id() {
        return friendsid;
    }

    public void setFriends_id(long friends_id) {
        this.friendsid = friends_id;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", userid=" + userid +
                ", friendsid=" + friendsid +
                ", username=" + username +
                '}';
    }
}