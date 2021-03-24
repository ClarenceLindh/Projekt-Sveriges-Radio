package com.example.demo.repositories;


import com.example.demo.entities.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
// Få de inbyggda metoderna från Jpa som sedan kan kallas på i service
@Repository
public interface EpisodeRepo extends JpaRepository<Episode, Long> {

    // Skapar en query för att få ut all info från en episode baserat på titel som man skickar in.(EJ AKTUELL LÄNGRE)
@Query(value = "SELECT * FROM episodes where title LIKE %?1%", nativeQuery = true)
List<Episode>getWithTitle (String title);


}
