package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

class CorsaTest {

	@Test
	void getTest() {
		Corsa f=new Corsa("m","1/1/1111",3);
		assertEquals(f.getOra(),"m");
		assertTrue(f.getData().equals(new Data("1/1/1111")));
		assertEquals(f.getMaxPartecipanti(),3);
		
		Data d=new Data(1,1,1111);
		Corsa f2=new Corsa("m","1/1/1111",3);
		assertEquals(f2.getOra(),"m");
		assertTrue(f2.getData().equals(d));
		assertEquals(f2.getMaxPartecipanti(),3);
		
		Corsa f3=new Corsa("m","1/1/1111",3,0);
		assertEquals(f3.getOra(),"m");
		assertTrue(f3.getData().equals(new Data("1/1/1111")));
		assertEquals(f3.getMaxPartecipanti(),3);
		assertEquals(f3.getId(),0);
	}

	@Test
	void testGetId() {
		Corsa f=new Corsa("m","1/1/1111",3);
		Corsa f2=new Corsa("m","1/1/1111",3);
		assertEquals(f2.getId(),1);
	}
	
}
