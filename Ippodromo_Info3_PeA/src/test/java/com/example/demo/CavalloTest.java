package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CavalloTest {

	@Test
	void getTest() {
		Cavallo f=new Cavallo("nome","scuderia","razza");
		assertEquals(f.getNome(),"nome");
		assertEquals(f.getScuderia(),"scuderia");
		assertEquals(f.getRazza(),"razza");
	}

	@Test
	void testGetId() {
		Cavallo f=new Cavallo("nome","scuderia","razza");
		Cavallo f2=new Cavallo("nome","scuderia","razza");
		assertEquals(f2.getId(),1);
	}
}
