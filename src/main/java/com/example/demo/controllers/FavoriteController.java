package com.example.demo.controllers;

import com.example.demo.entities.Favorite;
import com.example.demo.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/favorites/{id}")
    public List<Favorite> getAllFavorites(@PathVariable long id){ return favoriteService.findById(id); }

    @PostMapping("/favorites")
    public Favorite register(@RequestBody Favorite favorite){
        return favoriteService.addFavorite(favorite);
    }

    @DeleteMapping("/favorites/{id}")
    public void deleteById(@PathVariable long id) {
        favoriteService.deleteById(id);
    }
}
