package com.picosoft.biz.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity

public class FamillePiece implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idFamillePiece ;
	private String nomFamillePiece ;
	private String description ;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="famillePiece")
	private Set<Piece> piece;
	@OneToOne
	private Modele modele;
	
	
	public Modele getModele() {
		return modele;
	}
	public void setModele(Modele modele) {
		this.modele = modele;
	}
	public int getIdFamillePiece() {
		return idFamillePiece;
	}
	public void setIdFamillePiece(int idFamillePiece) {
		this.idFamillePiece = idFamillePiece;
	}
	public String getNomFamillePiece() {
		return nomFamillePiece;
	}
	public void setNomFamillePiece(String nomFamillePiece) {
		this.nomFamillePiece = nomFamillePiece;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Piece> getPiece() {
		return piece;
	}
	public void setPiece(Set<Piece> piece) {
		this.piece = piece;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
