package com.example.demo.repositories;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query(value = "SELECT username, users.id, users.password "+
            "FROM friend_relationships "+
            "JOIN users "+
            "ON friend_relationships.friendsid=users.id " +
            "WHERE friend_relationships.userid = ?1", nativeQuery = true)
    List<User> getFriend (Long id);
}
