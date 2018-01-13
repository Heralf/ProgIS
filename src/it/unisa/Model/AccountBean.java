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
	
	//inizializzo le variabili
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

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String Nome) {
		this.Nome = Nome;
	}
	
	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String Cognome) {
		this.Cognome = Cognome;
	}
	
	public String getSesso() {
		return Sesso;
	}

	public void setSesso(String Sesso) {
		this.Sesso = Sesso;
	}
	
	public String getData() {
		return Data;
	}

	public void setData(String Data) {
		this.Data = Data;
	}
	
	public String getMatricola() {
		return Matricola;
	}

	public void setMatricola(String Matricola) {
		this.Matricola = Matricola;
	}
	
	public String getPostaElettronica() {
		return PostaElettronica;
	}

	public void setPostaElettronica(String PostaElettronica) {
		this.PostaElettronica = PostaElettronica;
	}
	
	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}
	
	public String getCittaNascita() {
		return CittaNascita;
	}

	public void setCittaNascita(String CittaNascita) {
		this.CittaNascita = CittaNascita;
	}
	
	public String getCittaResidenza() {
		return CittaResidenza;
	}

	public void setCittaResidenza(String CittaResidenza) {
		this.CittaResidenza = CittaResidenza;
	}
	
	public String getIndirizzo() {
		return Indirizzo;
	}

	public void setIndirizzo(String Indirizzo) {
		this.Indirizzo = Indirizzo;
	}
	
	public int getNumeroCivico() {
		return NumeroCivico;
	}

	public void setNumeroCivico(int NumeroCivico) {
		this.NumeroCivico = NumeroCivico;
	}
	
	public int getCAP() {
		return CAP;
	}

	public void setCAP(int CAP) {
		this.CAP = CAP;
	}
	
	public String getNumeroTelefonico() {
		return NumeroTelefonico;
	}

	public void setNumeroTelefonico(String NumeroTelefonico) {
		this.NumeroTelefonico = NumeroTelefonico;
	}
	
	public boolean getAdmin() {
		return Admin;
	}

	public void setAdmin(boolean Admin) {
		this.Admin = Admin;
	}
		
	@Override
	public String toString() {
		return Nome + " " + Cognome + " (" + Matricola + ") " + " " + Data + " " + " " + Sesso + " " + PostaElettronica + " " + Password + " " + CittaNascita + " " + CittaResidenza + " " + Indirizzo + " " + NumeroCivico + " " + CAP + " " + " Amministratore( " + Admin + " ) "+ NumeroTelefonico;
	}
}
