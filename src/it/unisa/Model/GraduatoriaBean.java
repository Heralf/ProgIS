package it.unisa.Model;

import java.io.InputStream;
import java.io.Serializable;

import com.mysql.jdbc.Blob;

public class GraduatoriaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	int id;
	String NomeGrad;
	String TipoGrad;
	long PesoGrad;
	InputStream Graduatoria;
	//funzione che inizializza tutte le variabili
	public GraduatoriaBean(){
		id=0;
		NomeGrad="";
		TipoGrad="";
		PesoGrad=0;
		Graduatoria = null;
		
	}
	//sostituisce la variabile intera ID con quella ottenuta
	public void setID (int id){
		this.id = id;
	}
	//restituisce la variabile intera ID
	public int getID (){
		return id;
	}
	//sostituisce la variabile stringa NomeGrad(il nome della graduatoria) con quella ottenuta
	public void setNomeGrad (String NomeGrad){
		this.NomeGrad = NomeGrad;
	}
	//restituisce la variabile stringa NomeGrad
	public String getNomeGrad (){
		return NomeGrad;
	}
	//sostituisce la variabile stringa TipoGrad(il tipo del file scaricato) con quella ottenuta
	public void setTipoGrad (String TipoGrad){
		this.TipoGrad = TipoGrad;
	}
	//restituisce la variabile stringa TipoGrad
	public String getTipoGrad (){
		return TipoGrad;
	}
	//sostituisce la variabile longPesoGrad (peso del file graduatoria) con quella ottenuta
	public void setPesoGrad (long PesoGrad){
		this.PesoGrad = PesoGrad;
	}
	//restituisce la variabile long PesoGrad
	public long getPesoGrad (){
		return PesoGrad;
	}
	//sostituisce la variabile InputStream Graduatoria(insieme di vaori) con quella ottenuta
	public void setGraduatoria (InputStream Graduatoria){
		this.Graduatoria = Graduatoria;
	}
	//restituisce la variabile InputStream Graduatoria
	public InputStream getGraduatoria (){
		return Graduatoria;
	}
}
