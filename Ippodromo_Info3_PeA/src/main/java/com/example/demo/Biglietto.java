package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import org.json.JSONObject;

public class Biglietto {
	private int id, zona;
	private String ora;
	private Data data;
	private double prezzo;
	private static int idcount=0;

	
	public Biglietto(	String o, Data d, int z, double p) {
       id=idcount++; ora=o; data=d; zona=z; prezzo=p;
	}
	public Biglietto(	String o, String d, int z, double p) {
	    id=idcount++; ora=o; data=new Data(d); zona=z; prezzo=p;
	}
	
	public void aggiungiBiglietto() {
		//Crea oggetto json
		JSONObject biglietto=new JSONObject();
		biglietto.put("ora", ora);
		biglietto.put("data", data.toString());
		biglietto.put("zona", zona);
		biglietto.put("prezzo", prezzo);
		biglietto.put("id", id); 
		//scrive su file
		try(FileWriter f=new FileWriter("biglietti.json",true)){
			f.write(biglietto.toString());
			f.write("\n");
		}catch(Exception e){}
	}
	
	public void rimuoviBiglietto() {
		String st;
		ArrayList<JSONObject> jl=new ArrayList<JSONObject>();
		// legge il file e salva gli elementi da tenere
		try(FileReader f = new FileReader("biglietti.json")  ){
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
			FileWriter f=new FileWriter("biglietti.json");
			f.close();
			}catch(Exception e){}
		//riscrive il file
		try{
			FileWriter f=new FileWriter("biglietti.json",true);
			for(int c=0;c<jl.size();c++) {
				f.write(jl.get(c).toString());
				f.write("\n");
			}	f.close();	}catch(Exception e){}
	}
	
	public String toString() {
		JSONObject biglietto=new JSONObject();
		biglietto.put("ora", ora);
		biglietto.put("data", data.toString());
		biglietto.put("zona", zona);
		biglietto.put("prezzo", prezzo);
		biglietto.put("id", id);
		return biglietto.toString();
	}
	
	public int getId() {
		return id;
	}
	public String getOra() {
		return ora;
	}
	public Data getData() {
		return data;
	}
	public int getZona() {
		return zona;
	}
	public double getPrezzo() {
		return prezzo;
	}
	
	
	
}
