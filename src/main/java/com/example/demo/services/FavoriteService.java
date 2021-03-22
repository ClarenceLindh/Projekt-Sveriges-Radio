package com.example.demo.services;


import com.example.demo.entities.Favorite;
import com.example.demo.repositories.FavoriteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Favorite addFavorite(Favorite favorite){
        try {
            return favoriteRepo.save(favorite);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void deleteById(long id) { favoriteRepo.deleteById(id); }
}
