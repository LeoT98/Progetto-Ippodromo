package com.example.demo;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

public class Cavallo {
	private int id;
	private String nome;
	private String scuderia; 
	private String razza;
	
	private static int idcount = 0;
	
	public Cavallo(String nome, String scuderia, String razza) {
		this.id = idcount++;
		this.nome = nome;
		this.scuderia = scuderia;
		this.razza = razza;
	}
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getScuderia() {
		return scuderia;
	}

	public String getRazza() {
		return razza;
	}
	
}