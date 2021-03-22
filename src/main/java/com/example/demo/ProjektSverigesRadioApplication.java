package com.example.demo;

import com.example.demo.entities.Episode;
import com.example.demo.services.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProjektSverigesRadioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjektSverigesRadioApplication.class, args);


		System.out.println("Fredag!");

	}

}