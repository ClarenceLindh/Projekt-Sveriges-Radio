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

    @GetMapping("/friends/{id}")
    public List<Friend> getAll(@PathVariable long id){ return friendService.findById(id); }

    @PostMapping("/friends")
    public Friend register(@RequestBody Friend friend){ return friendService.addFavorite(friend); }

    @DeleteMapping("/friends/{id}")
    public void deleteById(@PathVariable long id) {
        friendService.deleteById(id);
    }
}
