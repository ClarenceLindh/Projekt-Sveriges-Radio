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

//______________________________Find Favorite by user_id_______________________________
    public List<Favorite> findById(long user_id) {
        if(favoriteRepo.findByUserid(user_id) != null){
            List<Favorite> favoriteList = favoriteRepo.findByUserid(user_id);
            return favoriteList;
        }
        return null;
    }

//______________________________Add a Favorite from a JSON body________________________
    public Favorite addFavorite(Favorite favorite){
        try {
            return favoriteRepo.save(favorite);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

//______________________________Delete a Favorite from the database____________________
    public void deleteById(long id) { favoriteRepo.deleteById(id); }
}
