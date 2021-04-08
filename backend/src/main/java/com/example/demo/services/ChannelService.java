package com.example.demo.services;


import com.example.demo.entities.Channel;
import com.example.demo.repositories.ChannelRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ChannelService {
@Autowired // Allows Spring to import the class
private ChannelRepo ChannelRepo;
   // Main Method for pulling data from api.
private String Channelsapi = "http://api.sr.se/api/v2/channels?format=json&pagination=false";
public List<Channel> getAllChannels(){
    RestTemplate template = new RestTemplate();

    Map response = template.getForObject(Channelsapi , Map.class);
    System.out.println(response);
    List<Map> channelMaps = (List<Map>) response.get("channels");
    System.out.println(channelMaps);

    List<Channel> channel = new ArrayList<>();

    for (Map chan: channelMaps){
        Long id = ((Number) chan.get("id")).longValue();
        String name = (String) chan.get("name");
        System.out.println(id + " "+ name );
        Channel Channels = new Channel(id, name);
      channel.add(Channels);
    }
return channel;

    }
}
