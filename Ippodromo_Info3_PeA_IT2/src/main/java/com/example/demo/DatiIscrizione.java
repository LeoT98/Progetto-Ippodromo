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
	public List<Iscrizione> mostraIscrizioni(@RequestParam(value = "idCorsa", defaultValue = "999999") String idCorsa) {
		String st;
		List<Iscrizione> jl=new ArrayList<Iscrizione>();
		// legge il file e salva gli elementi da tenere
		try(FileReader f = new FileReader("iscrizioni.json")  ){
			BufferedReader br = new BufferedReader(f);
			 while ((st = br.readLine()) != null) {
				    JSONObject x=new JSONObject(st);
				    Iscrizione i=new Iscrizione(x.getInt("idFantino"),x.getInt("idCavallo"),x.getInt("idCorsa"));
				    if(i.checkID(Integer.parseInt(idCorsa))) {
				    		jl.add(i);
				    }
			  }
			 f.close();}catch(Exception e) {}
		return jl;
	}
	
	/**
	 * rimuove un'iscrizione da 'iscrizioni.json'
	 * @param idCorsa
	 * @param idCavallo
	 */
	@GetMapping("/rimuoviIscrizione")
	public void rimuoviIscrizione(@RequestParam(value = "idCorsa", defaultValue = "1")String idCorsa, 
													@RequestParam(value = "idCavallo", defaultValue = "1")String idCavallo) {
		int idCo=Integer.parseInt(idCorsa);
		int idCa=Integer.parseInt(idCavallo);
		String st;
		ArrayList<JSONObject> jl=new ArrayList<JSONObject>();
		// legge il file e salva gli elementi da tenere
		try(FileReader f = new FileReader("iscrizioni.json")  ){
			BufferedReader br = new BufferedReader(f);
			 while ((st = br.readLine()) != null) {
				    JSONObject x=new JSONObject(st);
				    if(x.getInt("idCorsa")!=idCo || x.getInt("idCavallo")!=idCa) {
				    		jl.add(x);
				    }
			  }
			 f.close();}catch(Exception e) {}
		//svuota file
		try{
			FileWriter f=new FileWriter("iscrizioni.json");
			f.close();
			}catch(Exception e){}
		//riscrive il file
		try{
			FileWriter f=new FileWriter("iscrizioni.json",true);
			for(int c=0;c<jl.size();c++) {
				f.write(jl.get(c).toString());
				f.write("\n");
			}	f.close();	}catch(Exception e){}
	}
}
