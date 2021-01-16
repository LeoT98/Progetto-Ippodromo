package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DatiBiglietto {

	@GetMapping("/aggiungiBiglietto")
	public String aggiungiBiglietto(@RequestParam(value = "ora", defaultValue = "m") String ora,
											  @RequestParam(value = "data", defaultValue = "1/1/1970") String data,
											  @RequestParam(value = "zona", defaultValue = "0") String zona,
											  @RequestParam(value = "prezzo", defaultValue ="0.0") String prezzo) {
		Biglietto b= new Biglietto(ora,data,Integer.parseInt(zona), Double.parseDouble(prezzo)) ;
		b.aggiungiBiglietto();
		return "it's working";
	}
	

}
