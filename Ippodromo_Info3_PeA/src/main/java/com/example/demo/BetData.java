package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public class BetData {

	
	@RestController
	public class TicketData {

		@GetMapping("/nuovaScommessa")
		public void addScommessa(@RequestParam(value = "IDCorsa", defaultValue = "m") String IDCorsa,
												  @RequestParam(value = "IDCavallo", defaultValue = "1/1/1970") String IDCavallo,
												  @RequestParam(value = "importo", defaultValue = "0") String importo,) {
			//TO DO
		}
		
		@GetMapping("/mostraQuote")
		public List<Quota> showQuote(@RequestParam(value = "IDCorsa", defaultValue = "m") String IDCorsa) {
			//TO DO
		}
		
		@GetMapping("/calcolaQuote")
		public void calcolaQuote(@RequestParam(value = "IDCorsa", defaultValue = "m") String IDCorsa) {
			//TO DO
		}

}
