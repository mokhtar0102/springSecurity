package com.example.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Repository.EtudiantRepository;
import com.example.demo.entity.Etudiant;

import antlr.collections.List;

@SpringBootApplication
public class SecuApplication {

	public static void main(String[] args) throws ParseException {
	org.springframework.context.ApplicationContext ctx =	SpringApplication.run(SecuApplication.class, args);
	
 
	}

}
