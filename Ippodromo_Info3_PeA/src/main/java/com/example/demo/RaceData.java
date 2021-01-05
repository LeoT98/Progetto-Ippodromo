package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RaceData {

	@GetMapping("/addCorsa")
	public void addCorsa(@RequestParam(value = "ora", defaultValue = "m") String ora,
										 @RequestParam(value = "data", defaultValue = "1/1/1970") String data,
										 @RequestParam(value = "maxP", defaultValue = "0") String maxP) {
		Corsa b= new Corsa(ora,data,Integer.parseInt(maxP)) ;
		b.aggiungiCorsa();
	}
	
	
}
