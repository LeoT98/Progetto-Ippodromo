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
public class DatiIscrizione {
/**
 * aggiunge una nuova iscrizione al file 'iscrizioni.json'
 * @param idFantino
 * @param idCavallo
 * @param idCorsa
 */
	@GetMapping("/aggiungiIscrizione")
	public void aggiungiIscrizione(@RequestParam(value = "idFantino", defaultValue = "999999") String idFantino,
			@RequestParam(value = "idCavallo", defaultValue = "999999") String idCavallo,
			@RequestParam(value = "idCorsa", defaultValue = "999999") String idCorsa) {
		Iscrizione i=new Iscrizione(Integer.parseInt(idFantino),Integer.parseInt(idCavallo),Integer.parseInt(idCorsa));
		i.aggiungiIscrizione();
	}
	
	/**
	 * mostra le iscrizioni salvate in 'iscrizioni.json'
	 * @param idCorsa
	 * @return
	 */
	@GetMapping("/mostraIscrizioni")
	public List<Iscrizione> mostraIscrizioni(@RequestParam(value = "IDCorsa", defaultValue = "999999") String idCorsa) {
		String st;
		List<Iscrizione> jl=new ArrayList<Iscrizione>();
		// legge il file e salva gli elementi da tenere
		try(FileReader f = new FileReader("iscrizioni.json")  ){
			BufferedReader br = new BufferedReader(f);
			 while ((st = br.readLine()) != null) {
				    JSONObject x=new JSONObject(st);
				    Iscrizione i=new Iscrizione((int)x.get("idFantino"),(int)x.get("idCavallo"),(int)x.get("idCorsa"));
				    if(i.checkID(Integer.parseInt(idCorsa))) {
				    		jl.add(i);
				    }
			  }
			 f.close();}catch(Exception e) {}
		return jl;
	}
}
