package MainP;


public class Main {
		public static void main(String args[]) {

			Biglietto a=new Biglietto("m", "6/6/1944",1,10.2);
			Biglietto b=new Biglietto("p","1/2/1998",0,30.0);
			Biglietto c=new Biglietto("m", "4/9/2020",1,10.2);
			Biglietto d=new Biglietto("p","25/5/1492",0,30.0);
			a.aggiungiBiglietto();
			b.aggiungiBiglietto();
			c.aggiungiBiglietto();
			d.aggiungiBiglietto();
			
			b.rimuoviBiglietto();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
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
