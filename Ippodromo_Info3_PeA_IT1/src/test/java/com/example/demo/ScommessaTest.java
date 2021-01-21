package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

class ScommessaTest {

	@Test
	void getTest() {
		Scommessa i=new Scommessa(1,2,3);
		assertEquals(i.getIDCorsa(),1);
		assertEquals(i.getCavallo(),2);
		assertEquals(i.getImporto(),3);
	}
	
	@Test
	void testGetId() {
		Scommessa i=new Scommessa(1,2,3);
		Scommessa i2=new Scommessa(1,2,3);
		assertEquals(i2.getId(),1);
	}
	

	@Test
	void aggiungiTest() {
		
		Scommessa m=new Scommessa(999999,2,3);
		m.aggiungiScommessa();
		String st;
		List<Scommessa> jl=new ArrayList<Scommessa>();
		// legge il file e salva gli elementi da tenere
		try(FileReader f = new FileReader("Scommesse.json")  ){
			BufferedReader br = new BufferedReader(f);
			 while ((st = br.readLine()) != null) {
				    JSONObject x=new JSONObject(st);
				    Scommessa i=new Scommessa(x.getInt("idCorsa"),x.getInt("idCavallo"),x.getInt("importo"),x.getInt("idScommessa"));
				    if(i.getIDCorsa()==999999) {
				    		jl.add(i);
				    }
			  }
			 f.close();}catch(Exception e) {}
		assertTrue(jl.get(0).getIDCorsa()==999999);

		String st1;
		ArrayList<JSONObject> jl1=new ArrayList<JSONObject>();
		// legge il file e salva gli elementi da tenere
		try(FileReader f = new FileReader("Scommesse.json")  ){
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
			FileWriter f=new FileWriter("Scommesse.json");
			f.close();
			}catch(Exception e){}
		//riscrive il file
		try{
			FileWriter f=new FileWriter("Scommesse.json",true);
			for(int c=0;c<jl1.size();c++) {
				f.write(jl1.get(c).toString());
				f.write("\n");
			}	f.close();	}catch(Exception e){}
	}

}
