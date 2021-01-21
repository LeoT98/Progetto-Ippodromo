package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

class IscrizioneTest {

	@Test
	void getTest() {
		Iscrizione i=new Iscrizione(1,2,3);
		assertEquals(1,i.getIdFantino());
		assertEquals(2,i.getIdCavallo());
		assertEquals(3,i.getIdCorsa());
	}
	
	@Test
	void checkTest() {
		Iscrizione i=new Iscrizione(1,2,3);
		assertTrue(i.checkID(3));
		assertFalse(i.checkID(4));
		}
	
	@Test
	void aggiungiTest() {
		
		Iscrizione m=new Iscrizione(99999999,99999999,99999999);
		m.aggiungiIscrizione();
		String st;
		List<Iscrizione> jl=new ArrayList<Iscrizione>();
		// legge il file e salva gli elementi da tenere
		try(FileReader f = new FileReader("iscrizioni.json")  ){
			BufferedReader br = new BufferedReader(f);
			 while ((st = br.readLine()) != null) {
				    JSONObject x=new JSONObject(st);
				    Iscrizione i=new Iscrizione(x.getInt("idFantino"),x.getInt("idCavallo"),x.getInt("idCorsa"));
				    if(i.checkID(99999999)) {
				    		jl.add(i);
				    }
			  }
			 f.close();}catch(Exception e) {}
		assertTrue(jl.get(0).checkID(99999999));
		
		String st1;
		ArrayList<JSONObject> jl1=new ArrayList<JSONObject>();
		// legge il file e salva gli elementi da tenere
		try(FileReader f = new FileReader("iscrizioni.json")  ){
			BufferedReader br = new BufferedReader(f);
			 while ((st1 = br.readLine()) != null) {
				    JSONObject x=new JSONObject(st1);
				    if((int)x.get("idCavallo")!=99999999) {
				    		jl1.add(x);
				    }
			  }
			 f.close();}catch(Exception e) {}
		//svuota file
		try{
			FileWriter f=new FileWriter("iscrizioni.json");
			f.close();
			}catch(Exception e){}
		//riscrive il file
		try{
			FileWriter f=new FileWriter("iscrizioni.json",true);
			for(int c=0;c<jl1.size();c++) {
				f.write(jl1.get(c).toString());
				f.write("\n");
			}	f.close();	}catch(Exception e){}
	}
	
}
