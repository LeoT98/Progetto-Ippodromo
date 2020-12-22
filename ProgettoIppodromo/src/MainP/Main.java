package MainP;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import org.json.JSONArray;
import org.json.JSONObject;



public class Main {
		public static void main(String args[]) {
			
// Creazione oggetti
			JSONObject a=new JSONObject();
			JSONObject b=new JSONObject();
			JSONObject c=new JSONObject();
			JSONArray v= new JSONArray();
			a.put("nome", "aldo");
			b.put("nome", "bortolo");
			c.put("nome", "ciro");	
			a.put("numero", 1);
			b.put("numero", 2);
			c.put("numero", 3);
			
			v.put(a);
			v.put(b);
			v.put(c);

//Scrittura su file
			try(FileWriter f=new FileWriter("geson.json")){
//				f.write(a.toString());
//				f.write(b.toString());
//				f.write(c.toString());
				f.write(v.toString());
				f.close();
			}catch(Exception e) {}
			
			
//Lettura da file	
			String st; 
			try(FileReader f = new FileReader("geson.json")  ){
				BufferedReader br = new BufferedReader(f);
				 while ((st = br.readLine()) != null) {
					    System.out.println(st); 
					    JSONArray x=new JSONArray(st);
					    x.forEach(q->System.out.println(q.toString()));
					    
				  }	f.close();}catch(Exception e) {}
			
//Sia letturaa che scrittura si possono fare con array o con oggetto singolo			
			
			
			
			
	}

		
		
		
		
		
		
		
		
		
}
