package com.example.demo.services;


import com.example.demo.entities.Channel;
import com.example.demo.repositories.ChannelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Service
public class ChannelService {
@Autowired // Allows Spring to import the class
private ChannelRepo ChannelRepo;

public List<Channel> getAllChannels(){
    return ChannelRepo.findAll();        // SELECT * FROM Channels

    }

}
