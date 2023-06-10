package com.picosoft.biz.services;

import java.util.List;

import com.picosoft.biz.entities.EtapeTest;
import com.picosoft.biz.entities.Piece;

public interface IEtapeTestService {
	public EtapeTest addEtapeTest(EtapeTest etapetest);
	public void updateEtapeTest(EtapeTest etapetest ,int id);
	public void DeleteEtapeTest(int id);
	public List<EtapeTest> retreiveAllEtapeTest() ;

}
