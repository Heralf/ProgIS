package it.unisa.Model;

import java.io.Serializable;

public class MessaggioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	int IDProprietario;
	String Titolo;
	String Messaggio;
	Boolean Visto;
	//funzione che inizializza tutte le variabili
	public MessaggioBean(){
		IDProprietario = 0;
		Titolo = "";
		Messaggio = "";
		Visto = false;
	}
	//sostituisce la variabile intera IDProprietario con quella ottenuta
	public void setIDProprietario(int IDProprietario){
		this.IDProprietario = IDProprietario;
	}
	//restituisce la variabile itera IDProprietario
	public int getIDProprietario(){
		return IDProprietario;
	}
	//sostituisce la variabile stringa Titolo con quella ottenuta
	public void setTitolo(String Titolo){
		this.Titolo = Titolo;
	}
	//restituisce la variabile stringa Titolo
	public String getTitolo(){
		return Titolo;
	}
	//sostituisce la variabile stringa Messaggio con quella ottenuta
	public void setMessaggio(String Messaggio){
		this.Messaggio = Messaggio;
	}
	//restituisce la variabile stringa Messagio
	public String getMessaggio(){
		return Messaggio;
	}
	//sostituisce la variabile Booleana Visto con quella ottenuta
	public void setVisto(Boolean Visto){
		this.Visto = Visto;
	}
	//restituisce la variabile Booleana Visto
	public boolean getVisto(){
		return Visto;
	}
}
