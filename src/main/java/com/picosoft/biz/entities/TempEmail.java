package com.picosoft.biz.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;




@Entity

@SuppressWarnings("unused")
public class TempEmail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTempEmail;
	@Column(columnDefinition="TEXT")
	private String jsonorHtmlData;
	@OneToOne(mappedBy="tempEmail")
	private Modele modele;
	
	public int getIdTempEmail() {
		return idTempEmail;
	}
	public void setIdTempEmail(int idTempEmail) {
		this.idTempEmail = idTempEmail;
	}
	public String getJsonorHtmlData() {
		return jsonorHtmlData;
	}
	public void setJsonorHtmlData(String jsonorHtmlData) {
		this.jsonorHtmlData = jsonorHtmlData;
	}
	public Modele getModele() {
		return modele;
	}
	public void setModele(Modele modele) {
		this.modele = modele;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
