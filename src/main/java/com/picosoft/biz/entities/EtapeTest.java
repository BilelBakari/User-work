package com.picosoft.biz.entities;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity

public class EtapeTest {
	@Id
	private int idEtapeTest ;
	private String nomEtape ;
	private int nbEtape ;
	private String descriptionEtape ;
	

	public int getIdEtapeTest() {
		return idEtapeTest;
	}
	public void setIdEtapeTest(int idEtapeTest) {
		this.idEtapeTest = idEtapeTest;
	}
	public String getNomEtape() {
		return nomEtape;
	}
	public void setNomEtape(String nomEtape) {
		this.nomEtape = nomEtape;
	}
	public int getNbEtape() {
		return nbEtape;
	}
	public void setNbEtape(int nbEtape) {
		this.nbEtape = nbEtape;
	}
	public String getDescriptionEtape() {
		return descriptionEtape;
	}
	public void setDescriptionEtape(String descriptionEtape) {
		this.descriptionEtape = descriptionEtape;
	}
	

}
