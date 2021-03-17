package com.example.demo.services;

import com.example.demo.ConvertToJson;
import com.example.demo.entities.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.rmi.MarshalledObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {
    private String categoryApi = "http://api.sr.se/api/v2/programcategories";

    public List<Category> getAll(){
        RestTemplate template = new RestTemplate();
        Map response = template.getForObject(categoryApi + "?format=json", Map.class);

        List<Map> catMaps = (List<Map>) response.get("programcategories");

        List<Category> categories = new ArrayList<>();

        for(Map cat : catMaps){
            Long id = ((Number) cat.get("id")).longValue();
            String name = (String) cat.get("name");

            Category category = new Category(id, name);

            categories.add(category);
        }

        return categories;
    }
}