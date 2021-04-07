package com.example.demo.services;


import com.example.demo.entities.Friend;
import com.example.demo.entities.User;
import com.example.demo.repositories.FriendRepo;
import com.example.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FriendService {
    @Autowired
    private FriendRepo friendRepo;

    @Autowired
    private UserRepo userRepo;

//______________________________Find Friend by user_id_______________________________
    public List<Friend> findById(long user_id) {
        if(friendRepo.findByUserid(user_id) != null){
            List<Friend> friendList = friendRepo.findByUserid(user_id);
            return friendList;
        }
        return null;
    }

//______________________________Add a Friend from a JSON body________________________
    public Friend addFavorite(Friend friend) {
        try{
            return friendRepo.save(friend);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

//____________________Check if the user to be deleted is logged in___________________
    public Boolean checkIfUser(Long id){
        UserService userService = new UserService();
        Optional<Friend> friendList = friendRepo.findById(id);

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByUsername(username);

        if(user.getId() == friendList.get().getUser_id())
            return true;
        else
            return false;
    }

//______________________________Delete a Friend from the database____________________
    public void deleteById(long id) {
        if(checkIfUser(id)) {
            System.out.println("Deleting friendship " + id);
            friendRepo.deleteById(id);
        }
        else
            System.err.println("Cannot, simply can´t");
    }
}