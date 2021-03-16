package com.example.demo.entities;

import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Table(name="friend_relationships")
public class Friend {
    @Id // Berättar att det är en primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Aktiverar autoincrement
    private long id;
    private long user_id;
    private long friends_id;

    public Friend() {
    }

    public Friend(long id, long user_id, long friends_id) {
        this.id = id;
        this.user_id = user_id;
        this.friends_id = friends_id;
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

    public long getFriends_id() {
        return friends_id;
    }

    public void setFriends_id(long friends_id) {
        this.friends_id = friends_id;
    }

    @Override
    public String toString() {
        return "FriendsService{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", friends_id=" + friends_id +
                '}';
    }
}
