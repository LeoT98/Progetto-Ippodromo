package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
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
					    Quota quota = new Quota(j.getInt("idCorsa"),j.getInt("idCavallo"),j.getDouble("Valore"));
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
					    Scommessa s = new Scommessa(j.getInt("idCorsa"),j.getInt("idCavallo"),j.getDouble("importo"),j.getInt("idScommessa"));
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
		
		
		/**
		 * calcola le quote relative ai cavalli di una corsa: 
		 * i cavalli su cui più persone hanno scommesso avranno quota minore
		 * 
		 * @param idCorsa
		 */
		@GetMapping("/calcolaQuote")
		public void calcolaQuote(@RequestParam(value = "idCorsa", defaultValue = "-1") String idCorsa) {
			String stringa;
			//contiene la lista della scommesse con IDCorsa richiesto
			List<Scommessa> listaScommesse = new ArrayList<Scommessa>();

			try(FileReader f = new FileReader("Scommesse.json")  ){
				BufferedReader br = new BufferedReader(f);
				 while ((stringa = br.readLine()) != null) {
					    JSONObject x = new JSONObject(stringa);
					    Scommessa i = new Scommessa((int)x.get("IDCorsa"),(int)x.get("Cavallo"), (double)x.get("importo"));
					    if(i.checkIDScommessa(Integer.parseInt(idCorsa))) {
					    	listaScommesse.add(i);
					    }
					 }
				 f.close();}catch(Exception e) {}
				
			List<Quota> listaQuote = new ArrayList<Quota>();
				
			List<Integer> listaId = new ArrayList<Integer>();
			listaId.add(-1);
				
			for(int i = 0; i<listaScommesse.size(); i++) {
			//non ho ancora considerato il cavallo x
			if(Collections.frequency(listaId, listaScommesse.get(i).getCavallo()) == 0) {
				//conto il numero di scommesse sul cavallo x
				int ripetizione = Collections.frequency(listaScommesse, listaScommesse.get(i).getCavallo());
				//utilizzo improprio di quota per memorizzare il numero di scommesse del cavallo x
			    listaQuote.add(new Quota(Integer.parseInt(idCorsa), listaScommesse.get(i).getCavallo(), ripetizione));
				listaId.add(listaScommesse.get(i).getCavallo());
				}
			}
				
			//bisogna svuotare questa lista non so se si fa così
			listaId.removeAll(listaId);
				
			//ordino la lista delle quote dalla più piccola (cavallo con meno scommesse) alla più grande
			for(int i = 0; i<listaQuote.size(); i++) {
				for(int j = i+1; j<listaQuote.size()-1; j++) {
					if(listaQuote.get(i).getValore() > listaQuote.get(j).getValore()) {
						Quota temp = listaQuote.get(i);
						listaQuote.add(i, listaQuote.get(j));
						listaQuote.add(j, temp);
					}
				}
			}
				
			double c = 1.5;
			//aggiungo le quote (multipli di 1.5)
			for(int i = 0; i<listaQuote.size(); i++) {
				Quota q = new Quota(Integer.parseInt(idCorsa),listaQuote.get(i).getIDCavallo(),c);
				q.aggiungiQuota();
				c *= 1.5; 
			}
		}

}
