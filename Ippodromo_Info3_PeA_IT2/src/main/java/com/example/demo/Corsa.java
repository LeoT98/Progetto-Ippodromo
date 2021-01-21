package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import org.json.JSONObject;

public class Corsa {
	private int id, maxPartecipanti;;
	private String ora;
	private Data data;
	static private int idcount=0;

	/**
	 * costruttore che usa un oggeto Data
	 * @param o
	 * @param d oggetto Data
	 * @param z
	 */
	public Corsa(	String o, Data d, int z) {
       id=idcount++; ora=o; data=d; maxPartecipanti=z;
	}
	
	/**
	 * costruttore che usa una stringa peer la data
	 * @param o
	 * @param d stringa che rappresenta la data, g/m/a
	 * @param z
	 */
	public Corsa(	String o, String d, int z) {
	    id=idcount++; ora=o; data=new Data(d); maxPartecipanti=z;
	}	
	
	/**
	 * costruttore che permette di specificare l'id
	 * @param ora
	 * @param data data come stringa
	 * @param maxPartecipanti
	 * @param id
	 */
	public Corsa(String ora, String data, int maxPartecipanti, int id) {
		this.ora=ora;
		this.data=new Data(data);
		this.id=id;
		this.maxPartecipanti=maxPartecipanti;
	}
	
	/**
	 * aggiunge l'oggetto al file 'corse.json'
	 */
	public void aggiungiCorsa() {
		JSONObject corsa=new JSONObject();
		corsa.put("ora", ora);
		corsa.put("data", data);
		corsa.put("maxPartecipanti", maxPartecipanti);
		corsa.put("id", id);
		
		try(FileWriter f=new FileWriter("corse.json",true)){
			f.write(corsa.toString());
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

	public int getMaxPartecipanti() {
		return maxPartecipanti;
	}
	public static int getIdcount() {
		return 0;
	}



	
}
