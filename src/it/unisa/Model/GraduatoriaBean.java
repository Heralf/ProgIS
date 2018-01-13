package it.unisa.Model;

import java.io.Serializable;

public class GraduatoriaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	int id;
	long Graduatoria;
	Boolean GraduatoriaPubblica;
	
	public GraduatoriaBean(){
		id=0;
		Graduatoria=0;
		GraduatoriaPubblica=false;
	}
	
	public void setID (int id){
		this.id = id;
	}
	
	public long getID (){
		return id;
	}
	
	public void setGraduatoria (long Graduatoria){
		this.Graduatoria = Graduatoria;
	}
	
	public long getGraduatoria (){
		return Graduatoria;
	}
	
	public void setGraduatoriaPubblica (Boolean GraduatoriaPubblica){
		this.GraduatoriaPubblica = GraduatoriaPubblica;
	}
	
	public Boolean getGraduatoriaPubblica (){
		return GraduatoriaPubblica;
	}
}
