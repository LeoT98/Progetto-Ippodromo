package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import org.json.JSONObject;

public class Corsa {
	int id;
	String ora;
	Data data;
	int maxPartecipanti;
//	ArrayList<Cavallo> cavalliIscritti=new ArrayList<Cavallo>();
//	ArrayList<Fantino> cavalliIscritti=new ArrayList<Fantino>();
	static int idcount=0;

	
	public Corsa(	String o, Data d, int z) {
       id=idcount++; ora=o; data=d; maxPartecipanti=z;
	}
	public Corsa(	String o, String d, int z) {
	    id=idcount++; ora=o; data=new Data(d); maxPartecipanti=z;
	}	
	
	public Corsa(String ora, String data, int maxPartecipanti, int id) {
		this.ora=ora;
		this.data=new Data(data);
		this.id=id;
		this.maxPartecipanti=maxPartecipanti;
	}
	public void aggiungiCorsa() {
		JSONObject corsa=new JSONObject();
		corsa.put("ora", ora);
		corsa.put("data", data);
		corsa.put("maxPartecipanti", maxPartecipanti);
		corsa.put("id", id);
//    aggiungere cavallo e fantino		///////////////////////////////////////
		
		try(FileWriter f=new FileWriter("corse.json",true)){
			f.write(corsa.toString());
			f.write("\n");
		}catch(Exception e){}
	}
	
	
	public void rimuoviCorsa() {
		String st;
		ArrayList<JSONObject> jl=new ArrayList<JSONObject>();
		try(FileReader f = new FileReader("corse.json")  ){
			BufferedReader br = new BufferedReader(f);
			 while ((st = br.readLine()) != null) {
				    JSONObject x=new JSONObject(st);
				    if((int)x.get("id")!=id) {
				    		jl.add(x);
				    }
			  }
			 f.close();}catch(Exception e) {}
		
		try{
			FileWriter f=new FileWriter("corse.json");
			f.close();
			}catch(Exception e){}
		
		try{
			FileWriter f=new FileWriter("corse.json",true);
			for(int c=0;c<jl.size();c++) {
				f.write(jl.get(c).toString());
				f.write("\n");
			}	f.close();	}catch(Exception e){}
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
