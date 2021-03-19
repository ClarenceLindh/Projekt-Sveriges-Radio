package com.example.demo.services;


import com.example.demo.entities.Episode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EpisodeService {
    private String episodeApi = "http://api.sr.se/api/v2/episodes/index";
//http://api.sr.se/api/v2/episodes/index?programid=3718&fromdate=2012-08-27&todate=2012-08-31
    public List<Episode> getbyProgramid(long id){

        RestTemplate restTemplate= new RestTemplate();

        Map response = restTemplate.getForObject(episodeApi + "?programid=" + id + "&format=Json" , Map.class);

        List<Map> episodeMaps = (List<Map>) response.get("episodes");

        List<Episode> episodes = new ArrayList<>();
        for (Map episode : episodeMaps){


            Episode EP = new Episode(
                    (Integer)episode.get("id"),
                    (String)episode.get("title"),
                    (String)episode.get("description")

            );

            episodes.add(EP);

        }
        System.out.println(episodes);
        return episodes;
    }

}
