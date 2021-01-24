package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringMain {

	public static void main(String[] args) {
		System.out.print("inizio");
		SpringApplication.run(SpringMain.class, args);
		System.out.print("fine");
	}
	
}
