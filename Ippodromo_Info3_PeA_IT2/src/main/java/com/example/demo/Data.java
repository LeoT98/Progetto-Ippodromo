package com.example.demo;

public class Data {
	private int giorno, mese, anno;
	
	/**
	 * costruttore che usa 3 interi per definire giorno, mese e anno
	 * @param g
	 * @param m
	 * @param a
	 */
	public Data(int g, int m, int a) {
		giorno=g;  mese=m;  anno=a;
	}
	
	/**
	 * costruttore che usa una stringa nel formato 'g/m/a'
	 * @param d
	 */
	public Data(String d) {
		String[] s=d.split("/");
		giorno=Integer.parseInt(s[0]);  mese=Integer.parseInt(s[1]);   anno=Integer.parseInt(s[2]); 
	}
	
	/**
	 * da la data come stringa
	 */
	public String toString() {
		return giorno+"/"+mese+"/"+anno;
	}
	
	/**
	 * controlla se questa data è uguale a quella passata
	 * @param dataConf è un oggettp Data
	 * @return
	 */
	public boolean equals(Data dataConf) {
		if(this.giorno==dataConf.giorno & this.mese==dataConf.mese & this.anno ==dataConf.anno) {
			return true;
		}
		return false;
	}
	
	/**
	 *  controlla se questa data è uguale a quella passata
	 * @param d è un oggetto String
	 * @return
	 */
	public boolean equals(String d) {
		Data dataConf=new Data(d);
		if(this.giorno==dataConf.giorno & this.mese==dataConf.mese & this.anno ==dataConf.anno) {
			return true;
		}
		return false;
	}
	
	public int getGiorno() {
		return giorno;
	}

	public int getMese() {
		return mese;
	}

	public int getAnno() {
		return anno;
	}

}
