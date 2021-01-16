package com.example.demo;
import java.io.FileWriter;

import org.json.JSONObject;

public class Scommessa {
	private int id;
	private int idCorsa;
	private int idCavallo; 
	private double importo;
	
	private static int idcount = 0;
	
	public Scommessa(int IDCorsa, int cavallo, double importo) {
		this.id = idcount++;
		this.idCorsa = IDCorsa;
		this.idCavallo = cavallo;
		this.importo = importo;
	}

	public int getId() {
		return id;
	}

	public int getIDCorsa() {
		return idCorsa;
	}

	public int getCavallo() {
		return idCavallo;
	}

	public double getImporto() {
		return importo;
	}
	
	public void aggiungiScommessa() {
		//Crea oggetto json
		JSONObject scommessa =new JSONObject();
		scommessa.put("idScommessa", id);
		scommessa.put("idCorsa", idCorsa);
		scommessa.put("Cavallo", idCavallo);
		scommessa.put("importo", importo);
		//scrive su file
		try(FileWriter f=new FileWriter("Scommesse.json",true)){
			f.write(scommessa.toString());
			f.write("\n");
		}catch(Exception e){}

	}
}