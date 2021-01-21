package com.example.demo;
import java.io.FileWriter;

import org.json.JSONObject;

public class Scommessa {
	private int id;
	private int idCorsa;
	private int idCavallo; 
	private double importo;
	private static int idcount = 0;
	
    /**
     * 
     * @param IDCorsa id della corsa su cui scommetti
     * @param cavallo id del cavallo su cui scommetti
     * @param importo importo scommesso
     */
	public Scommessa(int IDCorsa, int cavallo, double importo) {
		this.id = idcount++;
		this.idCorsa = IDCorsa;
		this.idCavallo = cavallo;
		this.importo = importo;
	}
	
/**
 *
 * @param idCorsa the id corsa
 * @param idCavallo the id cavallo
 * @param importo the importo
 * @param idScommessa the id scommessa
 */
public Scommessa(int idCorsa, int idCavallo, double importo, int idScommessa) {
	this.id=idScommessa;
	this.idCorsa = idCorsa;
	this.idCavallo = idCavallo;
	this.importo = importo;
	}

/**
 * aggiunge la scommessa al file 'Scommesse.json'
 */
	public void aggiungiScommessa() {
		//Crea oggetto json
		JSONObject scommessa =new JSONObject();
		scommessa.put("idScommessa", id);
		scommessa.put("idCorsa", idCorsa);
		scommessa.put("idCavallo", idCavallo);
		scommessa.put("importo", importo);
		//scrive su file
		try(FileWriter f=new FileWriter("Scommesse.json",true)){
			f.write(scommessa.toString());
			f.write("\n");
		}catch(Exception e){}
	}
	
	/**
	 * controlla se l'id di questa scommessa corrisponde ad un certo id 
	 * @param idcorsa
	 * @return
	 */
		public boolean checkIDScommessa(int idcorsa) {
			if(this.idCorsa==idcorsa) {
				return true;
			}
			return false;
		}
	
	public int getId() {
		return id;
	}

	public int getIDCorsa() {
		return idCorsa;
	}

	public int getCavallo() {
		return idCavallo;
	}

	public double getImporto() {
		return importo;
	}
	
	@Override
    public boolean equals(Object arg0) {
        boolean flag=false;
        System.out.println("prova");
        if(this.getCavallo()==(int)arg0) {
        	flag=true;
        }
        return flag;
        
    }
	
}