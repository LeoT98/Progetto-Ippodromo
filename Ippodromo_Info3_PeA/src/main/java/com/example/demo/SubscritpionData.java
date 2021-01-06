package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscritpionData {

	@GetMapping("/aggiungiIscrizione")
	public void aggiungiIscrizione(@RequestParam(value = "idFantino", defaultValue = "999999") String idFantino,
			@RequestParam(value = "idCavallo", defaultValue = "999999") String idCavallo,
			@RequestParam(value = "idCorsa", defaultValue = "999999") String idCorsa) {
		System.out.println("prova");
		Iscrizione i=new Iscrizione(Integer.parseInt(idFantino),Integer.parseInt(idCavallo),Integer.parseInt(idCorsa));
		i.aggiungiIscrizione();
	}
	
	/*@GetMapping("/mostraIscrizione")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}*/
}
