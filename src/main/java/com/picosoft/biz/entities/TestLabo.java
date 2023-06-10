package com.picosoft.biz.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;



@Entity

@SuppressWarnings("unused")
public class TestLabo {
	@Id
	private int idTestLabo;
	private String nomTestLabo;
	private Date dateTest;
	private String commentaire;
	@Enumerated(EnumType.STRING)
	ControlePiece controlePiece;
	
	public int getIdTestLabo() {
		return idTestLabo;
	}
	public void setIdTestLabo(int idTestLabo) {
		this.idTestLabo = idTestLabo;
	}
	public String getNomTestLabo() {
		return nomTestLabo;
	}
	public void setNomTestLabo(String nomTestLabo) {
		this.nomTestLabo = nomTestLabo;
	}
	public Date getDateTest() {
		return dateTest;
	}
	public void setDateTest(Date dateTest) {
		this.dateTest = dateTest;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public ControlePiece getControlePiece() {
		return controlePiece;
	}
	public void setControlePiece(ControlePiece controlePiece) {
		this.controlePiece = controlePiece;
	}
	
}
