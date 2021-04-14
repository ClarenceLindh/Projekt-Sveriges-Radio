package com.example.demo.repositories;

import com.example.demo.entities.Episode;
import com.example.demo.entities.Friend;
import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepo extends JpaRepository<Friend, Long> {
    List<Friend> findByUserid(Long user_id);

    @Query(value = "SELECT username, " +
            "friend_relationships.id, friend_relationships.userid, friend_relationships.friendsid "+
            "FROM friend_relationships "+
            "JOIN users "+
            "ON friend_relationships.friendsid=users.id " +
            "WHERE friend_relationships.userid = ?1", nativeQuery = true)
    List<Friend> getFriend (Long id);
}

