package com.example.demo.controllers;


import com.example.demo.entities.Program;
import com.example.demo.entities.User;
import com.example.demo.services.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ProgramsController {

    @Autowired
    private ProgramService programService;

    @GetMapping("/rest/programs")
    public List<Program> getAll() {
        return programService.getAll();
    }

    @GetMapping("/rest/programs/{id}")
    public Program getById(@PathVariable long id){
        return programService.getById(id);
    }

    @GetMapping("/rest/programs/channel/{id}")
        public List<Program> getByChannelId(@PathVariable long id){
            return programService.getByChannelId(id);
        }
}




    @GetMapping("/rest/programsByCategoryId/{categoryId}")
    public List<Program> getByCategoryId(@PathVariable Long categoryId){
        return  programService.getByCategoryId(categoryId);    }
}
