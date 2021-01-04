package MainP;

public class Date {
	int giorno, mese, anno;
	public Date(int g, int m, int a) {
		giorno=g;  mese=m;  anno=a;
	}
	public Date(String d) {
		String[] s=d.split("/");
		giorno=Integer.parseInt(s[0]);  mese=Integer.parseInt(s[1]);   anno=Integer.parseInt(s[2]); 
	}
	
	public String toString() {
		return giorno+"/"+mese+"/"+anno;
	}
}
