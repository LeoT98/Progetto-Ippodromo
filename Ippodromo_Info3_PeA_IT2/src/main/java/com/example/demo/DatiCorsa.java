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
public class DatiCorsa {
/**
 * aggiunge una nuova corsa al file 'corse.json'
 * 
 * @param ora
 * @param data
 * @param maxP
 */
	@GetMapping("/aggiungiCorsa")
	public void aggiungiCorsa(@RequestParam(value = "ora", defaultValue = "m") String ora,
										 @RequestParam(value = "data", defaultValue = "1/1/1970") String data,
										 @RequestParam(value = "maxP", defaultValue = "0") String maxP) {
		Corsa b= new Corsa(ora,data,Integer.parseInt(maxP)) ;
		b.aggiungiCorsa();
	}
	
	/**
	 * mostra le corse contenute nel file 'corse.json'
	 * @param dataInput
	 * @return
	 */
	@GetMapping("/mostraCorse")
	public List<Corsa> mostraCorse(@RequestParam(value = "data", defaultValue = "999999") String dataInput) {
		Data dataConf=new Data(dataInput);
		String st;
		List<Corsa> jl=new ArrayList<Corsa>();
		// legge il file e salva gli elementi da tenere
		try(FileReader f = new FileReader("corse.json")  ){
			BufferedReader br = new BufferedReader(f);
			 while ((st = br.readLine()) != null) {
				    JSONObject x=new JSONObject(st);
				    Corsa i=new Corsa((String)x.get("ora"),(String)x.get("data"),(int)x.get("maxPartecipanti"),(int)x.get("id"));
				    if(i.getData().equals(dataConf)) {
				    		jl.add(i);
				    }
			  }
			 f.close();}catch(Exception e) {}
		return jl;
	}
	
	/**
	 * rimuove una corsa dal file 'corse.json'
	 * @param idCorsa
	 */
	@GetMapping("/rimuoviCorsa")
	public void rimuoviCorsa(@RequestParam(value = "idCorsa", defaultValue = "1")String idCorsa) {
		int id=Integer.parseInt(idCorsa);
		String st;
		ArrayList<JSONObject> jl=new ArrayList<JSONObject>();
		// legge il file e salva gli elementi da tenere
		try(FileReader f = new FileReader("corse.json")  ){
			BufferedReader br = new BufferedReader(f);
			 while ((st = br.readLine()) != null) {
				    JSONObject x=new JSONObject(st);
				    if((int)x.get("id")!=id) {
				    		jl.add(x);
				    }
			  }
			 f.close();}catch(Exception e) {}
		//svuota file
		try{
			FileWriter f=new FileWriter("corse.json");
			f.close();
			}catch(Exception e){}
		//riscrive il file
		try{
			FileWriter f=new FileWriter("corse.json",true);
			for(int c=0;c<jl.size();c++) {
				f.write(jl.get(c).toString());
				f.write("\n");
			}	f.close();	}catch(Exception e){}
	}
}
