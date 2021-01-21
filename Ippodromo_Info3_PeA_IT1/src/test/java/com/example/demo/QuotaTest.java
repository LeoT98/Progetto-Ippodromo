package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

class QuotaTest {

	@Test
	void getTest() {
		Quota i=new Quota(1,2,3);
		assertEquals(i.getIDCavallo(),2);
		assertEquals(i.getIDCorsa(),1);
		assertEquals(i.getValore(),3);
	}
	
	@Test
	void checkTest() {
		Quota i=new Quota(1,2,3);
		assertTrue(i.checkID(1));
		assertFalse(i.checkID(4));
		}
	
	@Test
	void aggiungiTest() {
		
		Quota m=new Quota(999999,2,3);
		m.aggiungiQuota();
		String st;
		List<Quota> jl=new ArrayList<Quota>();
		// legge il file e salva gli elementi da tenere
		try(FileReader f = new FileReader("Quote.json")  ){
			BufferedReader br = new BufferedReader(f);
			 while ((st = br.readLine()) != null) {
				    JSONObject x=new JSONObject(st);
				    Quota i=new Quota(x.getInt("idCorsa"),x.getInt("idCavallo"),x.getDouble("Valore"));
				    if(i.checkID(999999)) {
				    		jl.add(i);
				    }
			  }
			 f.close();}catch(Exception e) {}
		assertTrue(jl.get(0).checkID(999999));
		
		String st1;
		ArrayList<JSONObject> jl1=new ArrayList<JSONObject>();
		// legge il file e salva gli elementi da tenere
		try(FileReader f = new FileReader("Quote.json")  ){
			BufferedReader br = new BufferedReader(f);
			 while ((st1 = br.readLine()) != null) {
				    JSONObject x=new JSONObject(st1);
				    if((int)x.get("idCorsa")!=999999) {
				    		jl1.add(x);
				    }
			  }
			 f.close();}catch(Exception e) {}
		//svuota file
		try{
			FileWriter f=new FileWriter("Quote.json");
			f.close();
			}catch(Exception e){}
		//riscrive il file
		try{
			FileWriter f=new FileWriter("Quote.json",true);
			for(int c=0;c<jl1.size();c++) {
				f.write(jl1.get(c).toString());
				f.write("\n");
			}	f.close();	}catch(Exception e){}
	}

}
