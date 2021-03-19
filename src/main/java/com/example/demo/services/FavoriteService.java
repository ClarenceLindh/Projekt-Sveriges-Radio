package com.example.demo.services;


import com.example.demo.entities.Favorite;
import com.example.demo.entities.User;
import com.example.demo.repositories.FavoriteRepo;
import com.example.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class FavoriteService {
    @Autowired
    private FavoriteRepo favoriteRepo;

    public List<Favorite> findById(long user_id) {
        if(favoriteRepo.findByUserid(user_id) != null){
            List<Favorite> favoriteList = favoriteRepo.findByUserid(user_id);
            return favoriteList;
        }
        return null;
    }
}
