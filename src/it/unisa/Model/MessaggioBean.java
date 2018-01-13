package it.unisa.Model;

import java.io.Serializable;

public class MessaggioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	int IDProprietario;
	String Titolo;
	String Messaggio;
	Boolean Visto;
	
	public MessaggioBean(){
		IDProprietario = 0;
		Titolo = "";
		Messaggio = "";
		Visto = false;
	}
	
	public void setIDProprietario(int IDProprietario){
		this.IDProprietario = IDProprietario;
	}
	
	public int getIDProprietario(){
		return IDProprietario;
	}
	
	public void setTitolo(String Titolo){
		this.Titolo = Titolo;
	}
	
	public String getTitolo(){
		return Titolo;
	}
	
	public void setMessaggio(String Messaggio){
		this.Messaggio = Messaggio;
	}
	
	public String getMessaggio(){
		return Messaggio;
	}
	
	public void setVisto(Boolean Visto){
		this.Visto = Visto;
	}
	
	public boolean getVisto(){
		return Visto;
	}
}
