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

	/**
	 * costruttore che prende, come data, un  oggetto Data
	 * @param o
	 * @param d oggetto Data
	 * @param z
	 * @param p
	 */
	public Biglietto(	String o, Data d, int z, double p) {
       id=idcount++; ora=o; data=d; zona=z; prezzo=p;
	}
	
	/**
	 * costruttore che prende, come data, una stringa
	 * @param o
	 * @param d stringa che indica la data, formato g/m/a
	 * @param z
	 * @param p
	 */
	public Biglietto(	String o, String d, int z, double p) {
	    id=idcount++; ora=o; data=new Data(d); zona=z; prezzo=p;
	}
	
	/**
	 * aggiunge il biglietto al file 'biglietti.json'
	 */
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

