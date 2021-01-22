package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DatiBiglietto {

	/**
	 * aggiunge un biglietto al file 'biglietti.json'
	 * 
	 * @param ora
	 * @param data
	 * @param zona
	 * @param prezzo
	 */
	@GetMapping("/aggiungiBiglietto")
	public void aggiungiBiglietto(@RequestParam(value = "ora", defaultValue = "m") String ora,
											  @RequestParam(value = "data", defaultValue = "1/1/1970") String data,
											  @RequestParam(value = "zona", defaultValue = "0") String zona,
											  @RequestParam(value = "prezzo", defaultValue ="0.0") String prezzo) {
		Biglietto b= new Biglietto(ora,data,Integer.parseInt(zona), Double.parseDouble(prezzo)) ;
		b.aggiungiBiglietto();
	}
	
/**
 *  rimuove il biglietto dal file 'biglietti.json'
 * @param idBiglietto
 */
	@GetMapping("/rimuoviBiglietto")
	public void rimuoviBiglietto(@RequestParam(value = "idBiglietto", defaultValue = "1")String idBiglietto) {
		int id=Integer.parseInt(idBiglietto);
		String st;
		ArrayList<JSONObject> jl=new ArrayList<JSONObject>();
		try(FileReader f = new FileReader("biglietti.json")  ){    // legge il file e salva gli elementi da tenere
			BufferedReader br = new BufferedReader(f);
			 while ((st = br.readLine()) != null) {
				    JSONObject x=new JSONObject(st);
				    if(x.getInt("id")!=id) {
				    		jl.add(x);
				    }
			  }
			 f.close();}catch(Exception e) {}
		try{      	//svuota file
			FileWriter f=new FileWriter("biglietti.json");
			f.close();
			}catch(Exception e){}
		try{   		//riscrive il file
			FileWriter f=new FileWriter("biglietti.json",true);
			for(int c=0;c<jl.size();c++) {
				f.write(jl.get(c).toString());
				f.write("\n");
			}	f.close();	}catch(Exception e){}
	}
	

}
