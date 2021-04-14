package com.example.demo.services;

import com.example.demo.entities.Episode;
import com.example.demo.entities.Program;
import com.example.demo.repositories.ProgramRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
        return progs;
    }

    public List<Program> getByChannelId(long id){
        RestTemplate template = new RestTemplate();
        Map response = template.getForObject(programApi + "/index?channelid=" + id + "&format=json&pagination=false", Map.class);
        List<Map> progMaps = (List<Map>) response.get("programs");
        List<Program> programs = new ArrayList<>();

        for (Map prog: progMaps){
            Integer progId = (Integer) prog.get("id");
            String name = (String) prog.get("name");
            String description = (String) prog.get("description");

            Map progCat = (Map)prog.get("programcategory");

            Program program = new Program();

            if(progCat != null) {
                Long catId = ((Number) progCat.get("id")).longValue();

                program = new Program(progId, name, description, catId);
            }else{
                program = new Program(progId, name, description);
            }

            programs.add(program);
        }
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
            Program program = new Program(id, name, description);
            programs.add(program);
        }
        System.out.println(programs.toString());
        return programs;
    }

    public List<Program> getByCategoryId( long categoryId) {
        RestTemplate template = new RestTemplate();
        Map response =
                template.getForObject(programApi + "/index?&programcategoryid="+ categoryId +
                        "&format=json&pagination=false", Map.class);
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

    public List<Program> getByName(String phrase) {
        RestTemplate template = new RestTemplate();
        // convert response to map
        Map response = template.getForObject(programApi + "?pagination=false&format=json", Map.class);
        // create list of maps of programs from api
        List<Map> progMaps = (List<Map>) response.get("programs");
        // create list of program named programs
        List<Program> programs = new ArrayList<>();
        for(Map prog : progMaps){
            if(prog.get("name").toString().toLowerCase().contains(phrase.toLowerCase())){
                // get id
                Long id = ((Number) prog.get("id")).longValue();
                //get name
                String name = (String) prog.get("name");
                // get description
                String description = (String) prog.get("description");
                // create a Program
                Program program = new Program(id, name, description);
                // populate list with Program
                programs.add(program);
            }
        }

        //debug
        return programs;
    }
}
