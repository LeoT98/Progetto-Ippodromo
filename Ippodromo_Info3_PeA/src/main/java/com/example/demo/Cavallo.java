package com.example.demo;
import java.io.FileWriter;

import org.json.JSONObject;

public class Cavallo {
	private int id;
	private String nome;
	private String scuderia; 
	private String razza;
	
	private static int idcount = 0;
	
	public Cavallo(String nome, String scuderia, String razza) {
		this.id = idcount++;
		this.nome = nome;
		this.scuderia = scuderia;
		this.razza = razza;
	}
	
	void aggiungiCavallo(String nome, String scuderia, String razza) {
		JSONObject cavallo = new JSONObject();
		cavallo.put("ID", id);
		cavallo.put("Nome", nome);
		cavallo.put("Scuderia", scuderia);
		cavallo.put("Razza", razza);
		
		try(FileWriter f = new FileWriter("Elenco_Cavalli.json")){
			f.write(cavallo.toString());
			f.write("\n");
		}catch(IOException e) {
			
		}
	}
	
}