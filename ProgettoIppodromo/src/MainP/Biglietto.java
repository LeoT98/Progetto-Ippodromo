package MainP;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import org.json.JSONObject;

public class Biglietto {
	int id;
	String ora;
	String data;
	int  zona;
	double prezzo;
	static int idcount=0;
	JSONObject biglietto;
	
	public Biglietto(	String o, String d, int z, double p) {
       id=idcount++; ora=o; data=d; zona=z; prezzo=p;
	}
	
	public void aggiungiBiglietto() {
		JSONObject b=new JSONObject();
		b.put("ora", ora);
		b.put("data", data);
		b.put("zona", zona);
		b.put("prezzo", prezzo);
		b.put("id", id);
		biglietto=new JSONObject(b);
		try(FileWriter f=new FileWriter("biglietti.json",true)){
			f.write(b.toString());
			f.write("\n");
		}catch(Exception e){}

	}
	
	public void rimuoviBiglietto() {
		String st;
		ArrayList<JSONObject> jl=new ArrayList<JSONObject>();
		try(FileReader f = new FileReader("biglietti.json")  ){
			BufferedReader br = new BufferedReader(f);
			 while ((st = br.readLine()) != null) {
				    JSONObject x=new JSONObject(st);
				    if((int)x.get("id")!=id) {
				    		jl.add(x);
				    }
			  }
			 f.close();}catch(Exception e) {}
		
		try{
			FileWriter f=new FileWriter("biglietti.json");
			f.close();
			}catch(Exception e){}
		
		try{
			FileWriter f=new FileWriter("biglietti.json",true);
			for(int c=0;c<jl.size();c++) {
				f.write(jl.get(c).toString());
				f.write("\n");
			}	f.close();	}catch(Exception e){}
		
		
		
	}
	
	
	
	
	
}

