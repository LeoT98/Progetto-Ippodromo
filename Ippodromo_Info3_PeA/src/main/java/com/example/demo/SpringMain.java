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
		System.out.print("peto 1");
		SpringApplication.run(SpringMain.class, args);
		System.out.print("peto 2");
	}

	
	
	@GetMapping("/addBiglietto")
	public void addBiglietto(@RequestParam(value = "ora", defaultValue = "m") String ora,
											  @RequestParam(value = "data", defaultValue = "1/1/1970") String data,
											  @RequestParam(value = "zona", defaultValue = "0") String zona,
											  @RequestParam(value = "prezzo", defaultValue ="0.0") String prezzo) {
		Biglietto b= new Biglietto(ora,data,Integer.parseInt(zona), Double.parseDouble(prezzo)) ;
		b.aggiungiBiglietto();
	}
	
	@GetMapping("/addCorsa")
	public void addCorsa(@RequestParam(value = "ora", defaultValue = "m") String ora,
										 @RequestParam(value = "data", defaultValue = "1/1/1970") String data,
										 @RequestParam(value = "maxP", defaultValue = "0") String maxP) {
		Corsa b= new Corsa(ora,data,Integer.parseInt(maxP)) ;
		b.aggiungiCorsa();
	}
	
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
	return String.format("Hello %s!", name);
	}
	

			
	
}
