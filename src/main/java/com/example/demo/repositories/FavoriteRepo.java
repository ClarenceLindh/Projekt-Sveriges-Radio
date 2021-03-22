package com.example.demo.repositories;


import com.example.demo.entities.Favorite;
import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepo extends JpaRepository<Favorite, Long> {
    List<Favorite> findByUserid(Long user_id);
}
