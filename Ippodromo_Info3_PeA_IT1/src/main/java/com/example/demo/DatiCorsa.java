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
				    Corsa i=new Corsa(x.getString("ora"),x.getString("data"),x.getInt("maxPartecipanti"),x.getInt("id"));
				    if(i.getData().equals(dataConf)) {
				    		jl.add(i);
				    }
			  }
			 f.close();}catch(Exception e) {}
		return jl;
	}
	


}
