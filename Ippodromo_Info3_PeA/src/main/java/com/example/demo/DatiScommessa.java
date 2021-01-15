package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatiScommessa {


		@GetMapping("/aggiungiScommessa")
		public void aggiungiScommessa(@RequestParam(value = "IDCorsa", defaultValue = "-1") String IDCorsa,
												  @RequestParam(value = "IDCavallo", defaultValue = "-1") String IDCavallo,
												  @RequestParam(value = "importo", defaultValue = "-1") String importo) {
			Scommessa s = new Scommessa(Integer.parseInt(IDCorsa), Integer.parseInt(IDCavallo), Double.parseDouble(importo));
			s.aggiungiScommessa();
		}
		
		@GetMapping("/mostraQuote")
		public List<Quota> mostraQuote(@RequestParam(value = "IDCorsa", defaultValue = "-1") String IDCorsa) {
			String stringa;
			List<Quota> listaQuote = new ArrayList<Quota>();
			// legge il file e salva gli elementi da tenere
			try(FileReader f = new FileReader("Quote.json")  ){
				BufferedReader br = new BufferedReader(f);
				 while ((stringa = br.readLine()) != null) {
					    JSONObject j = new JSONObject(stringa);
					    Quota quota = new Quota((int)j.get("IDCorsa"),(int)j.get("IDCavallo"),(double)j.get("Valore"));
					    if(quota.checkID(Integer.parseInt(IDCorsa))) {
					    		listaQuote.add(quota);
					    }
				  }
				 f.close();}catch(Exception e) {}
			return listaQuote;
		}
		
		@GetMapping("/calcolaQuote")
		public void calcolaQuote(@RequestParam(value = "IDCorsa", defaultValue = "-1") String IDCorsa) {
			//TO DO
		}

}
