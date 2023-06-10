package com.picosoft.biz.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picosoft.biz.entities.EtapeTest;
import com.picosoft.biz.repository.IEtapeTestRepository;
@Service
public class EtapeTestServiceImpl implements IEtapeTestService {
	private static final Logger l = LogManager.getLogger(EtapeTestServiceImpl.class);
	@Autowired
	IEtapeTestRepository etapeTestRepository ;
	@Override
	public EtapeTest addEtapeTest(EtapeTest etapetest) {
		// TODO Auto-generated method stub
		return etapeTestRepository.save(etapetest);
	}

	@Override
	public void updateEtapeTest(EtapeTest etapetest, int id) {
		EtapeTest etapetest2 = etapeTestRepository.findById(id).get();
		etapetest2.setNomEtape(etapetest.getNomEtape());
		etapetest2.setNbEtape(etapetest.getNbEtape());
		etapeTestRepository.save(etapetest2);
		
	}

	@Override
	public void DeleteEtapeTest(int id) {
		// TODO Auto-generated method stub
		etapeTestRepository.deleteById(id);
		
	}

	@Override
	public List<EtapeTest> retreiveAllEtapeTest() {
		List<EtapeTest> listEtapeTest = (List<EtapeTest>) etapeTestRepository.findAll() ;
		for(EtapeTest etapetest : listEtapeTest) {
			l.info("etape test : "+etapetest);
		}
		return listEtapeTest;
	}
	

}
