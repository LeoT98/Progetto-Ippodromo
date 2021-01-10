package com.example.demo;

import java.io.FileWriter;

import org.json.JSONObject;

public class Quota {

	private int IDCorsa;
	private int IDCavallo;
	private double valore;
	
	public Quota(int IDCorsa, int IDCavallo, double valore) {
		this.IDCorsa = IDCorsa;
		this.IDCavallo = IDCavallo;
		this.valore = valore;
	}
	
	public void aggiungiQuota() {
		//Crea oggetto json
		JSONObject quota =new JSONObject();
		quota.put("IDCorsa", IDCorsa);
		quota.put("IDCavallo", IDCavallo);
		quota.put("Valore", valore);
		//scrive su file
		try(FileWriter f=new FileWriter("Quote.json",true)){
			f.write(quota.toString());
			f.write("\n");
		}catch(Exception e){}

	}

	public boolean checkID(int id) {
		if(this.IDCorsa == id) {
			return true;
		}
		return false;
	}
	
	public int getIDCorsa() {
		return IDCorsa;
	}

	public int getIDCavallo() {
		return IDCavallo;
	}

	public double getValore() {
		return valore;
	}
	
}
