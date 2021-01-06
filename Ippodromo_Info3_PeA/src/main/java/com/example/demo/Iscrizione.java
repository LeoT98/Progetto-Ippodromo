package com.example.demo;

import java.io.FileWriter;

import org.json.JSONObject;

public class Iscrizione {
	int idFantino;
	int idCavallo;
	int idCorsa;
	
	public Iscrizione(int idFantino,int idCorsa,int idCavallo) {
		this.idFantino=idFantino;
		this.idCorsa=idCorsa;
		this.idCavallo=idCavallo;
	}
	
	public void aggiungiIscrizione() {
		//Crea oggetto json
		JSONObject iscrizioni=new JSONObject();
		iscrizioni.put("idFantino", idFantino);
		iscrizioni.put("idCorsa", idCorsa);
		iscrizioni.put("idCavallo", idCavallo);
		//scrive su file
		try(FileWriter f=new FileWriter("iscrizioni.json",true)){
			f.write(iscrizioni.toString());
			f.write("\n");
		}catch(Exception e){}

	}
}
