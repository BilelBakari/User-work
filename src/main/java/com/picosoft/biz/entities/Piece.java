package com.picosoft.biz.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@SuppressWarnings("unused")
public class Piece implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int idPiece ; 
	private String description ;
	private String image ;
	@ManyToOne
	FamillePiece famillePiece;
		public int getIdPiece() {
		return idPiece;
	}
	public void setIdPiece(int idPiece) {
		this.idPiece = idPiece;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public FamillePiece getFamillePiece() {
		return famillePiece;
	}
	public void setFamillePiece(FamillePiece famillePiece) {
		this.famillePiece = famillePiece;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
