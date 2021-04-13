package com.example.demo.controllers;

import com.example.demo.entities.Friend;
import com.example.demo.services.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class FriendsController {

    @Autowired
    private FriendService friendService;

//______________________________Get all Friends by user_id_______________________________
    @GetMapping("/friends/{id}")
    public List<Friend> getAll(@PathVariable long id){ return friendService.getFriend(id); }

//__________________________Add a new Friends from a JSON object__________________________
    @PostMapping("/friends")
    public Friend register(@RequestBody Friend friend){ return friendService.addFavorite(friend); }

//_________________________________Delete a Friends by ID_________________________________
    @DeleteMapping("/friends/{id}")
    public void deleteById(@PathVariable long id) {
        friendService.deleteById(id);
    }
}
