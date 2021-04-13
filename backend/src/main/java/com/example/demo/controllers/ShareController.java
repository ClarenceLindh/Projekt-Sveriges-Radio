package com.example.demo.controllers;

import com.example.demo.entities.Share;
import com.example.demo.services.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ShareController {

    @Autowired
    private ShareService shareService;

//______________________________Get all Shares by user_id_______________________________
    @GetMapping("/shares/{id}")
    public List<Share> getAllShares(@PathVariable long id){ return shareService.findAllForUsersFriends(id); }

//__________________________Add a new Shares from a JSON object__________________________
    @PostMapping("/shares")
    public Share register(@RequestBody Share share){
        return shareService.addShare(share);
    }

//_________________________________Delete a Shares by ID_________________________________
    @DeleteMapping("/shares/{id}")
    public void deleteById(@PathVariable long id) {
        shareService.deleteById(id);
    }
}
