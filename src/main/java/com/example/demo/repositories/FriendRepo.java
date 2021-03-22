package com.example.demo.repositories;


import com.example.demo.entities.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepo extends JpaRepository<Friend, Long> {
    List<Friend> findByUserid(Long user_id);
}
