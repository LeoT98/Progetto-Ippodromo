package com.example.demo;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

public class Fantino {
	private int id;
	private String nome;
	private String cognome; 
	private String scuderia; 
	
	private static int idcount = 0;
	
	public Fantino(String nome, String cognome, String scuderia) {
		this.id = idcount++;
		this.nome = nome;
		this.cognome = cognome;
		this.scuderia = scuderia;
	}
	
	void aggiungiFantino(String nome, String cognome, String scuderia) {
		JSONObject fantino = new JSONObject();
		fantino.put("ID", id);
		fantino.put("Nome", nome);
		fantino.put("Cognome", cognome);
		fantino.put("Scuderia", scuderia);
		
		try(FileWriter f = new FileWriter("Elenco_Fantini.json")){
			f.write(fantino.toString());
			f.write("\n");
		}catch(IOException e) {
			
		}
	}
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getScuderia() {
		return scuderia;
	}


}