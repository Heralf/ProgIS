package it.unisa.Model;

import java.io.Serializable;

public class ModuloBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	AccountBean account = new AccountBean();
	String Data;
	String CartaIdentita;
	String Destinazione1;
	String Destinazione2;
	String Destinazione3;
	
	//inizializzo le variabili
	public ModuloBean(){
		CartaIdentita = "";
		Data = "";
		Destinazione1 = "";
		Destinazione2 = "";
		Destinazione3 = "";
	}
	
	public void setAccount(AccountBean account){
		this.account = account;
	}
	
	public AccountBean getAccount(){
		return account;
	}
	
	public void setData(String Data){
		this.Data = Data;
	}
	
	public String getData(){
		return Data;
	}
	
	public void setCartaIdentita(String CartaIdentita){
		this.CartaIdentita = CartaIdentita;
	}
	
	public String getCartaIdentita(){
		return CartaIdentita;
	}
	
	public void setDestinazione1(String Destinazione1){
		this.Destinazione1 = Destinazione1;
	}
	
	public String getDestinazione1(){
		return Destinazione1;
	}
	
	public void setDestinazione2(String Destinazione2){
		this.Destinazione2 = Destinazione2;
	}
	
	public String getDestinazione2(){
		return Destinazione2;
	}
	
	public void setDestinazione3(String Destinazione3){
		this.Destinazione3 = Destinazione3;
	}
	
	public String getDestinazione3(){
		return Destinazione3;
	}
	
	@Override
	public String toString() {
		return account.toString() + " " + CartaIdentita + " " + Destinazione1 + " " + Destinazione2 + " " + Destinazione3;
	}
}
