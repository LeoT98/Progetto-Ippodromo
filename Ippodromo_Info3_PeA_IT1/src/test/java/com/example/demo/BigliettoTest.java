package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;



class BigliettoTest {


	@Test
	void getTest() {
		Biglietto b=new Biglietto("m","1/1/1111",0,1);
		assertEquals(b.getOra(),"m");
		assertEquals(b.getPrezzo(),1);
		assertEquals(b.getZona(),0);
		assertEquals(b.getData().toString(),"1/1/1111");
	}

	@Test
	void testGetId() {
		Biglietto b=new Biglietto("m","1/1/1111",0,1);
		Biglietto b2=new Biglietto("m","1/1/1111",0,1);
		assertEquals(b2.getId(),1);
	}



}
