package com.example.demo;

public class Data {
	private int giorno, mese, anno;
	public Data(int g, int m, int a) {
		giorno=g;  mese=m;  anno=a;
	}
	public Data(String d) {
		String[] s=d.split("/");
		giorno=Integer.parseInt(s[0]);  mese=Integer.parseInt(s[1]);   anno=Integer.parseInt(s[2]); 
	}
	
	public String toString() {
		return giorno+"/"+mese+"/"+anno;
	}
	
	public boolean equals(Data dataConf) {
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
