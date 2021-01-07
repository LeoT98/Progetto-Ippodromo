package com.example.demo;
import java.io.FileWriter;

import org.json.JSONObject;

public class Scommessa {
	private int id;
	private int IDCorsa;
	private int cavallo; 
	private double importo;
	
	private static int idcount = 0;
	
	public Scommessa(int IDCorsa, int cavallo, double importo) {
		this.id = idcount++;
		this.IDCorsa = IDCorsa;
		this.cavallo = cavallo;
		this.importo = importo;
	}

	public int getId() {
		return id;
	}

	public int getIDCorsa() {
		return IDCorsa;
	}

	public int getCavallo() {
		return cavallo;
	}

	public double getImporto() {
		return importo;
	}
	
	public void aggiungiScommessa() {
		//Crea oggetto json
		JSONObject scommessa =new JSONObject();
		scommessa.put("IDScommessa", id);
		scommessa.put("IDCorsa", IDCorsa);
		scommessa.put("Cavallo", cavallo);
		scommessa.put("importo", importo);
		//scrive su file
		try(FileWriter f=new FileWriter("Scommesse.json",true)){
			f.write(scommessa.toString());
			f.write("\n");
		}catch(Exception e){}

	}
}