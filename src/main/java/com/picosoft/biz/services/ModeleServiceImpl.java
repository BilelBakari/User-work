package com.picosoft.biz.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picosoft.biz.entities.Modele;
import com.picosoft.biz.repository.ModeleRepository;
@Service
public class ModeleServiceImpl implements IModeleService {
	private static final Logger l = LogManager.getLogger(ModeleServiceImpl.class);
	@Autowired
	ModeleRepository modeleRepository ;
	
	@Override
	public Modele addModele(Modele modele) {
		// TODO Auto-generated method stub
		return modeleRepository.save(modele);
	}

	@Override
	public void updateModele(Modele modele, int id) {
		Modele modele2 = modeleRepository.findById(id).get();
		modele2.setNomModele(modele.getNomModele());
		modele2.setDetailsModele(modele.getDetailsModele());
		modeleRepository.save(modele2);
		
	}

	@Override
	public void DeleteModele(int id) {
		modeleRepository.deleteById(id);
		
	}

	@Override
	public List<Modele> retreiveAllModele() {
		List<Modele> listModele = (List<Modele>) modeleRepository.findAll() ;
		for(Modele modele : listModele) {
			l.info("modele : "+modele);
		}
		return listModele;
	}

	@Override
	public void affecterModeleATemplate(int idModele, int idTemp) {
		
	}

	
	
}
