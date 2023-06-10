package com.picosoft.biz.services;

import java.util.List;

import com.picosoft.biz.entities.Modele;

public interface IModeleService {
	public Modele addModele(Modele modele);
	public void updateModele(Modele modele ,int id);
	public void DeleteModele(int id);
	public List<Modele> retreiveAllModele() ;
	public void affecterModeleATemplate(int idModele,int idTemp);
	
}
