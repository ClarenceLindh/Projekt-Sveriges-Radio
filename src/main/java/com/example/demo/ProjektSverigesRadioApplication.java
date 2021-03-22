package com.example.demo;

import com.example.demo.entities.Program;
import com.example.demo.services.ProgramService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProjektSverigesRadioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjektSverigesRadioApplication.class, args);

		System.out.println("NU TAR VI FREEEEDAG!");

		ProgramService progServ = new ProgramService();


		progServ.getById(35);

		progServ.getAll();





	}

}
