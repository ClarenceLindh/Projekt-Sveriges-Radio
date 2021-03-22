package com.example.demo.services;


import com.example.demo.entities.Friend;
import com.example.demo.repositories.FriendRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {
    @Autowired
    private FriendRepo friendRepo;

    public List<Friend> findById(long user_id) {
        if(friendRepo.findByUserid(user_id) != null){
            List<Friend> friendList = friendRepo.findByUserid(user_id);
            return friendList;
        }
        return null;
    }

    public Friend addFavorite(Friend friend) {
        try{
            return friendRepo.save(friend);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public void deleteById(long id) {
        friendRepo.deleteById(id);
    }
}
