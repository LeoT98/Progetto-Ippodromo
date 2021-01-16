package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

class FantinoTest {

	@Test
	void getTest() {
		Fantino f=new Fantino("nome","cognome","scuderia");
		assertEquals(f.getCognome(),"cognome");
		assertEquals(f.getNome(),"nome");
		assertEquals(f.getScuderia(),"scuderia");
	}

	@Test
	void testGetId() {
		Fantino f=new Fantino("nome","cognome","scuderia");
		Fantino f2=new Fantino("nome","cognome","scuderia");
		assertEquals(f2.getId(),1);
	}
}
