package it.unisa.Model;

import java.io.Serializable;

public class AccountBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	int ID;
	String Nome;
	String Cognome;
	String Sesso;
	String Data;
	String Matricola;
	String PostaElettronica;
	String Password;
	String CittaNascita;
	String CittaResidenza;
	String Indirizzo;
	int NumeroCivico;
	int CAP;
	String NumeroTelefonico;
	boolean Admin;
	
	//funzione che inizializza tutte le variabili
	public AccountBean() {
		ID=0;
		Nome="";
		Cognome="";
		Sesso="";
		Data="";
		Matricola="";
		PostaElettronica="";
		Password="";
		CittaNascita="";
		CittaResidenza="";
		Indirizzo="";
		NumeroCivico=0;
		CAP=0;
		NumeroTelefonico="";
		Admin=false;
	}
	//restituisce la variabile intera ID
	public int getID() {
		return ID;
	}
	//sostituisce la variabile intera ID con quella ottenuta
	public void setID(int ID) {
		this.ID = ID;
	}
	//restituisce la variabile stringa Nome
	public String getNome() {
		return Nome;
	}
	//sostituisce la variabile stringa Nome con quella ottenuta
	public void setNome(String Nome) {
		this.Nome = Nome;
	}
	//restituisce la variabile stringa Cognome
	public String getCognome() {
		return Cognome;
	}
	//sostituisce la variabile stringa Cognome con quella ottenuta
	public void setCognome(String Cognome) {
		this.Cognome = Cognome;
	}
	//restituisce la variabile stringa Sesso
	public String getSesso() {
		return Sesso;
	}
	//sostituisce la variabile stringa Sesso  con quella ottenuta
	public void setSesso(String Sesso) {
		this.Sesso = Sesso;
	}
	//restituisce la variabile stringa Data
	public String getData() {
		return Data;
	}
	//sostituisce la variabile stringa Data con quella ottenuta
	public void setData(String Data) {
		this.Data = Data;
	}
	//restituisce la variabile stringa Matricola
	public String getMatricola() {
		return Matricola;
	}
	//sostituisce la variabile stringa Matricola con quella ottenuta
	public void setMatricola(String Matricola) {
		this.Matricola = Matricola;
	}
	//restituisce la variabile stringa PostaElettronica
	public String getPostaElettronica() {
		return PostaElettronica;
	}
	//sostituisce la variabile stringa PostaElettronica con quella ottenuta
	public void setPostaElettronica(String PostaElettronica) {
		this.PostaElettronica = PostaElettronica;
	}
	//restituisce la variabile string Password
	public String getPassword() {
		return Password;
	}
	//sostituisce la variabile string Password con quella ottenuta
	public void setPassword(String Password) {
		this.Password = Password;
	}
	//restituisce la variabile stringa CittaNascita
	public String getCittaNascita() {
		return CittaNascita;
	}
	//sostituisce la variabile stringa CittaNascita con quella ottenuta
	public void setCittaNascita(String CittaNascita) {
		this.CittaNascita = CittaNascita;
	}
	//restituisce la variabile stringa CittaResidenza
	public String getCittaResidenza() {
		return CittaResidenza;
	}
	//sostituisce la variabile stringa CittaResidenza con quella ottenuta
	public void setCittaResidenza(String CittaResidenza) {
		this.CittaResidenza = CittaResidenza;
	}
	//restituisce la variabile stringa Indirizzo
	public String getIndirizzo() {
		return Indirizzo;
	}
	//sostituisce la variabile stringa indirizzo con quella ottenuta
	public void setIndirizzo(String Indirizzo) {
		this.Indirizzo = Indirizzo;
	}
	//restituisce la variabile intera NumeroCivico
	public int getNumeroCivico() {
		return NumeroCivico;
	}
	//sostituisce la variabile intera NumeroCivico con quella ottenuta
	public void setNumeroCivico(int NumeroCivico) {
		this.NumeroCivico = NumeroCivico;
	}
	//restituisce la variabile intera CAP
	public int getCAP() {
		return CAP;
	}
	//sostituisce la variabile intera CAP con quella ottenuta
	public void setCAP(int CAP) {
		this.CAP = CAP;
	}
	//restituisce la variabile string NumeroTelefonico
	public String getNumeroTelefonico() {
		return NumeroTelefonico;
	}
	//sostituisce la variabile string NumeroTelefonico con quella ottenuta
	public void setNumeroTelefonico(String NumeroTelefonico) {
		this.NumeroTelefonico = NumeroTelefonico;
	}
	//restituisce la variabile booleana Admin
	public boolean getAdmin() {
		return Admin;
	}
	//sostituisce la variabile booleana Admin con quella ottenuta
	public void setAdmin(boolean Admin) {
		this.Admin = Admin;
	}
		
	@Override//funzione che mi restituisce una stringa dell'intera classe(usata nei testing)
	public String toString() {
		return Nome + " " + Cognome + " (" + Matricola + ") " + " " + Data + " " + " " + Sesso + " " + PostaElettronica + " " + 
			   Password + " " + CittaNascita + " " + CittaResidenza + " " + Indirizzo + " " + NumeroCivico + " " + CAP + " " + 
			   " Amministratore( " + Admin + " ) "+ NumeroTelefonico;
	}
}
