package com.example.demo.services;

import com.example.demo.entities.Episode;
import com.example.demo.entities.Program;
import com.example.demo.repositories.ProgramRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
                (String) program.get("description"),
                (Long) program.get("categoryId")
        );
        // debug
        System.out.println(progs);
        return progs;
    }

    public List<Program> getByChannelId(long id){
        RestTemplate template = new RestTemplate();
        Map response = template.getForObject(programApi + "/index?channelid=" + id + "&format=json", Map.class);
        List<Map>  progMaps = (List<Map>) response.get("programs");
        List<Program> programs = new ArrayList<>();
        for (Map prog: progMaps){
            Long progId = ((Number) prog.get("id")).longValue();
            String name = (String) prog.get("name");
            String description = (String) prog.get("description");
            Program program = new Program(progId, name, description, id);
            programs.add(program);
        }
        System.out.println(programs.toString());
        return programs;
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
            Long categoryId = (Long) prog.get("categoryId");

            Program program = new Program(id, name, description, categoryId);

            programs.add(program);
        }
        System.out.println(programs.toString());
        return programs;
    }

    public List<Program> getByCategoryId( long categoryId) {
        RestTemplate template = new RestTemplate();
        // programapi + index?&programcategoryid=14&format=json
        Map response = template.getForObject(programApi + "/index?&programcategoryid="+ categoryId + "&format=json", Map.class);
        List<Map> programMaps = (List<Map>) response.get("programs");

        List<Program> programs = new ArrayList<>();


        for(Map progs : programMaps){
           Long id = ((Number) progs.get("id")).longValue();
            String name = (String) progs.get("name");
            String description = (String) progs.get("description");
            Program program = new Program(id, name, description, categoryId);

            programs.add(program);
        }

        System.out.println(programs);
        return programs;
    }
}
