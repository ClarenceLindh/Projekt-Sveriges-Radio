package com.example.demo.repositories;


import com.example.demo.entities.Favorite;
import com.example.demo.entities.Share;
import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareRepo extends JpaRepository<Share, Long> {
    List<Share> findByUserid(Long user_id);

    @Query(value = "SELECT " +
            "username, shares.id, shares.userid, program_id, programname, episode_id, " +
            "episodename, time_added " +
            "FROM users, friend_relationships, shares " +
            "WHERE friend_relationships.friendsid = users.id " +
            "AND shares.userid = users.id " +
            "AND friend_relationships.userid = ?1", nativeQuery = true)
    List<Share> getSharesFromFriends (Long id);
}