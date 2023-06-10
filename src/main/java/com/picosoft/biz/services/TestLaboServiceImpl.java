package com.picosoft.biz.services;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picosoft.biz.entities.ControlePiece;
import com.picosoft.biz.entities.TestLabo;
import com.picosoft.biz.repository.TestLabRepository;


@Service
public class TestLaboServiceImpl implements ITestLaboService {
	private static final Logger l = LogManager.getLogger(TestLaboServiceImpl.class);
	 @Autowired
	 TestLabRepository labRepository ;
	@Override
	public TestLabo addTestLabo(TestLabo testLabo) {
		Date d = new Date(System.currentTimeMillis());
		testLabo.setDateTest(d);
		testLabo.setControlePiece(ControlePiece.en_cours);
		// TODO Auto-generated method stu
		return labRepository.save(testLabo);
	}

	@Override
	public void updateTestLabo(TestLabo TestLabo, int id) {
		TestLabo testlabo2 = labRepository.findById(id).get();
		testlabo2.setNomTestLabo(TestLabo.getNomTestLabo());
		testlabo2.setDateTest(TestLabo.getDateTest());
		testlabo2.setControlePiece(TestLabo.getControlePiece());
		testlabo2.setCommentaire(TestLabo.getCommentaire());
		labRepository.save(testlabo2);
		
	}

	@Override
	public void DeleteTestLabo(int id) {
		labRepository.deleteById(id);
		
	}

	@Override
	public List<TestLabo> retreiveAllTestLabo() {
		List<TestLabo> listTestLabo = (List<TestLabo>) labRepository.findAll() ;
		for(TestLabo testlabo : listTestLabo) {
			l.info("etape test : "+testlabo);
		}
		return listTestLabo;
	}

}
