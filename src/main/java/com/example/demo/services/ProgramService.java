package com.example.demo.services;

import com.example.demo.entities.Program;
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
public class ProgramService {

    private String programApi = "http://api.sr.se/api/v2/programs/";

    public List<Program> getById(long id){
        RestTemplate template = new RestTemplate();

        Map response = template.getForObject(programApi + "search/" + id, Map.class);

        Map[] programMaps = (Map[]) response.get("results");

        List<Program> programs = new ArrayList<>();

/////////////////////
        for(Map program : programMaps){
            Program program = new Program(

            );
        }

        System.out.println(programs);

        return programs;
    }


}
