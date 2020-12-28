package MainP;

import java.io.FileWriter;

public class Main {
		public static void main(String args[]) {


//   		    try{
//			FileWriter f=new FileWriter("biglietti.json");
//			f.close();
//			}catch(Exception e){}
//			Biglietto a=new Biglietto("m",new Data(1,2,1998),1,10.2);
//			Biglietto b=new Biglietto("p",new Data(2,2,1998),0,30.0);
//			Biglietto c=new Biglietto("m", new Data(3,2,1998),1,10.2);
//			Biglietto d=new Biglietto("p",new Data(4,2,1998),0,30.0);
//			a.aggiungiBiglietto();
//			b.aggiungiBiglietto();
//			c.aggiungiBiglietto();
//			d.aggiungiBiglietto();
//			
//			b.rimuoviBiglietto();
			
			Data a=new Data("1/2/1998");
			System.out.print(a.toString());

			
			
			
			
			
			
			
			
			
			
			
			
/* ESEMPI
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
*/			
			
			
			
	}

		
		
		
		
		
		
		
		
		
}
