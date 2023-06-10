package com.picosoft.biz.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picosoft.biz.entities.EtapeTestLabo;
import com.picosoft.biz.repository.EtapeTestLaboRepository;
@Service
public class EtapeTestLaboServiceImpl implements IEtapeTestLaboService {
	private static final Logger l = LogManager.getLogger(EtapeTestLaboServiceImpl.class);
	@Autowired
	EtapeTestLaboRepository etapeTestLaboReposiroty ;
	@Override
	public EtapeTestLabo addEtapeTestLabo(EtapeTestLabo etapeTestLabo) {
		// TODO Auto-generated method stub
		return etapeTestLaboReposiroty.save(etapeTestLabo);
	}

	@Override
	public void updateEtapeTestLabo(EtapeTestLabo etapeTestLabo, int id) {
		EtapeTestLabo etapetestlabo2 = etapeTestLaboReposiroty.findById(id).get();
		etapetestlabo2.setNomEtapeTest(etapeTestLabo.getNomEtapeTest());
		etapetestlabo2.setNbEtapeTest(etapeTestLabo.getNbEtapeTest());
		etapeTestLaboReposiroty.save(etapetestlabo2);
	}

	@Override
	public void DeleteEtapeTestLabo(int id) {
		etapeTestLaboReposiroty.deleteById(id);
	}

	@Override
	public List<EtapeTestLabo> retreiveAllEtapeTestLabo() {
		List<EtapeTestLabo> listEtapeTestLabo = (List<EtapeTestLabo>) etapeTestLaboReposiroty.findAll() ;
		for(EtapeTestLabo etapetest : listEtapeTestLabo) {
			l.info("etape test : "+etapetest);
		}
		return listEtapeTestLabo;
	}
	

}
