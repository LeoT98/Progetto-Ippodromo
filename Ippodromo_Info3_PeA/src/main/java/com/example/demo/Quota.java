package com.example.demo;

import java.io.FileWriter;

import org.json.JSONObject;

public class Quota {

	private int idCorsa;
	private int idCavallo;
	private double valore;
	
	public Quota(int IDCorsa, int IDCavallo, double valore) {
		this.idCorsa = IDCorsa;
		this.idCavallo = IDCavallo;
		this.valore = valore;
	}
	
	public void aggiungiQuota() {
		//Crea oggetto json
		JSONObject quota =new JSONObject();
		quota.put("idCorsa", idCorsa);
		quota.put("idCavallo", idCavallo);
		quota.put("Valore", valore);
		//scrive su file
		try(FileWriter f=new FileWriter("Quote.json",true)){
			f.write(quota.toString());
			f.write("\n");
		}catch(Exception e){}

	}

	public boolean checkID(int id) {
		if(this.idCorsa == id) {
			return true;
		}
		return false;
	}
	
	public int getIDCorsa() {
		return idCorsa;
	}

	public int getIDCavallo() {
		return idCavallo;
	}

	public double getValore() {
		return valore;
	}
	
}
