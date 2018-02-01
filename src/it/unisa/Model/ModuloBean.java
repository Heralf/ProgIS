package it.unisa.Model;

import java.io.Serializable;

public class ModuloBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	AccountBean account = new AccountBean();
	int id;
	int idProprietario;
	String Data;
	String CartaIdentita;
	String Destinazione1;
	String Destinazione2;
	String Destinazione3;
	Boolean domanda;
	Boolean InviaModulo;
	Boolean ConfermaModulo;
	
	//funzione che inizializza tutte le variabili
	public ModuloBean(){
		id=0;
		idProprietario=0;
		CartaIdentita = "";
		Data = "";
		Destinazione1 = "";
		Destinazione2 = "";
		Destinazione3 = "";
		domanda=false;
		InviaModulo=false;
		ConfermaModulo=false;
	}
	//sostituisce la variabile intera ID con quella ottenuta
	public void setID(int id){
		this.id = id;
	}
	//restituisce la variabile intera ID
	public int getID(){
		return id;
	}
	//sostituisce la variabile intera idProprietario con quella ottenuta
	public void setidProprietario(int idProprietario){
		this.idProprietario = idProprietario;
	}
	//restituisce la variabile idProprietario
	public int getidProprietario(){
		return idProprietario;
	}
	//sostituisce la variabile AccountBean account con quella ottenuta
	public void setAccount(AccountBean account){
		this.account = account;
	}
	//restituisce la variabile AccountBean account
	public AccountBean getAccount(){
		return account;
	}
	//sostituisce la variabile string Data con quella ottenuta
	public void setData(String Data){
		this.Data = Data;
	}
	//restituisce la variabile string data
	public String getData(){
		return Data;
	}
	//sostituisce la variabile string CartaIdentita con quella ottenuta
	public void setCartaIdentita(String CartaIdentita){
		this.CartaIdentita = CartaIdentita;
	}
	//restituisce la variabile string CartaIdentita
	public String getCartaIdentita(){
		return CartaIdentita;
	}
	//sostituisce la variabile string Destinazion1 con quella ottenuta
	public void setDestinazione1(String Destinazione1){
		this.Destinazione1 = Destinazione1;
	}
	//restituisce la variabile string Destinazione1
	public String getDestinazione1(){
		return Destinazione1;
	}
	//sostituisce la variabile string Destinazione 2 con quella ottenuta
	public void setDestinazione2(String Destinazione2){
		this.Destinazione2 = Destinazione2;
	}
	//restituisce la variabile string Destinazione 2
	public String getDestinazione2(){
		return Destinazione2;
	}
	//sostituisce la variabile string Destinazione 3 con quella ottenuta
	public void setDestinazione3(String Destinazione3){
		this.Destinazione3 = Destinazione3;
	}
	//restituisce la variabile string Destinazioe 3
	public String getDestinazione3(){
		return Destinazione3;
	}
	//sostituisce la variabile booleana domanda con quella ottenuta
	public void setDomanda (Boolean domanda){
		this.domanda = domanda;
	}
	//restituisce la variabile booleana domanda
	public Boolean getDomanda (){
		return domanda;
	}
	//sostituisce la variabile booleana InviaModulo con quella ottenuta
	public void setInviaModulo (Boolean InviaModulo){
		this.InviaModulo = InviaModulo;
	}
	//restituisce la variabile booleana InviaModulo
	public Boolean getInviaModulo (){
		return InviaModulo;
	}
	//sostituisce la variabile booleana ConfermaModulo con quella ottenuta
	public void setConfermaModulo (Boolean ConfermaModulo){
		this.ConfermaModulo = ConfermaModulo;
	}
	//restituisce la variabile booleana ConfermaModulo
	public Boolean getConfermaModulo (){
		return ConfermaModulo;
	}
	
	@Override //funzione che mi restituisce una stringa dell'intera classe(usata nei testing)
	public String toString() {
		return account.toString() + " " + CartaIdentita + " " + Destinazione1 + " " + Destinazione2 + " " + Destinazione3;
	}
}
