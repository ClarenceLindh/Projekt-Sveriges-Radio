package com.example.demo.controllers;


import com.example.demo.entities.Channel;
import com.example.demo.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChannelsController {
@Autowired
private ChannelService ChannelService;

@GetMapping("/test")
    public String  test(){
    return "Hello from ChannelsController!";
}


@GetMapping("/rest/channels")
    public List<Channel> getAllChannels(){

    return ChannelService.getAllChannels();
}


/*@GetMapping("/getChannelsFromId/{id}")
public List<Channel> getChannelsFromId(@PathVariable long id){
return ChannelService.getChannelsFromId(id);
}*/

}
