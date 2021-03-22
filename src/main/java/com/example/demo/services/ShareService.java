package com.example.demo.services;


import com.example.demo.entities.Share;
import com.example.demo.repositories.ShareRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareService {
    @Autowired
    private ShareRepo shareRepo;

    public List<Share> findById(long user_id) {
        if(shareRepo.findByUserid(user_id) != null){
            List<Share> shareList = shareRepo.findByUserid(user_id);
            return shareList;
        }
        return null;
    }

    public Share addShare(Share share){
        try {
            return shareRepo.save(share);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void deleteById(long id) { shareRepo.deleteById(id); }
}
