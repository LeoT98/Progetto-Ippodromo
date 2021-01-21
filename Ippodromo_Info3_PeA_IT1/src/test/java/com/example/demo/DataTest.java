package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DataTest {

	@Test
	void getTest() {
		Data d=new Data(1,11,1111);
		assertEquals(d.getAnno(),1111);
		assertEquals(d.getMese(),11);
		assertEquals(d.getGiorno(),1);
		
		Data d1=new Data("1/11/1111");
		assertEquals(d1.getAnno(),1111);
		assertEquals(d1.getMese(),11);
		assertEquals(d1.getGiorno(),1);
	}
	
	@Test
	void toStringTest() {
		Data d=new Data(1,11,1111);
		assertEquals(d.toString(),"1/11/1111");
	}

}
