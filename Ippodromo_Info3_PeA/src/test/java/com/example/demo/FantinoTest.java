package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

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

	@Test
	void testGetNome() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCognome() {
		fail("Not yet implemented");
	}

	@Test
	void testGetScuderia() {
		fail("Not yet implemented");
	}

}
