package com.example.demo.services;

import com.example.demo.ConvertToJson;
import com.example.demo.entities.Program;
import com.example.demo.entities.User;
import com.example.demo.repositories.ProgramRepo;
import com.example.demo.repositories.UserRepo;
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
public class ProgramService {

    @Autowired
    private ProgramRepo programRepo;

    private String programApi = "http://api.sr.se/api/v2/programs/";

    public Program getById(long id){
        RestTemplate template = new RestTemplate();
        // convert response to a Map
        Map response = template.getForObject(programApi + id + "/?format=json", Map.class);
        // for easy extraction of the results data
        Map program = (Map) response.get("program");
        // if no match, return null
        if(program == null) return null;
        // create a program with extracted data
        Program progs = new Program(
                (Integer) program.get("id"),
                (String)program.get("name"),
                (String) program.get("description")
        );
        // debug
        System.out.println(progs);
        return progs;
    }

    public List<Program> getAll() {
        RestTemplate template = new RestTemplate();
        Map response = template.getForObject(programApi + "?format=json", Map.class);

        List<Map>  progMaps = (List<Map>) response.get("programs");

        List<Program> programs = new ArrayList<>();

        for (Map prog: progMaps){
            Long id = ((Number) prog.get("id")).longValue();
            String name = (String) prog.get("name");
            String description = (String) prog.get("description");

            Program program = new Program(id, name, description);

            programs.add(program);
        }

        System.out.println(programs.toString());
        return programs;

    }
}
