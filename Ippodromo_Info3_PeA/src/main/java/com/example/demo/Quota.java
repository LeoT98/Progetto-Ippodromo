package com.example.demo;

public class Quota {


	private int IDCorsa;
	private int IDCavallo;
	private double valore;
	
	public Quota(int iDCorsa, int iDCavallo, double valore) {
		this.IDCorsa = iDCorsa;
		this.IDCavallo = iDCavallo;
		this.valore = valore;
	}
	
	public int getIDCorsa() {
		return IDCorsa;
	}
	public void setIDCorsa(int iDCorsa) {
		IDCorsa = iDCorsa;
	}
	public int getIDCavallo() {
		return IDCavallo;
	}
	public void setIDCavallo(int iDCavallo) {
		IDCavallo = iDCavallo;
	}
	public double getValore() {
		return valore;
	}
	public void setValore(double valore) {
		this.valore = valore;
	}
}
