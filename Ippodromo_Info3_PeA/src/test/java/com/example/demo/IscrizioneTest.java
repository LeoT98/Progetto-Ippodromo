package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IscrizioneTest {

	@Test
	void getTest() {
		Iscrizione i=new Iscrizione(1,2,3);
		assertEquals(1,i.getIdFantino());
		assertEquals(2,i.getIdCavallo());
		assertEquals(3,i.getIdCorsa());
	}

}
