package com.picosoft.biz.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
@SuppressWarnings("unused")
public class Modele implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idModele;
	private String nomModele;
	private String detailsModele;
	@OneToOne(mappedBy="modele")
	private FamillePiece famillePiece;
	@OneToOne
	private TempEmail tempEmail;
	
	public int getIdModele() {
		return idModele;
	}
	public void setIdModele(int idModele) {
		this.idModele = idModele;
	}
	public String getNomModele() {
		return nomModele;
	}
	public void setNomModele(String nomModele) {
		this.nomModele = nomModele;
	}
	public String getDetailsModele() {
		return detailsModele;
	}
	public void setDetailsModele(String detailsModele) {
		this.detailsModele = detailsModele;
	}
	public FamillePiece getFamillePiece() {
		return famillePiece;
	}
	public void setFamillePiece(FamillePiece famillePiece) {
		this.famillePiece = famillePiece;
	}
	public TempEmail getTempEmail() {
		return tempEmail;
	}
	public void setTempEmail(TempEmail tempEmail) {
		this.tempEmail = tempEmail;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
