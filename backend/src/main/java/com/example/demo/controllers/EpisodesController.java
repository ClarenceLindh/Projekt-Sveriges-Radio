package com.example.demo.controllers;


import com.example.demo.entities.Episode;
import com.example.demo.services.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/rest")
public class EpisodesController {
    @Autowired
    private EpisodeService episodeService;


    //---------------------------Hämta alla episodes från ett program från api'n----------------------------------------
    // Skickar med ett id för att sedan få ut alla episodes från ett program!

    @GetMapping("/rest/episodes/{id}")
    public List<Episode> getById(@PathVariable long id) {
        return episodeService.getbyProgramid(id);
    }


    @GetMapping("/rest/episodes/{id}/{date}")
    public List<Episode> getbyPid(@PathVariable long id, @PathVariable String date) {
        return episodeService.getByChannelId(id, date);
    }



    //----------------------------------Hitta en episode beroende på dag---------------------------------------------------
// Skickar med ett programid och ett datum för att sedan få ut alla sändningar som sänds från det programmet den dagen
    @GetMapping("/rest/episodes/day/{id}/{date}")
    private List<Episode> getEpisodesByDay(@PathVariable long id, @PathVariable String date) {
        return episodeService.getByDate(id, date);
    }


//(EJ AKTUELL LÄNGRE) _Hämta alla episodes från databasen genom att kalla på servicen som är kopplad till repot(EJ AKTUELL LÄNGRE)

    @GetMapping("/rest/episodes/all")
    public List<Episode> getAllEpisodes() {
        return episodeService.getAllEpisodesFromDb();
    }

    //---------------------------------------Hämta alla episodes baserad på en viss titel(EJ AKTUELL LÄNGRE)----------------
    @GetMapping("/rest/episodes/all/{title}")
    public List<Episode> getByTitle(@PathVariable String title) {
        return episodeService.getWithTitle(title);
    }

    //--------------------------------------Post en episode till db(EJ AKTUELL LÄNGRE)--------------------------------------
    @PostMapping("/rest/episodes")
    private Episode createEpisode(@RequestBody Episode episode) {
        System.out.println(episode);
        return episodeService.addEpisode(episode);
    }

}
