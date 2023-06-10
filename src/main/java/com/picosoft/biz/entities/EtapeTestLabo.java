package com.picosoft.biz.entities;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class EtapeTestLabo {
	@Id
	private int idTestLabo;
	@SuppressWarnings("unused")
	private String nomEtapeTest;
	@SuppressWarnings("unused")
	private String nbEtapeTest;

	public int getIdTestLabo() {
		return idTestLabo;
	}
	public void setIdTestLabo(int idTestLabo) {
		this.idTestLabo = idTestLabo;
	}
	public String getNomEtapeTest() {
		return nomEtapeTest;
	}
	public void setNomEtapeTest(String nomEtapeTest) {
		this.nomEtapeTest = nomEtapeTest;
	}
	public String getNbEtapeTest() {
		return nbEtapeTest;
	}
	public void setNbEtapeTest(String nbEtapeTest) {
		this.nbEtapeTest = nbEtapeTest;
	}



	
}
