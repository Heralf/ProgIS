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
	
	public GraduatoriaBean(){
		id=0;
		NomeGrad="";
		TipoGrad="";
		PesoGrad=0;
		Graduatoria = null;
		
	}
	
	public void setID (int id){
		this.id = id;
	}
	
	public int getID (){
		return id;
	}
	
	public void setNomeGrad (String NomeGrad){
		this.NomeGrad = NomeGrad;
	}
	
	public String getNomeGrad (){
		return NomeGrad;
	}
	
	public void setTipoGrad (String TipoGrad){
		this.TipoGrad = TipoGrad;
	}
	
	public String getTipoGrad (){
		return TipoGrad;
	}
	
	public void setPesoGrad (long PesoGrad){
		this.PesoGrad = PesoGrad;
	}
	
	public long getPesoGrad (){
		return PesoGrad;
	}

	public void setGraduatoria (InputStream Graduatoria){
		this.Graduatoria = Graduatoria;
	}
	
	public InputStream getGraduatoria (){
		return Graduatoria;
	}
}
