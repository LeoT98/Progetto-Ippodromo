package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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
		public void aggiungiScommessa(@RequestParam(value = "IDCorsa", defaultValue = "-1") String idCorsa,
												  @RequestParam(value = "IDCavallo", defaultValue = "-1") String idCavallo,
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
		public List<Quota> mostraQuote(@RequestParam(value = "IDCorsa", defaultValue = "-1") String idCorsa) {
			String stringa;
			List<Quota> listaQuote = new ArrayList<Quota>();
			// legge il file e salva gli elementi da tenere
			try(FileReader f = new FileReader("Quote.json")  ){
				BufferedReader br = new BufferedReader(f);
				 while ((stringa = br.readLine()) != null) {
					    JSONObject j = new JSONObject(stringa);
					    Quota quota = new Quota((int)j.get("IDCorsa"),(int)j.get("IDCavallo"),(double)j.get("Valore"));
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
		public List<Scommessa> mostraScommesse(@RequestParam(value = "IDCorsa", defaultValue = "1") String idCorsa) {
			String stringa;
			List<Scommessa> listaS = new ArrayList<Scommessa>();
			// legge il file e salva gli elementi da tenere
			try(FileReader f = new FileReader("Scommesse.json")  ){
				BufferedReader br = new BufferedReader(f);
				 while ((stringa = br.readLine()) != null) {
					    JSONObject j = new JSONObject(stringa);
					    Scommessa s = new Scommessa((int)j.get("idCorsa"),(int)j.get("Cavallo"),(double)j.get("importo"));
					    if(s.getIDCorsa()==Integer.parseInt(idCorsa)) {
					    		listaS.add(s);
					    }
				  }
				 f.close();}catch(Exception e) {}
			return listaS;
		}
		
		/**
		 * rimuove una scommessa da 'Scommesse.json'
		 * @param idScommessa
		 */
		@GetMapping("/rimuoviScommessa")
		public void rimuoviScommessa(@RequestParam(value = "idScommessa", defaultValue = "1")String idScommessa) {
			int id=Integer.parseInt(idScommessa);
			String st;
			ArrayList<JSONObject> jl=new ArrayList<JSONObject>();
			// legge il file e salva gli elementi da tenere
			try(FileReader f = new FileReader("Scommesse.json")  ){
				BufferedReader br = new BufferedReader(f);
				 while ((st = br.readLine()) != null) {
					    JSONObject x=new JSONObject(st);
					    if((int)x.get("idScommessa")!=id) {
					    		jl.add(x);
					    }
				  }
				 f.close();}catch(Exception e) {}
			//svuota file
			try{
				FileWriter f=new FileWriter("Scommesse.json");
				f.close();
				}catch(Exception e){}
			//riscrive il file
			try{
				FileWriter f=new FileWriter("Scommesse.json",true);
				for(int c=0;c<jl.size();c++) {
					f.write(jl.get(c).toString());
					f.write("\n");
				}	f.close();	}catch(Exception e){}
		}
		
		
		@GetMapping("/calcolaQuote")
		public void calcolaQuote(@RequestParam(value = "IDCorsa", defaultValue = "-1") String idCorsa) {
			//TO DO
		}

}
