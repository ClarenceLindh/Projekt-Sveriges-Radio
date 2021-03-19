package com.example.demo.controllers;


import com.example.demo.entities.Episode;
import com.example.demo.services.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/rest")
public class EpisodesController {
    @Autowired
    private EpisodeService episodeService;

    @GetMapping("/rest/episodes/{id}")
    public List<Episode> getById(@PathVariable long id){
return episodeService.getbyProgramid(id);
    }
}
