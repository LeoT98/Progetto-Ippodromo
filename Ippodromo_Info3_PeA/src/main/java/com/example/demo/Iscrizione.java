package com.example.demo;

import java.io.FileWriter;

import org.json.JSONObject;

public class Iscrizione {
	private int idFantino;
	private int idCavallo;
	private int idCorsa;
	
	/**
	 * 
	 * @param idFantino
	 * @param idCavallo
	 * @param idCorsa
	 */
	public Iscrizione(int idFantino,int idCavallo,int idCorsa) {
		this.idFantino=idFantino;
		this.idCorsa=idCorsa;
		this.idCavallo=idCavallo;
	}
	
/**
 * aggiunge l'iscrizione al file 'iscrizioni.json'
 */
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

	public int getIdFantino() {
		return idFantino;
	}


	public int getIdCavallo() {
		return idCavallo;
	}


	public int getIdCorsa() {
		return idCorsa;
	}

/**
 * controlla se l'id di questa iscrizione corrisponde ad un certo id 
 * @param IDConf
 * @return
 */
	public boolean checkID(int IDConf) {
		if(this.idCorsa==IDConf) {
			return true;
		}
		return false;
	}
}
