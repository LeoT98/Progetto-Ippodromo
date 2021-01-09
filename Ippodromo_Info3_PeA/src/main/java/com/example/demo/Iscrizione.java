package com.example.demo;

import java.io.FileWriter;

import org.json.JSONObject;

public class Iscrizione {
	private int idFantino;
	private int idCavallo;
	private int idCorsa;
	
	public Iscrizione(int idFantino,int idCavallo,int idCorsa) {
		this.idFantino=idFantino;
		this.idCorsa=idCorsa;
		this.idCavallo=idCavallo;
	}
	
	public Iscrizione() {
		this.idFantino=999999;
		this.idCorsa=999999;
		this.idCavallo=999999;
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

	public int getIdFantino() {
		return idFantino;
	}

	public void setIdFantino(int idFantino) {
		this.idFantino = idFantino;
	}

	public int getIdCavallo() {
		return idCavallo;
	}

	public void setIdCavallo(int idCavallo) {
		this.idCavallo = idCavallo;
	}

	public int getIdCorsa() {
		return idCorsa;
	}

	public void setIdCorsa(int idCorsa) {
		this.idCorsa = idCorsa;
	}

	public boolean checkID(int IDConf) {
		if(this.idCorsa==IDConf) {
			return true;
		}
		return false;
	}
}
