package com.picosoft.biz.entities;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Rapport implements Serializable {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	  @GeneratedValue(generator = "uuid")
	  @GenericGenerator(name = "uuid", strategy = "uuid2")
	  private String idRapport ;
	  private String nom ;
	  private String type ;
	  @Lob
	  private byte[] data;
	public Rapport() {

	}
	public Rapport(String nom,String type , byte[] data) {
		this.nom = nom;
		this.setType(type) ;
		this.data = data;
	}
	public String getIdRapport() {
		return idRapport;
	}
	public void setIdRapport(String idRapport) {
		this.idRapport = idRapport;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Rapport [idRapport=" + idRapport + ", nom=" + nom + ", data=" + Arrays.toString(data) + "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	 
	  
	

}
