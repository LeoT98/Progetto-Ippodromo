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

/**
 * aggiunge una nuova scommessa
 * @param idCorsa
 * @param idCavallo
 * @param importo
 */
		@GetMapping("/aggiungiScommessa")
		public void aggiungiScommessa(@RequestParam(value = "idCorsa", defaultValue = "-1") String idCorsa,
												  @RequestParam(value = "idCavallo", defaultValue = "-1") String idCavallo,
												  @RequestParam(value = "importo", defaultValue = "-1") String importo) {
			Scommessa s = new Scommessa(Integer.parseInt(idCorsa), Integer.parseInt(idCavallo), Double.parseDouble(importo));
			s.aggiungiScommessa();
		}
	/**
	 * mostra le quote attuali di una corsa
	 * @param idCorsa
	 * @return
	 */
		@GetMapping("/mostraQuote")
		public List<Quota> mostraQuote(@RequestParam(value = "idCorsa", defaultValue = "-1") String idCorsa) {
			String stringa;
			List<Quota> listaQuote = new ArrayList<Quota>();
			// legge il file e salva gli elementi da tenere
			try(FileReader f = new FileReader("Quote.json")  ){
				BufferedReader br = new BufferedReader(f);
				 while ((stringa = br.readLine()) != null) {
					    JSONObject j = new JSONObject(stringa);
					    Quota quota = new Quota((int)j.get("idCorsa"),(int)j.get("idCavallo"),j.getDouble("Valore"));
					    if(quota.checkID(Integer.parseInt(idCorsa))) {
					    		listaQuote.add(quota);
					    }
				  }
				 f.close();}catch(Exception e) {}
			return listaQuote;
		}
		
		/** 
		 * mostra le scommesse di una certa corsa
		 * @param idCorsa
		 * @return
		 */
		@GetMapping("/mostraScommesse")
		public List<Scommessa> mostraScommesse(@RequestParam(value = "idCorsa", defaultValue = "1") String idCorsa) {
			String stringa;
			List<Scommessa> listaS = new ArrayList<Scommessa>();
			// legge il file e salva gli elementi da tenere
			try(FileReader f = new FileReader("Scommesse.json")  ){
				BufferedReader br = new BufferedReader(f);
				 while ((stringa = br.readLine()) != null) {
					    JSONObject j = new JSONObject(stringa);
					    Scommessa s = new Scommessa((int)j.get("idCorsa"),(int)j.get("idCavallo"),j.getDouble("importo"),(int)j.get("idScommessa"));
					    if(s.getIDCorsa()==Integer.parseInt(idCorsa)) {
					    		listaS.add(s);
					    }
				  }
				 f.close();}catch(Exception e) {}
			return listaS;
		}
		
		
		@GetMapping("/calcolaQuote")
		public void calcolaQuote(@RequestParam(value = "idCorsa", defaultValue = "-1") String idCorsa) {
			//TO DO
		}

}
