package com.example.demo;

public class Fantino {
	private int id;
	private String nome;
	private String cognome; 
	private String scuderia; 
	
	private static int idcount = 0;
	
	public Fantino(String nome, String cognome, String scuderia) {
		this.id = idcount++;
		this.nome = nome;
		this.cognome = cognome;
		this.scuderia = scuderia;
	}
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getScuderia() {
		return scuderia;
	}


}