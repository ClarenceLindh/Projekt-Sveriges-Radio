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


    public List<Program> getById(long id){
        RestTemplate template = new RestTemplate();

        // convert response to a Map
        Map response = template.getForObject(programApi + id + "?format=json", Map.class);

        // for easy extraction of the results data
        List<Map> progMaps = (List<Map>) response.get("programs");

        // if no match, return null
        if(progMaps == null) return null;

        List<Program> programs = new ArrayList<>();

        // loop all heroes and extract the data we want
        for(Map prog : progMaps) {

            // create a hero with extracted data
            Program program = new Program(
                    Long.parseLong((String) prog.get("id")),
                    (String)prog.get("name"),
                    (String) prog.get("description")
            );

            // populate list with freshly created heroes
            programs.add(program);

        }

        // debug
        System.out.println(programs);
        return programs;


        /*
        RestTemplate template = new RestTemplate();
        Map response = template.getForObject(programApi  + id + "?format=json", Map.class);

        String reply = (String)response.get("programs").toString();

        String[] shortAnswer = reply.split("=");
        List<String> finalAnswer = new ArrayList<>();

        for(String answer : shortAnswer){
            answer = answer.replace("{", "");
            answer = answer.replace("}", "");
            answer = answer.replace(", name", "");
            finalAnswer.add(answer);
        }


        Long newID = Long.parseLong(finalAnswer.get(1));
        String newName = finalAnswer.get(2);
        String newDescription = finalAnswer.get(3);

        List<Program> programs = new ArrayList<>();
        Program program = new Program(id, newName, newDescription);
        programs.add(program);

        System.out.println(programs.toString());

        return programs;
        */
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
